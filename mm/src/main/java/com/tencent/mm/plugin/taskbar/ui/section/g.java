package com.tencent.mm.plugin.taskbar.ui.section;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "", "sectionType", "", "multiTaskTypes", "", "(I[I)V", "getMultiTaskTypes", "()[I", "sectionData", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSectionData", "()Ljava/util/List;", "setSectionData", "(Ljava/util/List;)V", "getSectionType", "()I", "showDataList", "getShowDataList", "updateShowData", "", "Companion", "plugin-taskbar_release"})
public final class g {
    private static final g FVK = new g(-1, new int[0]);
    public static final a FVL = new a((byte) 0);
    public List<MultiTaskInfo> FVH = new ArrayList();
    public final List<MultiTaskInfo> FVI = new ArrayList();
    public final int[] FVJ;
    public final int FVr;

    public g(int i2, int[] iArr) {
        p.h(iArr, "multiTaskTypes");
        AppMethodBeat.i(238523);
        this.FVr = i2;
        this.FVJ = iArr;
        AppMethodBeat.o(238523);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0010j\b\u0012\u0004\u0012\u00020\f`\u0011J\n\u0010\u000e\u001a\u00020\n*\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel$Companion;", "", "()V", "DUMMY", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "getDUMMY", "()Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "TAG", "", "blockShowSnapshot", "", "multiTaskType", "", "checkBlockedByTeenMode", "shouldLoadSnapshot", "typeBlockedByExpt", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "plugin-taskbar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ArrayList<Integer> hXe() {
            AppMethodBeat.i(263595);
            ArrayList<Integer> arrayList = new ArrayList<>();
            String a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_taskbar_disable_other_type_show, "-1");
            try {
                p.g(a2, "expt");
                for (String str : n.b(a2, new String[]{","})) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                }
            } catch (Throwable th) {
                Log.i("MicroMsg.TaskBarSectionViewModel", StateEvent.ProcessResult.FAILED, th);
            }
            Log.i("MicroMsg.TaskBarSectionViewModel", "block expt: ".concat(String.valueOf(a2)));
            AppMethodBeat.o(263595);
            return arrayList;
        }

        public static boolean axi(int i2) {
            boolean z;
            AppMethodBeat.i(263596);
            if (!axj(i2)) {
                switch (i2) {
                    case 2:
                    case 3:
                    case 4:
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (z) {
                    AppMethodBeat.o(263596);
                    return true;
                }
            }
            AppMethodBeat.o(263596);
            return false;
        }

        private static boolean axj(int i2) {
            AppMethodBeat.i(263597);
            String a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_taskbar_disable_snapshot_show, "-1");
            Log.i("MicroMsg.TaskBarSectionViewModel", "block expt: ".concat(String.valueOf(a2)));
            try {
                p.g(a2, "expt");
                Iterator<T> it = n.a(a2, new String[]{","}).iterator();
                while (it.hasNext()) {
                    if (i2 == Integer.parseInt(it.next())) {
                        AppMethodBeat.o(263597);
                        return true;
                    }
                }
            } catch (Throwable th) {
                Log.i("MicroMsg.TaskBarSectionViewModel", StateEvent.ProcessResult.FAILED, th);
            }
            AppMethodBeat.o(263597);
            return false;
        }

        public static boolean abK(int i2) {
            AppMethodBeat.i(238520);
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
            p.g(af, "MMKernel.service(ITeenModeService::class.java)");
            if (!((com.tencent.mm.plugin.teenmode.a.b) af).Vt()) {
                AppMethodBeat.o(238520);
                return false;
            }
            switch (i2) {
                case 1:
                    com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
                    p.g(af2, "MMKernel.service(ITeenModeService::class.java)");
                    if (((com.tencent.mm.plugin.teenmode.a.b) af2).fvp() == 2) {
                        AppMethodBeat.o(238520);
                        return true;
                    }
                    AppMethodBeat.o(238520);
                    return false;
                case 2:
                    com.tencent.mm.kernel.c.a af3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
                    p.g(af3, "MMKernel.service(ITeenModeService::class.java)");
                    if (((com.tencent.mm.plugin.teenmode.a.b) af3).fvo() == 2) {
                        AppMethodBeat.o(238520);
                        return true;
                    }
                    AppMethodBeat.o(238520);
                    return false;
                case 21:
                case 22:
                    com.tencent.mm.kernel.c.a af4 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
                    p.g(af4, "MMKernel.service(ITeenModeService::class.java)");
                    if (((com.tencent.mm.plugin.teenmode.a.b) af4).dxW() == 2) {
                        AppMethodBeat.o(238520);
                        return true;
                    }
                    AppMethodBeat.o(238520);
                    return false;
                default:
                    AppMethodBeat.o(238520);
                    return false;
            }
        }
    }

    static {
        AppMethodBeat.i(238524);
        AppMethodBeat.o(238524);
    }
}
