package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader_app.a.c;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.downloader_app.a.j;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class TaskListView extends MRecyclerView {
    private Map<String, i> qKZ = new HashMap();
    b qNf;
    DownloadMainUI.a qNg;
    boolean qNh;
    private d.AbstractC0946d qNi = new d.AbstractC0946d() {
        /* class com.tencent.mm.plugin.downloader_app.ui.TaskListView.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.downloader_app.a.d.AbstractC0946d
        public final void O(int i2, long j2) {
            AppMethodBeat.i(9062);
            a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(j2);
            if (Cw != null) {
                TaskListView.a(TaskListView.this, i2, Cw.field_appId);
            }
            AppMethodBeat.o(9062);
        }
    };
    private d.a qNj = new d.a() {
        /* class com.tencent.mm.plugin.downloader_app.ui.TaskListView.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.downloader_app.a.d.a
        public final void kZ(boolean z) {
            AppMethodBeat.i(9063);
            TaskListView taskListView = TaskListView.this;
            Iterator<E> it = taskListView.qNf.qMX.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (next.cCd()) {
                    next.isSelected = z;
                }
            }
            taskListView.qNf.atj.notifyChanged();
            d.kY(z);
            AppMethodBeat.o(9063);
        }
    };
    private d.b qNk = new d.b() {
        /* class com.tencent.mm.plugin.downloader_app.ui.TaskListView.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.downloader_app.a.d.b
        public final void onClick() {
            AppMethodBeat.i(9064);
            TaskListView taskListView = TaskListView.this;
            h.c(taskListView.getContext(), taskListView.getContext().getString(R.string.bll), "", taskListView.getContext().getString(R.string.hla), taskListView.getContext().getString(R.string.hl_), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.ui.TaskListView.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    int i3;
                    AppMethodBeat.i(9070);
                    TaskListView taskListView = TaskListView.this;
                    LinkedList<i> linkedList = new LinkedList<>();
                    Iterator<E> it = taskListView.qNf.qMX.iterator();
                    while (it.hasNext()) {
                        E next = it.next();
                        if (next.isSelected) {
                            linkedList.add(next);
                            j.EN(next.appId);
                            c.a(next);
                            switch (next.type) {
                                case 2:
                                    i3 = 1101;
                                    break;
                                case 3:
                                case 5:
                                default:
                                    i3 = 0;
                                    break;
                                case 4:
                                    i3 = 1102;
                                    break;
                                case 6:
                                    i3 = 1103;
                                    break;
                            }
                            com.tencent.mm.plugin.downloader_app.b.a.a(11, i3, next.position, 81, next.appId, "", "");
                        }
                    }
                    if (linkedList.size() != 0) {
                        taskListView.qNf.Y(linkedList);
                        if (taskListView.qNf.cCb()) {
                            taskListView.cCr();
                        }
                    }
                    d.kY(false);
                    AppMethodBeat.o(9070);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.downloader_app.ui.TaskListView.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(9064);
        }
    };
    private d.f qNl = new d.f() {
        /* class com.tencent.mm.plugin.downloader_app.ui.TaskListView.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.downloader_app.a.d.f
        public final void alx(String str) {
            AppMethodBeat.i(9065);
            TaskListView.a(TaskListView.this, str);
            AppMethodBeat.o(9065);
        }
    };
    private d.e qNm = new d.e() {
        /* class com.tencent.mm.plugin.downloader_app.ui.TaskListView.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.downloader_app.a.d.e
        public final void alw(String str) {
            AppMethodBeat.i(9066);
            TaskListView.b(TaskListView.this, str);
            AppMethodBeat.o(9066);
        }
    };
    private d.g qNn = new d.g() {
        /* class com.tencent.mm.plugin.downloader_app.ui.TaskListView.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.downloader_app.a.d.g
        public final void aly(String str) {
            AppMethodBeat.i(9067);
            TaskListView.c(TaskListView.this, str);
            AppMethodBeat.o(9067);
        }
    };
    private boolean qNo = true;

    public TaskListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(9071);
        AppMethodBeat.o(9071);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(9072);
        super.onFinishInflate();
        Log.d("MicroMsg.TaskListView", "onFinishInflate");
        getContext();
        setLayoutManager(new LinearLayoutManager());
        this.qNf = new b(getContext());
        setAdapter(this.qNf);
        a(new a(getResources()));
        setOnItemLongClickListener(new MRecyclerView.b() {
            /* class com.tencent.mm.plugin.downloader_app.ui.TaskListView.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b
            public final boolean T(View view, int i2) {
                com.tencent.mm.plugin.game.commlib.c.c<i> cVar;
                AppMethodBeat.i(9068);
                if (!TaskListView.this.qNo) {
                    AppMethodBeat.o(9068);
                    return false;
                }
                if ((((ViewGroup) view).getChildAt(0) instanceof TaskItemView) && (cVar = TaskListView.this.qNf.qMX) != null) {
                    Iterator<E> it = cVar.iterator();
                    while (it.hasNext()) {
                        it.next().pSk = true;
                    }
                    ((TaskItemView) ((ViewGroup) view).getChildAt(0)).setSelected(true);
                    TaskListView.c(TaskListView.this);
                }
                AppMethodBeat.o(9068);
                return true;
            }
        });
        setOnItemClickListener(new MRecyclerView.a() {
            /* class com.tencent.mm.plugin.downloader_app.ui.TaskListView.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a
            public final void S(View view, int i2) {
                boolean z;
                AppMethodBeat.i(9069);
                Log.d("MicroMsg.TaskListView", "onItemClick");
                View childAt = ((ViewGroup) view).getChildAt(0);
                com.tencent.mm.plugin.game.commlib.c.c<i> cVar = TaskListView.this.qNf.qMX;
                if (i2 < 0 || i2 >= cVar.size()) {
                    AppMethodBeat.o(9069);
                    return;
                }
                i iVar = (i) cVar.get(i2);
                if (iVar.type == 7) {
                    b bVar = TaskListView.this.qNf;
                    if (!bVar.qNc) {
                        bVar.qNc = true;
                        bVar.atj.notifyChanged();
                    }
                    com.tencent.mm.plugin.downloader_app.b.a.a(10, 1004, 101, 2, "", "", "");
                    AppMethodBeat.o(9069);
                } else if (!TaskListView.this.qNo) {
                    if (!iVar.isSelected) {
                        z = true;
                    } else {
                        z = false;
                    }
                    childAt.setSelected(z);
                    AppMethodBeat.o(9069);
                } else if (Util.isNullOrNil(iVar.jumpUrl)) {
                    AppMethodBeat.o(9069);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("rawUrl", iVar.jumpUrl);
                    ((com.tencent.mm.plugin.downloader_app.api.c) g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).e(TaskListView.this.getContext(), bundle);
                    com.tencent.mm.plugin.downloader_app.b.a.a(10, com.tencent.mm.plugin.downloader_app.b.a.Fq(iVar.type), iVar.position, 40, iVar.appId, "", "");
                    AppMethodBeat.o(9069);
                }
            }
        });
        AppMethodBeat.o(9072);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onAttachedToWindow() {
        AppMethodBeat.i(9073);
        super.onAttachedToWindow();
        d.a(this.qNi);
        d.a(this.qNj);
        d.a(this.qNk);
        d.a(this.qNl);
        d.a(this.qNm);
        d.a(this.qNn);
        AppMethodBeat.o(9073);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onDetachedFromWindow() {
        AppMethodBeat.i(9074);
        super.onDetachedFromWindow();
        d.b(this.qNi);
        d.b(this.qNj);
        d.b(this.qNk);
        d.b(this.qNl);
        d.b(this.qNm);
        d.b(this.qNn);
        AppMethodBeat.o(9074);
    }

    public void setData(LinkedList<i> linkedList) {
        AppMethodBeat.i(9075);
        Iterator<i> it = linkedList.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!Util.isNullOrNil(next.appId)) {
                this.qKZ.put(next.appId, next);
            }
        }
        b bVar = this.qNf;
        bVar.qMX.clear();
        com.tencent.mm.plugin.game.commlib.c.c<i> cVar = bVar.qMX;
        for (i iVar : linkedList) {
            cVar.b(iVar);
        }
        bVar.qMX.b(new i(1));
        bVar.qMX.b(new i(3));
        bVar.qMX.b(new i(5));
        bVar.qMX.b(new i(7));
        bVar.atj.notifyChanged();
        AppMethodBeat.o(9075);
    }

    private void b(i iVar) {
        AppMethodBeat.i(9076);
        b bVar = this.qNf;
        bVar.qMX.remove(iVar);
        bVar.qMX.c(iVar);
        p.y(new Runnable() {
            /* class com.tencent.mm.plugin.downloader_app.ui.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(9051);
                b.this.atj.notifyChanged();
                AppMethodBeat.o(9051);
            }
        });
        AppMethodBeat.o(9076);
    }

    public int getSize() {
        AppMethodBeat.i(9077);
        int size = this.qNf.qMX.size();
        AppMethodBeat.o(9077);
        return size;
    }

    public final void cCr() {
        AppMethodBeat.i(9078);
        this.qNh = false;
        if (this.qNg != null) {
            this.qNg.lf(false);
        }
        com.tencent.mm.plugin.game.commlib.c.c<i> cVar = this.qNf.qMX;
        if (this.qNf.cCb()) {
            ((DownloadMainUI) getContext()).le(true);
            AppMethodBeat.o(9078);
            return;
        }
        Iterator<E> it = cVar.iterator();
        while (it.hasNext()) {
            E next = it.next();
            next.pSk = false;
            next.isSelected = false;
        }
        this.qNf.qNd = true;
        this.qNf.atj.notifyChanged();
        this.qNo = true;
        AppMethodBeat.o(9078);
    }

    static /* synthetic */ void a(TaskListView taskListView, int i2, String str) {
        AppMethodBeat.i(9079);
        if (taskListView.qKZ.containsKey(str)) {
            i iVar = taskListView.qKZ.get(str);
            if (i2 == 9) {
                iVar.type = 6;
                taskListView.b(iVar);
                AppMethodBeat.o(9079);
                return;
            } else if (iVar.type == 6) {
                iVar.type = 2;
                taskListView.b(iVar);
                AppMethodBeat.o(9079);
                return;
            } else {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) taskListView.getLayoutManager();
                int childCount = linearLayoutManager.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (linearLayoutManager.getChildAt(i3) != null) {
                        View childAt = ((ViewGroup) linearLayoutManager.getChildAt(i3)).getChildAt(0);
                        if (childAt.getVisibility() == 0 && (childAt instanceof TaskItemView)) {
                            TaskItemView taskItemView = (TaskItemView) childAt;
                            Log.i("MicroMsg.TaskItemView", "refreshDownloadStatus, event = %s, appId: %s", Integer.valueOf(i2), str);
                            if (!(taskItemView.qLZ.getVisibility() == 0 || !str.equals(taskItemView.qMx.appId) || com.tencent.mm.plugin.downloader.model.d.alb(taskItemView.qMx.appId) == null)) {
                                if (!(i2 == 1 || i2 == 7)) {
                                    taskItemView.qMU = false;
                                }
                                taskItemView.cCq();
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(9079);
    }

    static /* synthetic */ void a(TaskListView taskListView, String str) {
        AppMethodBeat.i(9080);
        i iVar = taskListView.qKZ.get(str);
        if (iVar != null) {
            if (iVar.type == 6) {
                iVar.type = 2;
                taskListView.b(iVar);
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) taskListView.getLayoutManager();
            int childCount = linearLayoutManager.getChildCount();
            for (int i2 = 0; i2 <= childCount; i2++) {
                if (linearLayoutManager.getChildAt(i2) != null) {
                    View childAt = ((ViewGroup) linearLayoutManager.getChildAt(i2)).getChildAt(0);
                    if (childAt.getVisibility() == 0 && (childAt instanceof TaskItemView)) {
                        TaskItemView taskItemView = (TaskItemView) childAt;
                        if (taskItemView.qMx.appId.equals(str)) {
                            Log.i("MicroMsg.TaskItemView", "onTaskPreStartDownload, appId: %s", str);
                            taskItemView.qMU = true;
                            taskItemView.post(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0063: INVOKE  
                                  (r1v6 'taskItemView' com.tencent.mm.plugin.downloader_app.ui.TaskItemView)
                                  (wrap: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$5 : 0x0060: CONSTRUCTOR  (r5v6 com.tencent.mm.plugin.downloader_app.ui.TaskItemView$5) = (r1v6 'taskItemView' com.tencent.mm.plugin.downloader_app.ui.TaskItemView) call: com.tencent.mm.plugin.downloader_app.ui.TaskItemView.5.<init>(com.tencent.mm.plugin.downloader_app.ui.TaskItemView):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: com.tencent.mm.plugin.downloader_app.ui.TaskItemView.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.downloader_app.ui.TaskListView.a(com.tencent.mm.plugin.downloader_app.ui.TaskListView, java.lang.String):void, file: classes6.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:210)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0060: CONSTRUCTOR  (r5v6 com.tencent.mm.plugin.downloader_app.ui.TaskItemView$5) = (r1v6 'taskItemView' com.tencent.mm.plugin.downloader_app.ui.TaskItemView) call: com.tencent.mm.plugin.downloader_app.ui.TaskItemView.5.<init>(com.tencent.mm.plugin.downloader_app.ui.TaskItemView):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.downloader_app.ui.TaskListView.a(com.tencent.mm.plugin.downloader_app.ui.TaskListView, java.lang.String):void, file: classes6.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 39 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.downloader_app.ui.TaskItemView, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 45 more
                                */
                            /*
                            // Method dump skipped, instructions count: 110
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.downloader_app.ui.TaskListView.a(com.tencent.mm.plugin.downloader_app.ui.TaskListView, java.lang.String):void");
                        }

                        static /* synthetic */ void b(TaskListView taskListView, String str) {
                            AppMethodBeat.i(9081);
                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) taskListView.getLayoutManager();
                            int childCount = linearLayoutManager.getChildCount();
                            for (int i2 = 0; i2 <= childCount; i2++) {
                                if (linearLayoutManager.getChildAt(i2) != null) {
                                    View childAt = ((ViewGroup) linearLayoutManager.getChildAt(i2)).getChildAt(0);
                                    if (childAt.getVisibility() == 0 && (childAt instanceof TaskItemView)) {
                                        TaskItemView taskItemView = (TaskItemView) childAt;
                                        if (taskItemView.qMx.appId.equals(str)) {
                                            Log.i("MicroMsg.TaskItemView", "onOrderWifiDownload, appId: %s", str);
                                            taskItemView.qMU = false;
                                            taskItemView.post(
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004e: INVOKE  
                                                  (r1v5 'taskItemView' com.tencent.mm.plugin.downloader_app.ui.TaskItemView)
                                                  (wrap: com.tencent.mm.plugin.downloader_app.ui.TaskItemView$6 : 0x004b: CONSTRUCTOR  (r5v6 com.tencent.mm.plugin.downloader_app.ui.TaskItemView$6) = (r1v5 'taskItemView' com.tencent.mm.plugin.downloader_app.ui.TaskItemView) call: com.tencent.mm.plugin.downloader_app.ui.TaskItemView.6.<init>(com.tencent.mm.plugin.downloader_app.ui.TaskItemView):void type: CONSTRUCTOR)
                                                 type: VIRTUAL call: com.tencent.mm.plugin.downloader_app.ui.TaskItemView.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.downloader_app.ui.TaskListView.b(com.tencent.mm.plugin.downloader_app.ui.TaskListView, java.lang.String):void, file: classes6.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:210)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: CONSTRUCTOR  (r5v6 com.tencent.mm.plugin.downloader_app.ui.TaskItemView$6) = (r1v5 'taskItemView' com.tencent.mm.plugin.downloader_app.ui.TaskItemView) call: com.tencent.mm.plugin.downloader_app.ui.TaskItemView.6.<init>(com.tencent.mm.plugin.downloader_app.ui.TaskItemView):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.downloader_app.ui.TaskListView.b(com.tencent.mm.plugin.downloader_app.ui.TaskListView, java.lang.String):void, file: classes6.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                	... 34 more
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.downloader_app.ui.TaskItemView, state: GENERATED_AND_UNLOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                	... 40 more
                                                */
                                            /*
                                                r8 = 9081(0x2379, float:1.2725E-41)
                                                r3 = 0
                                                com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
                                                android.support.v7.widget.RecyclerView$LayoutManager r0 = r9.getLayoutManager()
                                                android.support.v7.widget.LinearLayoutManager r0 = (android.support.v7.widget.LinearLayoutManager) r0
                                                int r4 = r0.getChildCount()
                                                r2 = r3
                                            L_0x0011:
                                                if (r2 > r4) goto L_0x0055
                                                android.view.View r1 = r0.getChildAt(r2)
                                                if (r1 == 0) goto L_0x0051
                                                android.view.View r1 = r0.getChildAt(r2)
                                                android.view.ViewGroup r1 = (android.view.ViewGroup) r1
                                                android.view.View r1 = r1.getChildAt(r3)
                                                int r5 = r1.getVisibility()
                                                if (r5 != 0) goto L_0x0051
                                                boolean r5 = r1 instanceof com.tencent.mm.plugin.downloader_app.ui.TaskItemView
                                                if (r5 == 0) goto L_0x0051
                                                com.tencent.mm.plugin.downloader_app.ui.TaskItemView r1 = (com.tencent.mm.plugin.downloader_app.ui.TaskItemView) r1
                                                com.tencent.mm.plugin.downloader_app.a.i r5 = r1.qMx
                                                java.lang.String r5 = r5.appId
                                                boolean r5 = r5.equals(r10)
                                                if (r5 == 0) goto L_0x0051
                                                java.lang.String r5 = "MicroMsg.TaskItemView"
                                                java.lang.String r6 = "onOrderWifiDownload, appId: %s"
                                                r7 = 1
                                                java.lang.Object[] r7 = new java.lang.Object[r7]
                                                r7[r3] = r10
                                                com.tencent.mm.sdk.platformtools.Log.i(r5, r6, r7)
                                                r1.qMU = r3
                                                com.tencent.mm.plugin.downloader_app.ui.TaskItemView$6 r5 = new com.tencent.mm.plugin.downloader_app.ui.TaskItemView$6
                                                r5.<init>()
                                                r1.post(r5)
                                            L_0x0051:
                                                int r1 = r2 + 1
                                                r2 = r1
                                                goto L_0x0011
                                            L_0x0055:
                                                com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.downloader_app.ui.TaskListView.b(com.tencent.mm.plugin.downloader_app.ui.TaskListView, java.lang.String):void");
                                        }

                                        static /* synthetic */ void c(TaskListView taskListView, String str) {
                                            AppMethodBeat.i(9082);
                                            LinkedList<i> linkedList = new LinkedList<>();
                                            int i2 = 0;
                                            Iterator<E> it = taskListView.qNf.qMX.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                E next = it.next();
                                                if (next.appId.equals(str)) {
                                                    linkedList.add(next);
                                                    j.EN(next.appId);
                                                    break;
                                                }
                                                i2++;
                                            }
                                            if (linkedList.size() != 0) {
                                                taskListView.qNf.Y(linkedList);
                                                taskListView.qNf.ck(i2);
                                            }
                                            AppMethodBeat.o(9082);
                                        }

                                        static /* synthetic */ void c(TaskListView taskListView) {
                                            AppMethodBeat.i(9083);
                                            taskListView.qNh = true;
                                            com.tencent.mm.plugin.game.commlib.c.c<i> cVar = taskListView.qNf.qMX;
                                            if (Util.isNullOrNil(cVar)) {
                                                Log.i("MicroMsg.TaskListView", "enterTaskManagerView, list is nil");
                                                AppMethodBeat.o(9083);
                                                return;
                                            }
                                            taskListView.qNh = true;
                                            Iterator<E> it = cVar.iterator();
                                            while (it.hasNext()) {
                                                it.next().pSk = true;
                                            }
                                            if (taskListView.qNg != null) {
                                                taskListView.qNg.lf(true);
                                            }
                                            taskListView.qNf.qNd = false;
                                            taskListView.qNf.atj.notifyChanged();
                                            taskListView.qNo = false;
                                            d.kY(true);
                                            com.tencent.mm.plugin.downloader_app.b.a.a(11, 0, 0, 1, "", "", "");
                                            com.tencent.mm.plugin.downloader_app.b.a.a(11, 0, 0, 1, "", "", "");
                                            AppMethodBeat.o(9083);
                                        }
                                    }
