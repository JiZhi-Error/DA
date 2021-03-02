package com.tencent.mm.plugin.backup.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.lan_cs.Client;
import com.tencent.mm.lan_cs.Server;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;

public final class a implements b.a {
    public static final byte[] oJy = "GSMW".getBytes();
    private int mode = 0;
    public MMHandler oJA = null;
    public AbstractC0841a oJB;
    private int oJz;
    private String peerIP;

    /* renamed from: com.tencent.mm.plugin.backup.c.a$a  reason: collision with other inner class name */
    public interface AbstractC0841a {
        void b(int i2, int i3, byte[] bArr);
    }

    static /* synthetic */ void a(a aVar, int i2, byte[] bArr) {
        AppMethodBeat.i(21223);
        aVar.a(true, 0, i2, bArr);
        AppMethodBeat.o(21223);
    }

    static {
        AppMethodBeat.i(21224);
        AppMethodBeat.o(21224);
    }

    public final boolean a(PString pString, PInt pInt) {
        AppMethodBeat.i(21216);
        this.mode = 0;
        Log.i("MicroMsg.BackupCEngine", "listen, before server.stop");
        Server.Java2C.stop();
        Log.i("MicroMsg.BackupCEngine", "listen, before server.start listener");
        Server.hvv = new Server.a() {
            /* class com.tencent.mm.plugin.backup.c.a.AnonymousClass1 */

            @Override // com.tencent.mm.lan_cs.Server.a
            public final void qm(int i2) {
                AppMethodBeat.i(21207);
                if (a.this.mode == 1) {
                    b.Bp(i2);
                }
                AppMethodBeat.o(21207);
            }

            @Override // com.tencent.mm.lan_cs.Server.a
            public final void onRecv(String str, int i2, byte[] bArr) {
                AppMethodBeat.i(21208);
                a.this.peerIP = str;
                a.this.oJz = i2;
                try {
                    a.a(a.this, bArr);
                    AppMethodBeat.o(21208);
                } catch (IOException e2) {
                    a.a(a.this, 10006, ("server readErr:" + e2.toString()).getBytes());
                    AppMethodBeat.o(21208);
                }
            }

            @Override // com.tencent.mm.lan_cs.Server.a
            public final void aBy() {
                AppMethodBeat.i(21209);
                a.a(a.this, CdnLogic.kMediaTypeBeatificFile, "listen server onDisconnect".getBytes());
                AppMethodBeat.o(21209);
            }

            @Override // com.tencent.mm.lan_cs.Server.a
            public final void onConnect(String str, int i2) {
                AppMethodBeat.i(21210);
                a.this.peerIP = str;
                a.this.oJz = i2;
                AppMethodBeat.o(21210);
            }
        };
        Object[] access$000 = Server.Java2C.access$000();
        if (access$000 == null || access$000.length != 3) {
            Log.e("MicroMsg.BackupCEngine", "listen error");
            AppMethodBeat.o(21216);
            return false;
        }
        Log.i("MicroMsg.BackupCEngine", "listen, result[%d, %s, %d]", access$000[0], access$000[1], access$000[2]);
        if (((Integer) access$000[0]).intValue() != 1) {
            AppMethodBeat.o(21216);
            return false;
        }
        pString.value = (String) access$000[1];
        pInt.value = ((Integer) access$000[2]).intValue();
        this.mode = 1;
        AppMethodBeat.o(21216);
        return true;
    }

    public final void connect(String str, int i2) {
        AppMethodBeat.i(21217);
        this.mode = 2;
        this.peerIP = str;
        this.oJz = i2;
        Client.hvu = new Client.a() {
            /* class com.tencent.mm.plugin.backup.c.a.AnonymousClass2 */

            @Override // com.tencent.mm.lan_cs.Client.a
            public final void onRecv(String str, int i2, byte[] bArr) {
                AppMethodBeat.i(21211);
                a.this.peerIP = str;
                a.this.oJz = i2;
                try {
                    a.a(a.this, bArr);
                    AppMethodBeat.o(21211);
                } catch (IOException e2) {
                    a.a(a.this, 10006, ("client readErr:" + e2.toString()).getBytes());
                    AppMethodBeat.o(21211);
                }
            }

            @Override // com.tencent.mm.lan_cs.Client.a
            public final void aBy() {
                AppMethodBeat.i(21212);
                a.a(a.this, CdnLogic.kMediaTypeBeatificFile, "client onDisconnect".getBytes());
                AppMethodBeat.o(21212);
            }
        };
        AppMethodBeat.o(21217);
    }

    public final void stop() {
        AppMethodBeat.i(21218);
        Log.i("MicroMsg.BackupCEngine", "BackupCEngine stop.");
        if (this.mode == 1) {
            Server.Java2C.stop();
            b.cfK();
            this.mode = 0;
            AppMethodBeat.o(21218);
        } else if (this.mode == 2) {
            Client.Java2C.disconnect();
            b.cfK();
            this.mode = 0;
            AppMethodBeat.o(21218);
        } else {
            AppMethodBeat.o(21218);
        }
    }

