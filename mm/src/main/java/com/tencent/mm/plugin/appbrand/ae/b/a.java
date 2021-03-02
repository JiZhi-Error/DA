package com.tencent.mm.plugin.appbrand.ae.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.appbrand.ae.a;
import com.tencent.mm.plugin.appbrand.ae.d.d;
import com.tencent.mm.plugin.appbrand.ae.e.c;
import com.tencent.mm.plugin.appbrand.ae.e.f;
import com.tencent.mm.plugin.appbrand.ae.e.h;
import com.tencent.mm.plugin.appbrand.ae.e.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a {
    public static int oiP = 1000;
    public static int oiQ = 64;
    public static final byte[] oiR = com.tencent.mm.plugin.appbrand.ae.f.b.afS("<policy-file-request/>\u0000");
    protected d.a oiS = null;
    protected a.b oiy = null;

    public abstract b a(com.tencent.mm.plugin.appbrand.ae.e.a aVar, h hVar);

    public abstract com.tencent.mm.plugin.appbrand.ae.e.b a(com.tencent.mm.plugin.appbrand.ae.e.b bVar);

    public abstract c a(com.tencent.mm.plugin.appbrand.ae.e.a aVar, i iVar);

    public abstract List<d> a(ByteBuffer byteBuffer, boolean z);

    public abstract List<d> aF(String str, boolean z);

    public abstract EnumC0536a bZC();

    public abstract a bZD();

    public abstract b c(com.tencent.mm.plugin.appbrand.ae.e.a aVar);

    public abstract ByteBuffer d(d dVar);

    public abstract void reset();

    public abstract List<d> x(ByteBuffer byteBuffer);

    public enum b {
        MATCHED,
        NOT_MATCHED;

        public static b valueOf(String str) {
            AppMethodBeat.i(156629);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(156629);
            return bVar;
        }

        static {
            AppMethodBeat.i(156630);
            AppMethodBeat.o(156630);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ae.b.a$a  reason: collision with other inner class name */
    public enum EnumC0536a {
        NONE,
        ONEWAY,
        TWOWAY;

        public static EnumC0536a valueOf(String str) {
            AppMethodBeat.i(156626);
            EnumC0536a aVar = (EnumC0536a) Enum.valueOf(EnumC0536a.class, str);
            AppMethodBeat.o(156626);
            return aVar;
        }

        static {
            AppMethodBeat.i(156627);
            AppMethodBeat.o(156627);
        }
    }

    private static String w(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b2 = 48;
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                byteBuffer.position(byteBuffer.position() - allocate.position());
                byteBuffer2 = null;
                break;
            }
            byte b3 = byteBuffer.get();
            allocate.put(b3);
            if (b2 == 13 && b3 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                byteBuffer2 = allocate;
                break;
            }
            b2 = b3;
        }
        if (byteBuffer2 == null) {
            return null;
        }
        return com.tencent.mm.plugin.appbrand.ae.f.b.K(byteBuffer2.array(), byteBuffer2.limit());
    }

    public static List<ByteBuffer> e(f fVar) {
        return f(fVar);
    }

    public static List<ByteBuffer> f(f fVar) {
        StringBuilder sb = new StringBuilder(100);
        if (fVar instanceof com.tencent.mm.plugin.appbrand.ae.e.a) {
            sb.append("GET ");
            sb.append(((com.tencent.mm.plugin.appbrand.ae.e.a) fVar).bZL());
            sb.append(" HTTP/1.1");
        } else if (fVar instanceof h) {
            sb.append("HTTP/1.1 101 " + ((h) fVar).bZM());
        } else {
            sb.append("GET ");
            sb.append(((com.tencent.mm.plugin.appbrand.ae.e.a) fVar).bZL());
            sb.append(" HTTP/1.1");
            Log.e("MicroMsg.AppBrandNetWork.Draft", "unknow role");
        }
        sb.append(APLogFileUtil.SEPARATOR_LINE);
        Iterator<String> bZO = fVar.bZO();
        while (bZO.hasNext()) {
            String next = bZO.next();
            String afQ = fVar.afQ(next);
            sb.append(next);
            sb.append(": ");
            sb.append(afQ);
            sb.append(APLogFileUtil.SEPARATOR_LINE);
        }
        sb.append(APLogFileUtil.SEPARATOR_LINE);
        byte[] afT = com.tencent.mm.plugin.appbrand.ae.f.b.afT(sb.toString());
        byte[] content = fVar.getContent();
        ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + afT.length);
        allocate.put(afT);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.appbrand.ae.e.f y(java.nio.ByteBuffer r8) {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ae.b.a.y(java.nio.ByteBuffer):com.tencent.mm.plugin.appbrand.ae.e.f");
    }

    public static int zH(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new com.tencent.mm.plugin.appbrand.ae.c.b("Negative count");
    }

    public final void a(a.b bVar) {
        this.oiy = bVar;
    }
}
