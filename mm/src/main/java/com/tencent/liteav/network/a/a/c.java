package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.a;
import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.d;
import com.tencent.liteav.network.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.util.Random;

public final class c implements com.tencent.liteav.network.a.c {

    /* renamed from: b  reason: collision with root package name */
    private static final Random f900b = new Random();

    /* renamed from: a  reason: collision with root package name */
    final InetAddress f901a;

    /* renamed from: c  reason: collision with root package name */
    private final int f902c;

    static {
        AppMethodBeat.i(15452);
        AppMethodBeat.o(15452);
    }

    public c(InetAddress inetAddress) {
        this(inetAddress, 10);
    }

    public c(InetAddress inetAddress, int i2) {
        this.f901a = inetAddress;
        this.f902c = i2;
    }

    @Override // com.tencent.liteav.network.a.c
    public final e[] a(b bVar, d dVar) {
        int nextInt;
        AppMethodBeat.i(15450);
        synchronized (f900b) {
            try {
                nextInt = f900b.nextInt() & 255;
            } catch (Throwable th) {
                AppMethodBeat.o(15450);
                throw th;
            }
        }
        byte[] a2 = a(b.a(bVar.f903a, nextInt));
        if (a2 == null) {
            a aVar = new a(bVar.f903a, "cant get answer");
            AppMethodBeat.o(15450);
            throw aVar;
        }
        e[] a3 = b.a(a2, nextInt, bVar.f903a);
        AppMethodBeat.o(15450);
        return a3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(byte[] r7) {
        /*
            r6 = this;
            r5 = 15451(0x3c5b, float:2.1651E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            r2 = 0
            java.net.DatagramSocket r1 = new java.net.DatagramSocket     // Catch:{ all -> 0x0038 }
            r1.<init>()     // Catch:{ all -> 0x0038 }
            java.net.DatagramPacket r0 = new java.net.DatagramPacket     // Catch:{ all -> 0x0043 }
            int r2 = r7.length     // Catch:{ all -> 0x0043 }
            java.net.InetAddress r3 = r6.f901a     // Catch:{ all -> 0x0043 }
            r4 = 53
            r0.<init>(r7, r2, r3, r4)     // Catch:{ all -> 0x0043 }
            int r2 = r6.f902c     // Catch:{ all -> 0x0043 }
            int r2 = r2 * 1000
            r1.setSoTimeout(r2)     // Catch:{ all -> 0x0043 }
            r1.send(r0)     // Catch:{ all -> 0x0043 }
            java.net.DatagramPacket r0 = new java.net.DatagramPacket     // Catch:{ all -> 0x0043 }
            r2 = 1500(0x5dc, float:2.102E-42)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0043 }
            r3 = 1500(0x5dc, float:2.102E-42)
            r0.<init>(r2, r3)     // Catch:{ all -> 0x0043 }
            r1.receive(r0)     // Catch:{ all -> 0x0043 }
            byte[] r0 = r0.getData()     // Catch:{ all -> 0x0043 }
            r1.close()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            return r0
        L_0x0038:
            r0 = move-exception
            r1 = r2
        L_0x003a:
            if (r1 == 0) goto L_0x003f
            r1.close()
        L_0x003f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r0
        L_0x0043:
            r0 = move-exception
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.network.a.a.c.a(byte[]):byte[]");
    }
}
