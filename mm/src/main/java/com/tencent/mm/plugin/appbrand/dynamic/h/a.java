package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private static volatile a lpc;
    public Map<String, List<IPCDynamicPageView>> lpd = new ConcurrentHashMap();
    public Map<String, AbstractC0574a> lpe = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.a$a  reason: collision with other inner class name */
    public interface AbstractC0574a {
        void a(String str, IPCDynamicPageView iPCDynamicPageView);
    }

    private a() {
        AppMethodBeat.i(121420);
        AppMethodBeat.o(121420);
    }

    public static a bCk() {
        AppMethodBeat.i(121421);
        if (lpc == null) {
            synchronized (a.class) {
                try {
                    if (lpc == null) {
                        lpc = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121421);
                    throw th;
                }
            }
        }
        a aVar = lpc;
        AppMethodBeat.o(121421);
        return aVar;
    }

    public final IPCDynamicPageView YC(String str) {
        AppMethodBeat.i(121422);
        if (str == null) {
            AppMethodBeat.o(121422);
            return null;
        }
        for (Map.Entry<String, List<IPCDynamicPageView>> entry : this.lpd.entrySet()) {
            if (entry.getValue() != null) {
                for (IPCDynamicPageView iPCDynamicPageView : entry.getValue()) {
                    if (iPCDynamicPageView.getExtId() != null && iPCDynamicPageView.getExtId().equals(str)) {
                        AppMethodBeat.o(121422);
                        return iPCDynamicPageView;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(121422);
        return null;
    }

    public final boolean b(String str, IPCDynamicPageView iPCDynamicPageView) {
        boolean remove;
        AppMethodBeat.i(121423);
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            AppMethodBeat.o(121423);
            return false;
        }
        List<IPCDynamicPageView> list = this.lpd.get(str);
        if (list == null) {
            AppMethodBeat.o(121423);
            return false;
        }
        synchronized (list) {
            try {
                remove = list.remove(iPCDynamicPageView);
            } finally {
                AppMethodBeat.o(121423);
            }
        }
        if (list.isEmpty()) {
            this.lpd.remove(str);
        }
        return remove;
    }

    public final boolean c(String str, IPCDynamicPageView iPCDynamicPageView) {
        LinkedList linkedList;
        IPCDynamicPageView bs;
        AbstractC0574a aVar;
        AppMethodBeat.i(121424);
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            AppMethodBeat.o(121424);
            return false;
        }
        List<IPCDynamicPageView> list = this.lpd.get(str);
        if (list == null) {
            LinkedList linkedList2 = new LinkedList();
            this.lpd.put(str, linkedList2);
            linkedList = linkedList2;
        } else {
            linkedList = list;
        }
        if (linkedList.contains(iPCDynamicPageView)) {
            synchronized (linkedList) {
                try {
                    linkedList.remove(iPCDynamicPageView);
                    linkedList.add(iPCDynamicPageView);
                } catch (Throwable th) {
                    AppMethodBeat.o(121424);
                    throw th;
                }
            }
            AppMethodBeat.o(121424);
            return true;
        }
        boolean add = linkedList.add(iPCDynamicPageView);
        if (linkedList.size() > 4) {
            synchronized (linkedList) {
                try {
                    if (!(linkedList.size() <= 4 || (bs = bs(linkedList)) == null || (aVar = this.lpe.get(str)) == null)) {
                        aVar.a(str, bs);
                    }
                } finally {
                    AppMethodBeat.o(121424);
                }
            }
        }
        return add;
    }

    private static IPCDynamicPageView bs(List<IPCDynamicPageView> list) {
        AppMethodBeat.i(121425);
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).isPaused()) {
                IPCDynamicPageView remove = list.remove(i2);
                AppMethodBeat.o(121425);
                return remove;
            }
        }
        AppMethodBeat.o(121425);
        return null;
    }
}
