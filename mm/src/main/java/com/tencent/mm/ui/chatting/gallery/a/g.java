package com.tencent.mm.ui.chatting.gallery.a;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 .2\u00020\u0001:\u0007-./0123B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005JH\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000526\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010 J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0010J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005J\u0016\u0010$\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0006\u0010(\u001a\u00020\u0013J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0006\u0010*\u001a\u00020\u0013J\u0016\u0010+\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\nX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\u0004j\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e`\u0007X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "", "()V", "actionList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "Lkotlin/collections/HashMap;", "actionTypeSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "detectResult", "minPriorityActionType", "pendingRunTasks", "Lcom/tencent/threadpool/runnable/FutureEx;", "canShow", "", "type", "cancelAction", "", "cancelLowerPriorityAction", "checkOnOverTime", "disableAction", "forEachAction", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentAction", "targetAction", "getMinPriorityActionType", "getStatus", "(I)Ljava/lang/Integer;", "defaultStatus", "isAllValid", "isValid", "postAction", NativeProtocol.WEB_DIALOG_ACTION, "Ljava/lang/Runnable;", "removeStatus", "reset", "setHigherPriorityActionOverTime", "updateAllStatusIfNeedOnOverTime", "updateStatus", "status", "Action", "Companion", "DefaultAction", "ScanCodeAction", "ScanTranslationAction", "SearchHotImageAction", "SearchNormalImageAction", "app_release"})
public final class g {
    public static final b PCo = new b((byte) 0);
    public HashSet<Integer> PCj = new HashSet<>();
    public HashMap<Integer, a> PCk = new HashMap<>();
    public final HashMap<Integer, Integer> PCl = new HashMap<>();
    private HashMap<Integer, com.tencent.f.i.d<?>> PCm = new HashMap<>();
    private int PCn;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&¨\u0006\r"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "", "delayDuration", "", "enable", "", "getType", "", DownloadInfo.PRIORITY, "setEnable", "", "show", "valid", "app_release"})
    public interface a {
        boolean enable();

        boolean gTx();

        int gTy();

        long gTz();

        int getType();

        void setEnable(boolean z);

        boolean valid();
    }

    static {
        AppMethodBeat.i(231258);
        AppMethodBeat.o(231258);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "targetAction", "invoke"})
    public static final class h extends q implements m<a, a, x> {
        final /* synthetic */ g PCq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(g gVar) {
            super(2);
            this.PCq = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(a aVar, a aVar2) {
            AppMethodBeat.i(231242);
            a aVar3 = aVar;
            a aVar4 = aVar2;
            p.h(aVar3, NativeProtocol.WEB_DIALOG_ACTION);
            p.h(aVar4, "targetAction");
            if (aVar3.gTy() > aVar4.gTy()) {
                Log.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo cancelLowerPriorityAction type: %d, targetActionType: %d", Integer.valueOf(aVar3.getType()), Integer.valueOf(aVar4.getType()));
                this.PCq.anu(aVar4.getType());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(231242);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "targetAction", "invoke"})
    public static final class j extends q implements m<a, a, x> {
        final /* synthetic */ int $type;
        final /* synthetic */ g PCq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(g gVar, int i2) {
            super(2);
            this.PCq = gVar;
            this.$type = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(a aVar, a aVar2) {
            AppMethodBeat.i(231244);
            a aVar3 = aVar;
            a aVar4 = aVar2;
            p.h(aVar3, NativeProtocol.WEB_DIALOG_ACTION);
            p.h(aVar4, "targetAction");
            if (aVar3.gTy() < aVar4.gTy() && g.a(this.PCq, this.$type) == null) {
                Log.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo setHigherPriorityActionOverTime type: %d, targetType: %d", Integer.valueOf(this.$type), Integer.valueOf(aVar4.getType()));
                this.PCq.li(aVar4.getType(), 4);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(231244);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Companion;", "", "()V", "DEFAULT_POST_ACTION_DELAY", "", "PRIORITY_QRCODE", "", "PRIORITY_SEARCH_IMAGE_HOT", "PRIORITY_SEARCH_IMAGE_NORMAL", "PRIORITY_TRANSLATION", "STATUS_CAN_NOT_SHOW", "STATUS_NO_RESULT", "STATUS_OVER_TIME_LIMIT", "STATUS_RESULT_BUT_NOT_SHOW", "STATUS_SHOW", "TAG", "", "TYPE_DETECT_QRCODE", "TYPE_DETECT_SEARCH_IMAGE_HOT", "TYPE_DETECT_SEARCH_IMAGE_NORMAL", "TYPE_DETECT_TRANSLATION", "TYPE_NONE", "app_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ Integer a(g gVar, int i2) {
        AppMethodBeat.i(231259);
        Integer ant = gVar.ant(i2);
        AppMethodBeat.o(231259);
        return ant;
    }

    public g() {
        AppMethodBeat.i(231257);
        this.PCj.add(1);
        this.PCk.put(1, new e(this));
        if (e.gTr()) {
            this.PCj.add(2);
            this.PCk.put(2, new d(this));
        }
        if (e.gTs()) {
            this.PCj.add(4);
            this.PCk.put(4, new C2095g(this));
        }
        if (e.gTt()) {
            this.PCj.add(3);
            this.PCk.put(3, new f(this));
        }
        this.PCn = gTw();
        Log.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo init minPriorityActionType: %d", Integer.valueOf(this.PCn));
        AppMethodBeat.o(231257);
    }

    public final void li(int i2, int i3) {
        AppMethodBeat.i(231245);
        if (this.PCk.get(Integer.valueOf(i2)) == null) {
            AppMethodBeat.o(231245);
            return;
        }
        Log.v("MicroMsg.ImageScanButtonStatusManager", "alvinluo updateStatus type: %d, status: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        Integer ant = ant(i2);
        if (ant != null && ant.intValue() == 4) {
            Log.w("MicroMsg.ImageScanButtonStatusManager", "alvinluo updateStatus type: %d over time limit", Integer.valueOf(i2));
            AppMethodBeat.o(231245);
            return;
        }
        this.PCl.put(Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(231245);
    }

    public final int ans(int i2) {
        AppMethodBeat.i(231246);
        Integer num = this.PCl.get(Integer.valueOf(i2));
        if (num != null) {
            num.intValue();
            int intValue = num.intValue();
            AppMethodBeat.o(231246);
            return intValue;
        }
        AppMethodBeat.o(231246);
        return 2;
    }

    public final Integer ant(int i2) {
        AppMethodBeat.i(231247);
        Integer num = this.PCl.get(Integer.valueOf(i2));
        AppMethodBeat.o(231247);
        return num;
    }

    public final boolean oe(int i2) {
        AppMethodBeat.i(231248);
        if (i2 != 2) {
            a aVar = this.PCk.get(Integer.valueOf(i2));
            if (aVar == null) {
                AppMethodBeat.o(231248);
                return false;
            }
            boolean gTx = aVar.gTx();
            Log.i("MicroMsg.ImageScanButtonStatusManager", "alvinluo canShow type: %d, show: %b", Integer.valueOf(i2), Boolean.valueOf(gTx));
            AppMethodBeat.o(231248);
            return gTx;
        } else if (ans(2) == 1) {
            AppMethodBeat.o(231248);
            return true;
        } else {
            AppMethodBeat.o(231248);
            return false;
        }
    }

    public final void e(int i2, Runnable runnable) {
        Integer ant;
        AppMethodBeat.i(231249);
        p.h(runnable, NativeProtocol.WEB_DIALOG_ACTION);
        a aVar = this.PCk.get(Integer.valueOf(i2));
        if (aVar == null) {
            AppMethodBeat.o(231249);
        } else if (!aVar.enable() || ((ant = ant(i2)) != null && ant.intValue() == 4)) {
            Log.w("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction action not enable or overTimeLimit: %d", Integer.valueOf(i2));
            AppMethodBeat.o(231249);
        } else if (aVar.valid()) {
            Log.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction valid and run action type: %d", Integer.valueOf(i2));
            anw(i2);
            runnable.run();
            AppMethodBeat.o(231249);
        } else {
            Log.d("MicroMsg.ImageScanButtonStatusManager", "alvinluo postAction not valid and delay type: %d, action: %s, delay: %d", Integer.valueOf(i2), runnable, Long.valueOf(aVar.gTz()));
            anu(i2);
            Integer valueOf = Integer.valueOf(i2);
            com.tencent.f.i.d<?> n = com.tencent.f.h.RTc.n(new i(this, i2, runnable), aVar.gTz());
            p.g(n, "ThreadPool.INSTANCE.uiDe…ntAction.delayDuration())");
            this.PCm.put(valueOf, n);
            AppMethodBeat.o(231249);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ int $type;
        final /* synthetic */ g PCq;
        final /* synthetic */ Runnable PCr;

        i(g gVar, int i2, Runnable runnable) {
            this.PCq = gVar;
            this.$type = i2;
            this.PCr = runnable;
        }

        public final void run() {
            AppMethodBeat.i(231243);
            g.b(this.PCq, this.$type);
            this.PCr.run();
            AppMethodBeat.o(231243);
        }
    }

    public final void anu(int i2) {
        AppMethodBeat.i(231250);
        com.tencent.f.i.d<?> dVar = this.PCm.get(Integer.valueOf(i2));
        if (dVar != null) {
            Log.v("MicroMsg.ImageScanButtonStatusManager", "alvinluo cancelAction type: %d", Integer.valueOf(i2));
            dVar.cancel(false);
            AppMethodBeat.o(231250);
            return;
        }
        AppMethodBeat.o(231250);
    }

    public final boolean isValid(int i2) {
        AppMethodBeat.i(231251);
        a aVar = this.PCk.get(Integer.valueOf(i2));
        if (aVar == null) {
            AppMethodBeat.o(231251);
            return false;
        } else if (!aVar.enable() || !aVar.valid()) {
            AppMethodBeat.o(231251);
            return false;
        } else {
            AppMethodBeat.o(231251);
            return true;
        }
    }

    public final boolean gTv() {
        AppMethodBeat.i(231252);
        boolean isValid = isValid(this.PCn);
        AppMethodBeat.o(231252);
        return isValid;
    }

    private final int gTw() {
        a aVar;
        int i2;
        AppMethodBeat.i(231253);
        Integer num = (Integer) kotlin.a.j.f(this.PCj);
        if (num != null) {
            num.intValue();
            a aVar2 = this.PCk.get(num);
            if (aVar2 == null) {
                AppMethodBeat.o(231253);
                return 0;
            }
            int gTy = aVar2.gTy();
            int intValue = num.intValue();
            int i3 = 0;
            for (T t : this.PCj) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    kotlin.a.j.hxH();
                }
                int intValue2 = t.intValue();
                if (i3 == 0 || (aVar = this.PCk.get(Integer.valueOf(intValue2))) == null) {
                    i3 = i4;
                } else {
                    if (aVar.gTy() < gTy) {
                        i2 = aVar.gTy();
                        intValue = intValue2;
                    } else {
                        i2 = gTy;
                    }
                    i3 = i4;
                    gTy = i2;
                }
            }
            AppMethodBeat.o(231253);
            return intValue;
        }
        AppMethodBeat.o(231253);
        return 0;
    }

    public final void anv(int i2) {
        AppMethodBeat.i(231254);
        this.PCl.remove(Integer.valueOf(i2));
        AppMethodBeat.o(231254);
    }

    private final void anw(int i2) {
        AppMethodBeat.i(231255);
        a(i2, new h(this));
        AppMethodBeat.o(231255);
    }

    private final void a(int i2, m<? super a, ? super a, x> mVar) {
        AppMethodBeat.i(231256);
        a aVar = this.PCk.get(Integer.valueOf(i2));
        if (aVar == null) {
            AppMethodBeat.o(231256);
            return;
        }
        Iterator<T> it = this.PCj.iterator();
        while (it.hasNext()) {
            a aVar2 = this.PCk.get(Integer.valueOf(it.next().intValue()));
            if (aVar2 != null) {
                mVar.invoke(aVar, aVar2);
            }
        }
        AppMethodBeat.o(231256);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$Action;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getController", "()Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "setController", "isEnable", "", "delayDuration", "", "enable", "getType", "", "setEnable", "", "show", "valid", "app_release"})
    static abstract class c implements a {
        private g PCp;
        private boolean ded = true;

        public c(g gVar) {
            p.h(gVar, "controller");
            this.PCp = gVar;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a
        public int getType() {
            return 0;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a
        public long gTz() {
            return 1000;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a
        public final boolean valid() {
            Integer a2 = g.a(this.PCp, getType());
            boolean z = a2 != null;
            for (Number number : this.PCp.PCj) {
                int intValue = number.intValue();
                a aVar = (a) this.PCp.PCk.get(Integer.valueOf(intValue));
                if (aVar != null && gTy() < aVar.gTy()) {
                    Integer a3 = g.a(this.PCp, intValue);
                    boolean z2 = z && a3 != null;
                    Log.v("MicroMsg.ImageScanButtonStatusManager", "Action.valid() actionType: %s, status: %s", Integer.valueOf(intValue), a3);
                    z = z2;
                }
            }
            Log.v("MicroMsg.ImageScanButtonStatusManager", "Action.valid() currentType: %d, currentStatus: %s, valid: %b", Integer.valueOf(getType()), a2, Boolean.valueOf(z));
            return z;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a
        public final boolean gTx() {
            boolean z = this.PCp.ans(getType()) == 1;
            Log.v("MicroMsg.ImageScanButtonStatusManager", "Action.show() status: %s, canShow: %s, getType: %d", g.a(this.PCp, getType()), Boolean.valueOf(z), Integer.valueOf(getType()));
            if (!z) {
                return false;
            }
            for (Number number : this.PCp.PCj) {
                int intValue = number.intValue();
                a aVar = (a) this.PCp.PCk.get(Integer.valueOf(intValue));
                if (aVar != null && gTy() < aVar.gTy()) {
                    boolean z2 = this.PCp.ans(intValue) == 1;
                    Log.v("MicroMsg.ImageScanButtonStatusManager", "Action.show() actionType: %d, actionCanShow: %b", Integer.valueOf(intValue), Boolean.valueOf(z2));
                    z = z && !z2;
                    if (!z) {
                        return false;
                    }
                }
            }
            return z;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a
        public final void setEnable(boolean z) {
            this.ded = z;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a
        public final boolean enable() {
            return this.ded;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$ScanCodeAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getType", "", DownloadInfo.PRIORITY, "app_release"})
    static final class d extends c {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(g gVar) {
            super(gVar);
            p.h(gVar, "controller");
            AppMethodBeat.i(231238);
            AppMethodBeat.o(231238);
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a, com.tencent.mm.ui.chatting.gallery.a.g.c
        public final int getType() {
            return 2;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a
        public final int gTy() {
            return 4;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$ScanTranslationAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "delayDuration", "", "getType", "", DownloadInfo.PRIORITY, "app_release"})
    static final class e extends c {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(g gVar) {
            super(gVar);
            p.h(gVar, "controller");
            AppMethodBeat.i(231239);
            AppMethodBeat.o(231239);
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a, com.tencent.mm.ui.chatting.gallery.a.g.c
        public final int getType() {
            return 1;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a, com.tencent.mm.ui.chatting.gallery.a.g.c
        public final long gTz() {
            return 2000;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a
        public final int gTy() {
            return 2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$SearchHotImageAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "getType", "", DownloadInfo.PRIORITY, "app_release"})
    static final class f extends c {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(g gVar) {
            super(gVar);
            p.h(gVar, "controller");
            AppMethodBeat.i(231240);
            AppMethodBeat.o(231240);
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a, com.tencent.mm.ui.chatting.gallery.a.g.c
        public final int getType() {
            return 3;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a
        public final int gTy() {
            return 3;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$SearchNormalImageAction;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager$DefaultAction;", "controller", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonStatusManager;)V", "delayDuration", "", "getType", "", DownloadInfo.PRIORITY, "app_release"})
    /* renamed from: com.tencent.mm.ui.chatting.gallery.a.g$g  reason: collision with other inner class name */
    static final class C2095g extends c {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C2095g(g gVar) {
            super(gVar);
            p.h(gVar, "controller");
            AppMethodBeat.i(231241);
            AppMethodBeat.o(231241);
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a, com.tencent.mm.ui.chatting.gallery.a.g.c
        public final int getType() {
            return 4;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a, com.tencent.mm.ui.chatting.gallery.a.g.c
        public final long gTz() {
            return 2000;
        }

        @Override // com.tencent.mm.ui.chatting.gallery.a.g.a
        public final int gTy() {
            return 1;
        }
    }

    public static final /* synthetic */ void b(g gVar, int i2) {
        AppMethodBeat.i(231260);
        gVar.a(i2, new j(gVar, i2));
        AppMethodBeat.o(231260);
    }
}
