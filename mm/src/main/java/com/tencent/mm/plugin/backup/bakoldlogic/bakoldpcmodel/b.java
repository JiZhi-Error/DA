package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.b.o;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.zip.CRC32;

public final class b implements b.a {
    public static final byte[] oJy = "GSMW".getBytes();
    private Object lock = new Object();
    private Boolean oRi = Boolean.FALSE;
    private MMHandler oRj = null;
    private MMHandler oRk = new MMHandler(Looper.getMainLooper());
    private DataOutputStream oRl = null;
    private int oRm = 0;
    private int oRn = 0;
    private long oRo = 0;
    private ServerSocket serverSocket = null;
    private Socket socket = null;

    static /* synthetic */ void a(b bVar, int i2, byte[] bArr) {
        AppMethodBeat.i(21879);
        bVar.a(true, 0, i2, bArr);
        AppMethodBeat.o(21879);
    }

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(21881);
        bVar.che();
        AppMethodBeat.o(21881);
    }

    static {
        AppMethodBeat.i(21882);
        AppMethodBeat.o(21882);
    }

    public b() {
        AppMethodBeat.i(21869);
        chf();
        AppMethodBeat.o(21869);
    }

    public final void f(final int i2, final List<adi> list) {
        AppMethodBeat.i(21870);
        Log.i("MicroMsg.BakOldJavaEngine", "connect type:%d", Integer.valueOf(i2));
        chf();
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b.AnonymousClass1 */

            public final void run() {
                int i2;
                AppMethodBeat.i(21864);
                switch (i2) {
                    case 1:
                        WifiManager wifiManager = (WifiManager) MMApplicationContext.getContext().getSystemService("wifi");
                        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
                        if (dhcpInfo == null) {
                            AppMethodBeat.o(21864);
                            return;
                        }
                        int i3 = dhcpInfo.netmask;
                        String str = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                        Log.e("MicroMsg.BakOldJavaEngine", "localip:%s, mask:%d", str, Integer.valueOf(i3));
                        String str2 = null;
                        int i4 = 0;
                        for (adi adi : list) {
                            Log.i("MicroMsg.BakOldJavaEngine", "try ip:%s", adi.LjZ);
                            if (adi.LjZ != null) {
                                String[] split = adi.LjZ.split("\\.");
                                if (split.length >= 4) {
                                    int S = o.S(new byte[]{(byte) (Util.getInt(split[0], 0) & 255), (byte) (Util.getInt(split[1], 0) & 255), (byte) (Util.getInt(split[2], 0) & 255), (byte) (Util.getInt(split[3], 0) & 255)});
                                    if ((i3 & S) == (i3 & ipAddress)) {
                                        b.a(b.this, adi.LjZ, adi.Low.getFirst().intValue());
                                        AppMethodBeat.o(21864);
                                        return;
                                    }
                                    if ((S & 65535) == (65535 & ipAddress)) {
                                        String str3 = adi.LjZ;
                                        i2 = adi.Low.getFirst().intValue();
                                        str2 = str3;
                                    } else {
                                        i2 = i4;
                                    }
                                    i4 = i2;
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (str2 != null) {
                            Log.w("MicroMsg.BakOldJavaEngine", "try to connect to secondary:%s, port:%d", str2, Integer.valueOf(i4));
                            b.a(b.this, str2, i4);
                            AppMethodBeat.o(21864);
                            return;
                        }
                        b.a(b.this, 10009, String.format("not match ip mask:%d, localip:%s", Integer.valueOf(i3), str).getBytes());
                        Log.e("MicroMsg.BakOldJavaEngine", "not match ip mask:%d, localip:%s", Integer.valueOf(i3), str);
                        AppMethodBeat.o(21864);
                        return;
                    case 0:
                        b.a(b.this, ((adi) list.get(0)).Low.getFirst().intValue());
                        break;
                }
                AppMethodBeat.o(21864);
            }
        }, "BackupJavaEngine_connect");
        AppMethodBeat.o(21870);
    }

    public final void chd() {
        AppMethodBeat.i(21871);
        Log.i("MicroMsg.BakOldJavaEngine", "close connect");
        che();
        a(true, 0, ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, null);
        AppMethodBeat.o(21871);
    }

    private void che() {
        AppMethodBeat.i(21872);
        this.oRm = 0;
        this.oRn = 0;
        this.oRo = 0;
        this.oRi = Boolean.TRUE;
        try {
            synchronized (this.lock) {
                try {
                    if (this.oRl != null) {
                        this.oRl.close();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(21872);
                    throw th;
                }
            }
        } catch (Exception e2) {
        }
        try {
            if (this.socket != null) {
                this.socket.close();
            }
            AppMethodBeat.o(21872);
        } catch (Exception e3) {
            AppMethodBeat.o(21872);
        }
    }

    private void a(final boolean z, final int i2, final int i3, final byte[] bArr) {
        AppMethodBeat.i(21873);
        this.oRk.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(21865);
                com.tencent.mm.plugin.backup.g.b.b(z, i2, i3, bArr);
                AppMethodBeat.o(21865);
            }
        });
        AppMethodBeat.o(21873);
    }

    @Override // com.tencent.mm.plugin.backup.g.b.a
    public final void l(final int i2, final byte[] bArr) {
        AppMethodBeat.i(21874);
        if (this.oRj != null) {
            aU(bArr);
            AppMethodBeat.o(21874);
            return;
        }
        this.oRk.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(21866);
                b.this.aU(bArr);
                AppMethodBeat.o(21866);
            }
        }, 200);
        AppMethodBeat.o(21874);
    }

    @Override // com.tencent.mm.plugin.backup.g.b.a
    public final int m(int i2, byte[] bArr) {
        return 0;
    }

    public final void aU(final byte[] bArr) {
        AppMethodBeat.i(21875);
        if (this.oRi.booleanValue()) {
            Log.e("MicroMsg.BakOldJavaEngine", "engine has stop");
            AppMethodBeat.o(21875);
            return;
        }
        this.oRj.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(21867);
                try {
                    synchronized (b.this.lock) {
                        try {
                            b.this.oRl.write(bArr);
                            b.this.oRl.flush();
                        } finally {
                            AppMethodBeat.o(21867);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.BakOldJavaEngine", "send_error %s", e2);
                    b.c(b.this);
                    b.a(b.this, 10008, "send_error ".concat(String.valueOf(e2)).getBytes());
                    AppMethodBeat.o(21867);
                }
            }
        });
        AppMethodBeat.o(21875);
    }

    private void chf() {
        AppMethodBeat.i(21876);
        if (this.oRj == null || this.oRj.isQuit()) {
            this.oRj = new MMHandler("BackupJavaEngine_handler");
        }
        AppMethodBeat.o(21876);
    }

    private void a(DataInputStream dataInputStream) {
        int i2;
        int a2;
        boolean z;
        AppMethodBeat.i(21877);
        while (!this.oRi.booleanValue() && this.oRm != 4) {
            try {
                byte readByte = dataInputStream.readByte();
                if (oJy[this.oRm] == readByte) {
                    this.oRm++;
                } else {
                    long nowSecond = Util.nowSecond();
                    if (((long) this.oRn) - (nowSecond - this.oRo) < 10) {
                        if (this.oRn < 0) {
                            this.oRn = 0;
                        }
                        this.oRn++;
                        this.oRo = nowSecond;
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        String format = String.format("GSMW in the %dth step error:expect:%02X, butGet:%02X", Integer.valueOf(this.oRm + 1), Integer.valueOf(oJy[this.oRm] & 255), Integer.valueOf(readByte & 255));
                        Log.e("MicroMsg.BakOldJavaEngine", format);
                        a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, format.getBytes());
                    }
                    this.oRm = 0;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.BakOldJavaEngine", "loopRead %s", e2);
                try {
                    dataInputStream.close();
                } catch (IOException e3) {
                }
                if (!this.oRi.booleanValue()) {
                    a(true, 0, 10006, "read_error ".concat(String.valueOf(e2)).getBytes());
                }
                che();
                AppMethodBeat.o(21877);
                return;
            }
        }
        this.oRm = 0;
        int readInt = dataInputStream.readInt();
        short readShort = dataInputStream.readShort();
        short readShort2 = dataInputStream.readShort();
        int readInt2 = dataInputStream.readInt();
        if (readInt2 > 16777216) {
            String format2 = String.format("loopRead size to large:%d", Integer.valueOf(readInt2));
            Log.e("MicroMsg.BakOldJavaEngine", format2);
            this.oRi = Boolean.TRUE;
            a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, format2.getBytes());
            AppMethodBeat.o(21877);
            return;
        }
        int readInt3 = dataInputStream.readInt();
        Log.i("MicroMsg.BakOldJavaEngine", "read buf size:".concat(String.valueOf(readInt2)));
        byte[] bArr = new byte[(readInt2 - 20)];
        int i3 = 0;
        while (i3 < bArr.length) {
            int read = dataInputStream.read(bArr, i3, bArr.length - i3);
            if (read == -1) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e4) {
                }
            } else {
                i3 += read;
            }
        }
        PByteArray pByteArray = new PByteArray();
        byte[] bArr2 = oJy;
        if (readShort != 1) {
            String format3 = String.format("unpack failed, getVersion:%d", Short.valueOf(readShort));
            Log.e("MicroMsg.BakOldPacker", format3);
            pByteArray.value = format3.getBytes();
            i2 = -1;
        } else if (com.tencent.mm.plugin.backup.g.b.ceP() != 1 || readInt3 == (a2 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.a(bArr2, readInt, readShort, readShort2, readInt2, bArr))) {
            if (!(readShort2 == 1 || readShort2 == 2)) {
                bArr = l.d(bArr, d.ceQ());
            }
            pByteArray.value = bArr;
            i2 = 0;
        } else {
            CRC32 crc32 = new CRC32();
            crc32.update(bArr);
            String format4 = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", Integer.valueOf(a2), Integer.valueOf(readInt3), Integer.valueOf(readInt), Short.valueOf(readShort2), Integer.valueOf(readInt2), Integer.valueOf((int) crc32.getValue()), com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.aT(bArr));
            Log.e("MicroMsg.BakOldPacker", format4);
            pByteArray.value = format4.getBytes();
            i2 = -2;
        }
        Log.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d]", Integer.valueOf(i2));
        if (i2 != 0) {
            a(true, 0, CdnLogic.kMediaTypeFavoriteBigFile, (pByteArray.value == null ? "" : new String(pByteArray.value)).getBytes());
            AppMethodBeat.o(21877);
            return;
        }
        Log.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", Integer.valueOf(i2), Integer.valueOf(readInt), Short.valueOf(readShort2));
        a(false, readInt, readShort2, pByteArray.value);
        AppMethodBeat.o(21877);
    }

    static /* synthetic */ void a(b bVar, String str, int i2) {
        AppMethodBeat.i(21878);
        int i3 = ((i2 & 255) << 8) | ((i2 >> 8) & 255);
        Log.i("MicroMsg.BakOldJavaEngine", "doConnect serverIp:%s, port:%d", str, Integer.valueOf(i3));
        try {
            InetAddress byName = InetAddress.getByName(str);
            Log.i("MicroMsg.BakOldJavaEngine", "TCP  Connecting...");
            bVar.socket = new Socket(byName, i3);
            bVar.socket.setKeepAlive(true);
            Log.i("MicroMsg.BakOldJavaEngine", "TCP connected" + bVar.socket.toString());
            bVar.oRl = new DataOutputStream(new BufferedOutputStream(bVar.socket.getOutputStream()));
            DataInputStream dataInputStream = new DataInputStream(bVar.socket.getInputStream());
            bVar.oRi = Boolean.FALSE;
            bVar.a(true, 0, 10002, null);
            while (!bVar.oRi.booleanValue()) {
                bVar.a(dataInputStream);
            }
            AppMethodBeat.o(21878);
        } catch (IOException e2) {
            Log.e("MicroMsg.BakOldJavaEngine", "doConnect %s", e2);
            bVar.che();
            bVar.a(true, 0, ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, "doConnect ".concat(String.valueOf(e2)).getBytes());
            AppMethodBeat.o(21878);
        }
    }

    static /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(21880);
        int i3 = ((i2 >> 8) & 255) | ((i2 & 255) << 8);
        Log.i("MicroMsg.BakOldJavaEngine", "doListen port:%d", Integer.valueOf(i3));
        bVar.serverSocket = null;
        try {
            Log.i("MicroMsg.BakOldJavaEngine", "ip:".concat(String.valueOf(InetAddress.getLocalHost().getHostAddress())));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BakOldJavaEngine", e2, "getHostAddress", new Object[0]);
        }
        try {
            Log.i("MicroMsg.BakOldJavaEngine", "before init ");
            bVar.serverSocket = new ServerSocket(i3);
            Log.i("MicroMsg.BakOldJavaEngine", "before accept server:  " + bVar.serverSocket.toString());
            bVar.socket = bVar.serverSocket.accept();
            bVar.socket.setKeepAlive(true);
            Log.i("MicroMsg.BakOldJavaEngine", "after accept client:  " + bVar.socket.toString());
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(bVar.socket.getInputStream()));
            bVar.oRl = new DataOutputStream(new BufferedOutputStream(bVar.socket.getOutputStream()));
            bVar.oRi = Boolean.FALSE;
            bVar.a(true, 0, 10001, null);
            while (!bVar.oRi.booleanValue()) {
                bVar.a(dataInputStream);
            }
            AppMethodBeat.o(21880);
        } catch (IOException e3) {
            Log.e("MicroMsg.BakOldJavaEngine", "doListen %s", e3);
            bVar.che();
            bVar.a(true, 0, 10005, "doListenErr ".concat(String.valueOf(e3)).getBytes());
            AppMethodBeat.o(21880);
        }
    }
}