    @Override // com.tencent.mm.plugin.backup.g.b.a
    public final void l(final int i2, final byte[] bArr) {
        AppMethodBeat.i(21219);
        final long nowMilliSecond = Util.nowMilliSecond();
        Log.v("MicroMsg.BackupCEngine", "send seq:%d buff:%d", Integer.valueOf(i2), Integer.valueOf(Util.getLength(bArr)));
        if (this.oJA == null || this.oJA.isQuit()) {
            this.oJA = new MMHandler("BackupCEngine_sendHandler");
            Log.w("MicroMsg.BackupCEngine", "BackupCEngine send");
        }
        this.oJA.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.c.a.AnonymousClass4 */

            public final void run() {
                int send;
                AppMethodBeat.i(21214);
                long nowMilliSecond = Util.nowMilliSecond();
                Log.i("MicroMsg.BackupCEngine", "before send server mode:%d  seq:%d  buff:%d time:[%d]", Integer.valueOf(a.this.mode), Integer.valueOf(i2), Integer.valueOf(Util.getLength(bArr)), Long.valueOf(nowMilliSecond - nowMilliSecond));
                if (a.this.mode == 0) {
                    Log.i("MicroMsg.BackupCEngine", "sendImp err mode!!");
                    AppMethodBeat.o(21214);
                    return;
                }
                if (a.this.mode == 1) {
                    send = Server.Java2C.send(a.this.peerIP, a.this.oJz, bArr);
                    if (send != 0) {
                    }
                } else {
                    send = a.this.mode == 2 ? Client.Java2C.send(a.this.peerIP, a.this.oJz, bArr) : 0;
                }
                b.Bp(Util.getLength(bArr));
                Log.i("MicroMsg.BackupCEngine", "send result[%d], seq[%d], buff[%d], time[%d,%d]", Integer.valueOf(send), Integer.valueOf(i2), Integer.valueOf(Util.getLength(bArr)), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
                AppMethodBeat.o(21214);
            }
        });
        AppMethodBeat.o(21219);
    }

    @Override // com.tencent.mm.plugin.backup.g.b.a
    public final int m(int i2, byte[] bArr) {
        int i3;
        AppMethodBeat.i(21220);
        long nowMilliSecond = Util.nowMilliSecond();
        if (this.mode == 1) {
            i3 = Server.Java2C.send(this.peerIP, this.oJz, bArr);
        } else if (this.mode == 2) {
            i3 = Client.Java2C.send(this.peerIP, this.oJz, bArr);
            b.Bp(Util.getLength(bArr));
        } else {
            i3 = 0;
        }
        Log.i("MicroMsg.BackupCEngine", "sendSameThread, result[%d], seq[%d], buflen[%d], send time[%d]", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(Util.getLength(bArr)), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
        AppMethodBeat.o(21220);
        return i3;
    }

    private void a(final boolean z, final int i2, final int i3, final byte[] bArr) {
        AppMethodBeat.i(21221);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.backup.c.a.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(21215);
                b.b(z, i2, i3, bArr);
                AppMethodBeat.o(21215);
            }
        });
        AppMethodBeat.o(21221);
    }

    static /* synthetic */ void a(a aVar, byte[] bArr) {
        char c2;
        int a2;
        AppMethodBeat.i(21222);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[4];
        dataInputStream.read(bArr2);
        if (Arrays.equals(oJy, bArr2)) {
            int readInt = dataInputStream.readInt();
            short readShort = dataInputStream.readShort();
            short readShort2 = dataInputStream.readShort();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 > 16777216) {
                String format = String.format("loopRead size too large, size:%d", Integer.valueOf(readInt2));
                Log.e("MicroMsg.BackupCEngine", format);
                aVar.a(true, readInt, CdnLogic.kMediaTypeFavoriteBigFile, format.getBytes());
                AppMethodBeat.o(21222);
                return;
            }
            int readInt3 = dataInputStream.readInt();
            Log.i("MicroMsg.BackupCEngine", "read buf size[%d], seq[%d], version[%d], type[%d]", Integer.valueOf(readInt2), Integer.valueOf(readInt), Short.valueOf(readShort), Short.valueOf(readShort2));
            byte[] bArr3 = new byte[(readInt2 - 20)];
            if (dataInputStream.read(bArr3) == bArr3.length) {
                PByteArray pByteArray = new PByteArray();
                b.Bp(Util.getLength(bArr3));
                byte[] bArr4 = oJy;
                int ceP = b.ceP();
                if (readShort != 1) {
                    String format2 = String.format("unpack failed, getVersion[%d]", Short.valueOf(readShort));
                    Log.e("MicroMsg.BackupPacker", format2);
                    pByteArray.value = format2.getBytes();
                    c2 = 65535;
                } else if (ceP != 1 || readInt3 == (a2 = j.a(bArr4, readInt, readShort, readShort2, readInt2, bArr3))) {
                    if (!(readShort2 == 1 || readShort2 == 2)) {
                        bArr3 = l.d(bArr3, d.ceQ());
                    }
                    pByteArray.value = bArr3;
                    c2 = 0;
                } else {
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr3);
                    String format3 = String.format("unpack failed, calcSum[%d], checkSum[%d], seq[%d], type[%d], size[%d], crc[%d], last 100 bytes:%s", Integer.valueOf(a2), Integer.valueOf(readInt3), Integer.valueOf(readInt), Short.valueOf(readShort2), Integer.valueOf(readInt2), Integer.valueOf((int) crc32.getValue()), j.aT(bArr3));
                    Log.e("MicroMsg.BackupPacker", format3);
                    pByteArray.value = format3.getBytes();
                    c2 = 65534;
                }
                if (c2 != 0) {
                    aVar.a(true, readInt, CdnLogic.kMediaTypeFavoriteBigFile, (pByteArray.value == null ? "" : new String(pByteArray.value)).getBytes());
                    AppMethodBeat.o(21222);
                    return;
                } else if (aVar.oJB != null) {
                    aVar.oJB.b(readInt, readShort2, pByteArray.value);
                    AppMethodBeat.o(21222);
                    return;
                } else {
                    aVar.a(false, readInt, readShort2, pByteArray.value);
                }
            }
        }
        AppMethodBeat.o(21222);
    }
}
