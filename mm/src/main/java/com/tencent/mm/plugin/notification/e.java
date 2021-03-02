package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class e implements aa {
    private static List<ba> AGH = new ArrayList();
    private boolean AGI;
    private boolean AGJ;
    private List<ca> AGK;

    static {
        AppMethodBeat.i(149387);
        AppMethodBeat.o(149387);
    }

    public static void a(ba baVar) {
        AppMethodBeat.i(149381);
        synchronized (AGH) {
            try {
                if (!AGH.contains(baVar)) {
                    AGH.add(baVar);
                }
            } finally {
                AppMethodBeat.o(149381);
            }
        }
    }

    public static void b(ba baVar) {
        AppMethodBeat.i(149382);
        synchronized (AGH) {
            try {
                AGH.remove(baVar);
            } finally {
                AppMethodBeat.o(149382);
            }
        }
    }

    public e() {
        this(false);
    }

    public e(boolean z) {
        AppMethodBeat.i(149383);
        this.AGI = false;
        this.AGJ = false;
        this.AGK = new LinkedList();
        this.AGI = z;
        this.AGJ = false;
        this.AGK = new LinkedList();
        AppMethodBeat.o(149383);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.aa
    public final void dkt() {
        AppMethodBeat.i(149384);
        final LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.AGK);
        this.AGK.clear();
        if (linkedList.size() == 0) {
            AppMethodBeat.o(149384);
            return;
        }
        ArrayList<ba> arrayList = new ArrayList();
        synchronized (AGH) {
            try {
                for (ba baVar : AGH) {
                    arrayList.add(baVar);
                }
            } finally {
                AppMethodBeat.o(149384);
            }
        }
        for (final ba baVar2 : arrayList) {
            new MMHandler(baVar2.getLooper()).post(new Runnable() {
                /* class com.tencent.mm.plugin.notification.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(149379);
                    baVar2.S(linkedList);
                    AppMethodBeat.o(149379);
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r6.field_isSend != 0) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r6.field_status != 4) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.SyncMessageNotifier", "not new msg, ignore");
        com.tencent.matrix.trace.core.AppMethodBeat.o(149385);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r0 = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().aEY(new com.tencent.mm.storage.ci.a(com.tencent.mm.platformtools.z.a(r7.KHl)).bkR(""));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        if (r0 == null) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0075, code lost:
        if (r0.gEp() != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.SyncMessageNotifier", "account no notification");
        com.tencent.matrix.trace.core.AppMethodBeat.o(149385);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0086, code lost:
        if (r5.AGJ != false) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0088, code lost:
        r5.AGJ = true;
        r1 = new java.util.ArrayList();
        r2 = com.tencent.mm.plugin.notification.e.AGH;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r3 = com.tencent.mm.plugin.notification.e.AGH.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        if (r3.hasNext() == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009f, code lost:
        r1.add(r3.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ab, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(149385);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ae, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00af, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b0, code lost:
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b8, code lost:
        if (r1.hasNext() == false) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ba, code lost:
        r0 = (com.tencent.mm.model.ba) r1.next();
        new com.tencent.mm.sdk.platformtools.MMHandler(r0.getLooper()).post(new com.tencent.mm.plugin.notification.e.AnonymousClass2(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d7, code lost:
        r5.AGK.add(r6);
        com.tencent.matrix.trace.core.AppMethodBeat.o(149385);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.aa
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final com.tencent.mm.storage.ca r6, final com.tencent.mm.protocal.protobuf.de r7) {
        /*
        // Method dump skipped, instructions count: 225
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.notification.e.a(com.tencent.mm.storage.ca, com.tencent.mm.protocal.protobuf.de):void");
    }

    static /* synthetic */ String c(de deVar) {
        int Kp;
        AppMethodBeat.i(149386);
        String a2 = z.a(deVar.KHl);
        String a3 = z.a(deVar.KHm);
        if (Util.isNullOrNil(a2) || Util.isNullOrNil(a3)) {
            Log.e("MicroMsg.SyncMessageNotifier", "empty fromuser or touser");
            AppMethodBeat.o(149386);
            return null;
        }
        String a4 = z.a(deVar.KHn);
        if (Util.isNullOrNil(a4)) {
            AppMethodBeat.o(149386);
            return null;
        }
        if (ab.Eq(a2) && (Kp = bp.Kp(a4)) != -1) {
            a4 = (a4 + " ").substring(Kp + 2).trim();
        }
        String processXml = Util.processXml(a4);
        AppMethodBeat.o(149386);
        return processXml;
    }
}
