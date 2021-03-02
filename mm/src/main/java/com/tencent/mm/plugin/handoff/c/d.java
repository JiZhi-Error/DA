package com.tencent.mm.plugin.handoff.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ao;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0004*\u0001\r\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0007J\u0016\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor;", "", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "addList", "", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "delList", "exists", "", "handler", "com/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$handler$1", "Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$handler$1;", "add", "", "handOff", "apply", "commit", "del", "process", "message", "processAddRequest", "items", "", "processDelRequest", "Companion", "TryEnterFloatBallInternalTask", "plugin-handoff_release"})
public final class d {
    private static final String[] yhY = {ToolsProcessIPCService.dkO, ToolsMpProcessIPCService.dkO};
    public static final a yhZ = new a((byte) 0);
    final Map<String, HandOff> yhU = new LinkedHashMap();
    final Map<String, HandOff> yhV = new LinkedHashMap();
    final Map<String, Boolean> yhW = new LinkedHashMap();
    final b yhX;

    public d(Looper looper) {
        p.h(looper, "looper");
        AppMethodBeat.i(199163);
        this.yhX = new b(this, looper, looper);
        AppMethodBeat.o(199163);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$Companion;", "", "()V", "BROADCAST_PROCESS_NAME", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "MSG_COMMIT", "", "SYNC_INTERVAL", "", "TAG", "plugin-handoff_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(199164);
        AppMethodBeat.o(199164);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/handoff/service/HandOffRequestProcessor$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-handoff_release"})
    public static final class b extends MMHandler {
        final /* synthetic */ d yia;
        final /* synthetic */ Looper yib;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar, Looper looper, Looper looper2) {
            super(looper2);
            this.yia = dVar;
            this.yib = looper;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(199158);
            p.h(message, "msg");
            switch (message.what) {
                case 1:
                    Log.d("HandOff.RequestProcessor", "handle commit message");
                    d.a(this.yia);
                    break;
            }
            AppMethodBeat.o(199158);
        }
    }

    private static void j(Collection<? extends HandOff> collection) {
        int i2;
        AppMethodBeat.i(199161);
        try {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                HandOff aBy = ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).aBy(it.next().getId());
                if (aBy != null) {
                    if (ao.isMultiTaskMode()) {
                        MultiTaskInfo taskInfoById = ((com.tencent.mm.plugin.multitask.d) g.ah(com.tencent.mm.plugin.multitask.d.class)).getTaskInfoById(aBy.getKey());
                        if (taskInfoById != null) {
                            ((com.tencent.mm.plugin.multitask.d) g.ah(com.tencent.mm.plugin.multitask.d.class)).removeTaskInfoAndCoverImg(taskInfoById.field_id);
                        }
                    } else {
                        switch (aBy.getDataType()) {
                            case 1:
                                i2 = 4;
                                break;
                            case 2:
                                i2 = 2;
                                break;
                            case 3:
                                i2 = 1;
                                break;
                            default:
                                i2 = 0;
                                break;
                        }
                        BallInfo h2 = ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).h(new BallInfo(i2, aBy.getKey()));
                        if (h2 != null) {
                            ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).l(h2);
                        }
                    }
                }
            }
            AppMethodBeat.o(199161);
        } catch (Exception e2) {
            Log.d("HandOff.RequestProcessor", "delete handoff fail: " + e2.getLocalizedMessage());
            AppMethodBeat.o(199161);
        }
    }

    private static void k(Collection<? extends HandOff> collection) {
        int i2;
        AppMethodBeat.i(199162);
        try {
            for (T t : collection) {
                int dYp = a.dYp();
                if (dYp <= 0) {
                    Log.i("HandOff.RequestProcessor", "cannot add float ball, availableCount = ".concat(String.valueOf(dYp)));
                    FloatBallProxyUI.a(3, c.yic);
                } else if (ao.isMultiTaskMode()) {
                    o<cru, byte[]> createMultiTaskInfo = t.createMultiTaskInfo();
                    if (createMultiTaskInfo != null) {
                        switch (t.getDataType()) {
                            case 1:
                                i2 = 4;
                                break;
                            case 2:
                                i2 = 2;
                                break;
                            case 3:
                                i2 = 1;
                                break;
                            default:
                                i2 = 0;
                                break;
                        }
                        ((com.tencent.mm.plugin.multitask.d) g.ah(com.tencent.mm.plugin.multitask.d.class)).addTaskInfo(t.getKey(), i2, createMultiTaskInfo.first, (byte[]) createMultiTaskInfo.second, null);
                    }
                } else {
                    BallInfo createBallInfo = t.createBallInfo();
                    if (createBallInfo != null) {
                        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).j(createBallInfo);
                    }
                }
            }
            AppMethodBeat.o(199162);
        } catch (Exception e2) {
            Log.d("HandOff.RequestProcessor", "add handoff fail: " + e2.getLocalizedMessage());
            AppMethodBeat.o(199162);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "proxyMode", "", "result", "onCallback"})
    public static final class c implements FloatBallProxyUI.a {
        public static final c yic = new c();

        static {
            AppMethodBeat.i(199160);
            AppMethodBeat.o(199160);
        }

        c() {
        }

        @Override // com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a
        public final void eU(int i2, int i3) {
            AppMethodBeat.i(199159);
            Log.i("MicroMsg.FloatBallService", "addBallInfo by handoff, show reach count limit callback:%s, proxyMode: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            AppMethodBeat.o(199159);
        }
    }

    public static final /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(199165);
        Map<String, HandOff> map = dVar.yhV;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, HandOff> entry : map.entrySet()) {
            if (p.j(dVar.yhW.get(entry.getKey()), Boolean.TRUE)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        j(linkedHashMap.values());
        Map<String, HandOff> map2 = dVar.yhU;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, HandOff> entry2 : map2.entrySet()) {
            if (p.j(dVar.yhW.get(entry2.getKey()), Boolean.FALSE)) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        k(linkedHashMap2.values());
        dVar.yhU.clear();
        dVar.yhV.clear();
        dVar.yhW.clear();
        AppMethodBeat.o(199165);
    }
}
