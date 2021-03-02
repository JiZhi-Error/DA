package com.tencent.mm.plugin.appbrand.ae.b;

import com.google.android.gms.common.util.AndroidUtilsLight;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.a;
import com.tencent.mm.plugin.appbrand.ae.b.a;
import com.tencent.mm.plugin.appbrand.ae.d.d;
import com.tencent.mm.plugin.appbrand.ae.d.e;
import com.tencent.mm.plugin.appbrand.ae.e.c;
import com.tencent.mm.plugin.appbrand.ae.e.f;
import com.tencent.mm.plugin.appbrand.ae.e.h;
import com.tencent.mm.plugin.appbrand.ae.e.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class b extends a {
    private ByteBuffer oja;
    private d ojb = null;
    private final Random ojc = new Random();

    public b() {
        AppMethodBeat.i(156631);
        AppMethodBeat.o(156631);
    }

    /* access modifiers changed from: package-private */
    public class a extends Throwable {
        int ojd;

        public a(int i2) {
            this.ojd = i2;
        }
    }

    public static int g(f fVar) {
        int i2 = -1;
        AppMethodBeat.i(156632);
        String afQ = fVar.afQ("Sec-WebSocket-Version");
        if (afQ.length() > 0) {
            try {
                i2 = new Integer(afQ.trim()).intValue();
                AppMethodBeat.o(156632);
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(156632);
            }
        } else {
            AppMethodBeat.o(156632);
        }
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a
    public final a.b a(com.tencent.mm.plugin.appbrand.ae.e.a aVar, h hVar) {
        boolean z = true;
        AppMethodBeat.i(156633);
        String afQ = aVar.afQ("Sec-WebSocket-Protocol");
        String afQ2 = hVar.afQ("Sec-WebSocket-Protocol");
        if (!Util.isNullOrNil(afQ) && !Util.isNullOrNil(afQ2)) {
            Log.d("MicroMsg.AppBrandNetWork.Draft_10", "respProtocol is %s", afQ2);
            String[] split = afQ.split(", ");
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (afQ2.equals(split[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                a.b bVar = a.b.NOT_MATCHED;
                AppMethodBeat.o(156633);
                return bVar;
            }
        }
        if (!aVar.afR("Sec-WebSocket-Key") || !hVar.afR("Sec-WebSocket-Accept")) {
            a.b bVar2 = a.b.NOT_MATCHED;
            AppMethodBeat.o(156633);
            return bVar2;
        }
        if (afN(aVar.afQ("Sec-WebSocket-Key")).equals(hVar.afQ("Sec-WebSocket-Accept"))) {
            a.b bVar3 = a.b.MATCHED;
            AppMethodBeat.o(156633);
            return bVar3;
        }
        a.b bVar4 = a.b.NOT_MATCHED;
        AppMethodBeat.o(156633);
        return bVar4;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a
    public a.b c(com.tencent.mm.plugin.appbrand.ae.e.a aVar) {
        boolean z;
        AppMethodBeat.i(156634);
        int g2 = g(aVar);
        if (g2 == 7 || g2 == 8) {
            if (!aVar.afQ("Upgrade").equalsIgnoreCase("websocket") || !aVar.afQ("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade")) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                a.b bVar = a.b.MATCHED;
                AppMethodBeat.o(156634);
                return bVar;
            }
            a.b bVar2 = a.b.NOT_MATCHED;
            AppMethodBeat.o(156634);
            return bVar2;
        }
        a.b bVar3 = a.b.NOT_MATCHED;
        AppMethodBeat.o(156634);
        return bVar3;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a
    public final ByteBuffer d(d dVar) {
        int i2;
        int i3;
        byte b2;
        byte b3 = Byte.MIN_VALUE;
        int i4 = 0;
        AppMethodBeat.i(156635);
        ByteBuffer bZH = dVar.bZH();
        boolean z = this.oiy == a.b.CLIENT;
        int i5 = bZH.remaining() <= 125 ? 1 : bZH.remaining() <= 65535 ? 2 : 8;
        if (i5 > 1) {
            i2 = i5 + 1;
        } else {
            i2 = i5;
        }
        int i6 = i2 + 1;
        if (z) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i3 + i6 + bZH.remaining());
        d.a bZK = dVar.bZK();
        if (bZK == d.a.CONTINUOUS) {
            b2 = 0;
        } else if (bZK == d.a.TEXT) {
            b2 = 1;
        } else if (bZK == d.a.BINARY) {
            b2 = 2;
        } else if (bZK == d.a.CLOSING) {
            b2 = 8;
        } else if (bZK == d.a.PING) {
            b2 = 9;
        } else if (bZK == d.a.PONG) {
            b2 = 10;
        } else {
            Log.e("MicroMsg.AppBrandNetWork.Draft_10", "Don't know how to handle force close" + bZK.toString());
            b2 = 8;
        }
        allocate.put((byte) (b2 | ((byte) (dVar.bZI() ? -128 : 0))));
        byte[] k = k((long) bZH.remaining(), i5);
        if (i5 == 1) {
            byte b4 = k[0];
            if (!z) {
                b3 = 0;
            }
            allocate.put((byte) (b4 | b3));
        } else if (i5 == 2) {
            if (!z) {
                b3 = 0;
            }
            allocate.put((byte) (b3 | 126));
            allocate.put(k);
        } else if (i5 == 8) {
            if (!z) {
                b3 = 0;
            }
            allocate.put((byte) (b3 | Byte.MAX_VALUE));
            allocate.put(k);
        } else {
            Log.e("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.ojc.nextInt());
            allocate.put(allocate2.array());
            while (bZH.hasRemaining()) {
                allocate.put((byte) (bZH.get() ^ allocate2.get(i4 % 4)));
                i4++;
            }
        } else {
            allocate.put(bZH);
        }
        allocate.flip();
        AppMethodBeat.o(156635);
        return allocate;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a
    public final List<d> a(ByteBuffer byteBuffer, boolean z) {
        AppMethodBeat.i(156636);
        e eVar = new e();
        try {
            eVar.A(byteBuffer);
        } catch (com.tencent.mm.plugin.appbrand.ae.c.b e2) {
            Log.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e2.toString());
        }
        eVar.iX(true);
        eVar.a(d.a.BINARY);
        eVar.iY(z);
        List<d> singletonList = Collections.singletonList(eVar);
        AppMethodBeat.o(156636);
        return singletonList;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a
    public final List<d> aF(String str, boolean z) {
        AppMethodBeat.i(156637);
        e eVar = new e();
        try {
            eVar.A(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.ae.f.b.afS(str)));
        } catch (com.tencent.mm.plugin.appbrand.ae.c.b e2) {
            Log.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e2.toString());
        }
        eVar.iX(true);
        eVar.a(d.a.TEXT);
        eVar.iY(z);
        List<d> singletonList = Collections.singletonList(eVar);
        AppMethodBeat.o(156637);
        return singletonList;
    }

    private static String afN(String str) {
        AppMethodBeat.i(156638);
        try {
            String aR = com.tencent.mm.plugin.appbrand.ae.f.a.aR(MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1).digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
            AppMethodBeat.o(156638);
            return aR;
        } catch (NoSuchAlgorithmException e2) {
            Log.e("MicroMsg.AppBrandNetWork.Draft_10", "not such algorithm " + e2.toString());
            AppMethodBeat.o(156638);
            return "";
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a
    public com.tencent.mm.plugin.appbrand.ae.e.b a(com.tencent.mm.plugin.appbrand.ae.e.b bVar) {
        AppMethodBeat.i(156639);
        bVar.put("Upgrade", "websocket");
        bVar.put("Connection", "Upgrade");
        bVar.put("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.ojc.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", com.tencent.mm.plugin.appbrand.ae.f.a.aR(bArr));
        AppMethodBeat.o(156639);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a
    public c a(com.tencent.mm.plugin.appbrand.ae.e.a aVar, i iVar) {
        AppMethodBeat.i(156640);
        iVar.put("Upgrade", "websocket");
        iVar.put("Connection", aVar.afQ("Connection"));
        iVar.afP("Switching Protocols");
        String afQ = aVar.afQ("Sec-WebSocket-Key");
        if (afQ == null) {
            com.tencent.mm.plugin.appbrand.ae.c.d dVar = new com.tencent.mm.plugin.appbrand.ae.c.d("missing Sec-WebSocket-Key");
            AppMethodBeat.o(156640);
            throw dVar;
        }
        iVar.put("Sec-WebSocket-Accept", afN(afQ));
        AppMethodBeat.o(156640);
        return iVar;
    }

    private static byte[] k(long j2, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = (i2 * 8) - 8;
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) ((int) (j2 >>> (i3 - (i4 * 8))));
        }
        return bArr;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a
    public final List<d> x(ByteBuffer byteBuffer) {
        LinkedList linkedList;
        AppMethodBeat.i(156641);
        while (true) {
            linkedList = new LinkedList();
            if (this.oja == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.oja.remaining();
                if (remaining2 > remaining) {
                    this.oja.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(remaining + byteBuffer.position());
                    List<d> emptyList = Collections.emptyList();
                    AppMethodBeat.o(156641);
                    return emptyList;
                }
                this.oja.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(z((ByteBuffer) this.oja.duplicate().position(0)));
                this.oja = null;
            } catch (a e2) {
                this.oja.limit();
                ByteBuffer allocate = ByteBuffer.allocate(zH(e2.ojd));
                this.oja.rewind();
                allocate.put(this.oja);
                this.oja = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(z(byteBuffer));
            } catch (a e3) {
                byteBuffer.reset();
                this.oja = ByteBuffer.allocate(zH(e3.ojd));
                this.oja.put(byteBuffer);
            }
        }
        AppMethodBeat.o(156641);
        return linkedList;
    }

    private d z(ByteBuffer byteBuffer) {
        d.a aVar;
        byte b2;
        com.tencent.mm.plugin.appbrand.ae.d.c eVar;
        AppMethodBeat.i(156642);
        int remaining = byteBuffer.remaining();
        int i2 = 2;
        if (remaining < 2) {
            a aVar2 = new a(2);
            AppMethodBeat.o(156642);
            throw aVar2;
        }
        byte b3 = byteBuffer.get();
        boolean z = (b3 >> 8) != 0;
        byte b4 = (byte) ((b3 & Byte.MAX_VALUE) >> 4);
        if (b4 != 0) {
            com.tencent.mm.plugin.appbrand.ae.c.c cVar = new com.tencent.mm.plugin.appbrand.ae.c.c("bad rsv ".concat(String.valueOf((int) b4)));
            AppMethodBeat.o(156642);
            throw cVar;
        }
        byte b5 = byteBuffer.get();
        boolean z2 = (b5 & Byte.MIN_VALUE) != 0;
        byte b6 = (byte) (b5 & Byte.MAX_VALUE);
        byte b7 = (byte) (b3 & 15);
        switch (b7) {
            case 0:
                aVar = d.a.CONTINUOUS;
                break;
            case 1:
                aVar = d.a.TEXT;
                break;
            case 2:
                aVar = d.a.BINARY;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                com.tencent.mm.plugin.appbrand.ae.c.c cVar2 = new com.tencent.mm.plugin.appbrand.ae.c.c("unknow optcode " + ((int) ((short) b7)));
                AppMethodBeat.o(156642);
                throw cVar2;
            case 8:
                aVar = d.a.CLOSING;
                break;
            case 9:
                aVar = d.a.PING;
                break;
            case 10:
                aVar = d.a.PONG;
                break;
        }
        if (z || !(aVar == d.a.PING || aVar == d.a.PONG || aVar == d.a.CLOSING)) {
            if (b6 >= 0 && b6 <= 125) {
                b2 = b6;
            } else if (aVar == d.a.PING || aVar == d.a.PONG || aVar == d.a.CLOSING) {
                com.tencent.mm.plugin.appbrand.ae.c.c cVar3 = new com.tencent.mm.plugin.appbrand.ae.c.c("more than 125 octets");
                AppMethodBeat.o(156642);
                throw cVar3;
            } else if (b6 == 126) {
                i2 = 4;
                if (remaining < 4) {
                    a aVar3 = new a(4);
                    AppMethodBeat.o(156642);
                    throw aVar3;
                }
                byte[] bArr = new byte[3];
                bArr[1] = byteBuffer.get();
                bArr[2] = byteBuffer.get();
                b2 = new BigInteger(bArr).intValue();
            } else {
                i2 = 10;
                if (remaining < 10) {
                    a aVar4 = new a(10);
                    AppMethodBeat.o(156642);
                    throw aVar4;
                }
                byte[] bArr2 = new byte[8];
                for (int i3 = 0; i3 < 8; i3++) {
                    bArr2[i3] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr2).longValue();
                if (longValue > 2147483647L) {
                    Log.e("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
                    b2 = b6;
                } else {
                    b2 = (int) longValue;
                }
            }
            int i4 = (z2 ? 4 : 0) + i2 + b2;
            if (remaining < i4) {
                a aVar5 = new a(i4);
                AppMethodBeat.o(156642);
                throw aVar5;
            }
            ByteBuffer allocate = ByteBuffer.allocate(zH(b2));
            if (z2) {
                byte[] bArr3 = new byte[4];
                byteBuffer.get(bArr3);
                for (int i5 = 0; i5 < b2; i5++) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr3[i5 % 4]));
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            if (aVar == d.a.CLOSING) {
                eVar = new com.tencent.mm.plugin.appbrand.ae.d.b();
            } else {
                eVar = new e();
                eVar.iX(z);
                eVar.a(aVar);
            }
            allocate.flip();
            eVar.A(allocate);
            AppMethodBeat.o(156642);
            return eVar;
        }
        com.tencent.mm.plugin.appbrand.ae.c.c cVar4 = new com.tencent.mm.plugin.appbrand.ae.c.c("control frames may no be fragmented");
        AppMethodBeat.o(156642);
        throw cVar4;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a
    public final void reset() {
        this.oja = null;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a
    public a bZD() {
        AppMethodBeat.i(156643);
        b bVar = new b();
        AppMethodBeat.o(156643);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a
    public final a.EnumC0536a bZC() {
        return a.EnumC0536a.TWOWAY;
    }
}
