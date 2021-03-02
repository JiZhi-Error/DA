package com.tencent.mm.plugin.taskbar.ui.section.weapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import kotlin.g.b.p;

public class TaskBarSectionMyWeAppRecyclerView extends TaskBarSectionWeAppRecyclerView {
    public TaskBarSectionMyWeAppRecyclerView(Context context) {
        super(context);
    }

    public TaskBarSectionMyWeAppRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TaskBarSectionMyWeAppRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final void bF(ArrayList<b.a> arrayList) {
        AppMethodBeat.i(263693);
        int size = getDataList().size();
        Log.i("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "notifyItemInserted %d %d %d %s", 0, Integer.valueOf(size), Integer.valueOf(arrayList.size()), b.lb(getDataList()));
        setDataList(arrayList);
        Log.i("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "notifyItemInserted filled %s", b.lb(arrayList));
        this.adj.cj(0);
        if (size == 8) {
            this.adj.ck(7);
            this.adj.ci(6);
        } else if (size > 8) {
            this.adj.ck(7);
        }
        this.adj.e(0, this.adj.getItemCount(), Boolean.TRUE);
        AppMethodBeat.o(263693);
    }

    public final void bG(ArrayList<b.a> arrayList) {
        boolean z;
        boolean g2;
        AppMethodBeat.i(263694);
        int i2 = 0;
        while (true) {
            if (i2 >= getShowList().size()) {
                i2 = -1;
                break;
            }
            b.a aVar = getShowList().get(i2);
            int i3 = 0;
            while (true) {
                if (i3 >= arrayList.size()) {
                    z = false;
                    break;
                }
                b.a aVar2 = arrayList.get(i3);
                p.h(aVar, "item");
                if (Util.isNullOrNil(aVar2.ooj.username)) {
                    g2 = false;
                } else if (Util.isNullOrNil(aVar.ooj.username)) {
                    g2 = false;
                } else {
                    g2 = aVar.ooj.g(aVar2.ooj);
                }
                if (g2) {
                    z = true;
                    break;
                }
                i3++;
            }
            if (!z) {
                break;
            }
            i2++;
        }
        Log.i("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "notifyItemRemoved %d %d %s", Integer.valueOf(getDataList().size()), Integer.valueOf(arrayList.size()), b.lb(getDataList()));
        setDataList(arrayList);
        Log.i("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "notifyItemInserted filled %s", b.lb(arrayList));
        if (i2 != -1) {
            Log.i("MicroMsg.AppBrandDesktopSectionWeAppRecyclerView", "toRemove %d", Integer.valueOf(i2));
            axl(i2);
            AppMethodBeat.o(263694);
            return;
        }
        if (arrayList.size() == 8) {
            this.adj.ci(7);
        }
        AppMethodBeat.o(263694);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView
    public final void hXg() {
        AppMethodBeat.i(263695);
        if (this.FVT != null) {
            this.FVT.hWX();
        }
        AppMethodBeat.o(263695);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView
    public final void a(RecyclerView.v vVar, b.a aVar) {
        AppMethodBeat.i(263696);
        if (this.FVT != null) {
            this.FVT.a(vVar, aVar, true);
        }
        AppMethodBeat.o(263696);
    }

    @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView
    public final void a(com.tencent.mm.plugin.taskbar.ui.b bVar) {
        AppMethodBeat.i(263697);
        if (this.FVT != null) {
            this.FVT.a(getDataList().get(bVar.lR()), true);
        }
        AppMethodBeat.o(263697);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView
    public final View.OnCreateContextMenuListener a(LocalUsageInfo localUsageInfo, ag agVar) {
        AppMethodBeat.i(263698);
        AnonymousClass1 r0 = new View.OnCreateContextMenuListener() {
            /* class com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionMyWeAppRecyclerView.AnonymousClass1 */

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(263691);
                contextMenu.add(0, 0, 0, R.string.s3);
                AppMethodBeat.o(263691);
            }
        };
        AppMethodBeat.o(263698);
        return r0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView
    public final o.g a(LocalUsageInfo localUsageInfo, ag agVar, final int i2) {
        AppMethodBeat.i(263699);
        AnonymousClass2 r0 = new o.g() {
            /* class com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionMyWeAppRecyclerView.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(263692);
                TaskBarSectionMyWeAppRecyclerView.this.removeItem(i2);
                AppMethodBeat.o(263692);
            }
        };
        AppMethodBeat.o(263699);
        return r0;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.taskbar.ui.section.weapp.TaskBarSectionWeAppRecyclerView
    public final void a(int i2, b.a aVar) {
        AppMethodBeat.i(263700);
        this.FVT.b(aVar, i2);
        AppMethodBeat.o(263700);
    }
}
