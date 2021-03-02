package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Message;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class c {

    public static final class a {
        public final MMHandler mHandler;
        BluetoothSocket pjH;
        final boolean pjI = true;
        public final b pjJ;
        public final a pjK;
        boolean pjL = false;
        final BluetoothDevice pjM;

        /* renamed from: com.tencent.mm.plugin.d.a.c.c$a$a  reason: collision with other inner class name */
        static class C0938a extends MMHandler {
            private WeakReference<a> phi = null;

            public C0938a(com.tencent.f.j.a aVar, a aVar2) {
                super(aVar);
                AppMethodBeat.i(179584);
                this.phi = new WeakReference<>(aVar2);
                AppMethodBeat.o(179584);
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(22597);
                a aVar = this.phi.get();
                if (aVar == null) {
                    Log.e("MicroMsg.exdevice.BluetoothChatThreads", "null == connectTread");
                    AppMethodBeat.o(22597);
                    return;
                }
                switch (message.what) {
                    case 0:
                        Log.i("MicroMsg.exdevice.ConnectThread", "------connectImp------");
                        if (aVar.pjL) {
                            Log.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready connect, just leave");
                            AppMethodBeat.o(22597);
                            return;
                        }
                        try {
                            if (aVar.pjI) {
                                aVar.pjH = aVar.pjM.createRfcommSocketToServiceRecord(a.pjy);
                            } else {
                                aVar.pjH = aVar.pjM.createInsecureRfcommSocketToServiceRecord(a.pjz);
                            }
                            try {
                                aVar.pjH.connect();
                                aVar.pjL = true;
                                b bVar = aVar.pjJ;
                                a aVar2 = aVar.pjK;
                                BluetoothSocket bluetoothSocket = aVar.pjH;
                                Log.i("MicroMsg.exdevice.BluetoothChatSession", "connected");
                                bVar.mState = 3;
                                if (bVar.pjF != null) {
                                    bVar.pjF.cancel();
                                    bVar.pjF = null;
                                }
                                if (bVar.pjG != null) {
                                    bVar.pjG.cancel();
                                    bVar.pjG = null;
                                }
                                bVar.pjF = new b(bVar, aVar2, bluetoothSocket);
                                h.RTc.ba(bVar.pjF);
                                bVar.pjG = new C0939c(bVar, aVar2, bluetoothSocket);
                                h.RTc.ba(bVar.pjG);
                                if (aVar.pjK != null) {
                                    aVar.pjK.pjA.l(aVar.pjJ.mSessionId, true);
                                }
                                AppMethodBeat.o(22597);
                                return;
                            } catch (Exception e2) {
                                Log.e("MicroMsg.exdevice.ConnectThread", "socket connect failed (%s)", e2.toString());
                                try {
                                    aVar.pjH.close();
                                } catch (IOException e3) {
                                    Log.e("MicroMsg.exdevice.ConnectThread", "Close socket failed!!! (%s)", e3.toString());
                                }
                                if (aVar.pjK != null) {
                                    aVar.pjK.pjA.l(aVar.pjJ.mSessionId, false);
                                }
                                AppMethodBeat.o(22597);
                                return;
                            }
                        } catch (IOException e4) {
                            aVar.pjH = null;
                            Log.e("MicroMsg.exdevice.ConnectThread", "createRfcommSocket Failed!!! (%s)", e4.toString());
                            if (aVar.pjK != null) {
                                aVar.pjK.pjA.l(aVar.pjJ.mSessionId, false);
                            }
                            AppMethodBeat.o(22597);
                            return;
                        }
                    case 1:
                        if (aVar.pjL) {
                            try {
                                aVar.pjH.close();
                                AppMethodBeat.o(22597);
                                return;
                            } catch (IOException e5) {
                                Log.e("MicroMsg.exdevice.ConnectThread", "socket close failed (%s)", e5.toString());
                                break;
                            }
                        } else {
                            Log.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready disconnect, just leave");
                            AppMethodBeat.o(22597);
                            return;
                        }
                }
                AppMethodBeat.o(22597);
            }
        }

        public a(b bVar, a aVar, BluetoothDevice bluetoothDevice) {
            AppMethodBeat.i(22598);
            this.pjK = aVar;
            this.pjJ = bVar;
            this.pjM = bluetoothDevice;
            this.mHandler = new C0938a(com.tencent.f.j.a.bqt("BluetoothChatThreads_handlerThread"), this);
            AppMethodBeat.o(22598);
        }

        public final void disconnect() {
            AppMethodBeat.i(22599);
            Log.i("MicroMsg.exdevice.ConnectThread", "------disconnect------");
            if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1))) {
                Log.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", 1);
            }
            this.mHandler.quitSafely();
            AppMethodBeat.o(22599);
        }
    }

    public static final class b implements com.tencent.f.i.h {
        private final BluetoothSocket pjH;
        private b pjJ;
        a pjK;
        private InputStream pjN = null;
        private volatile boolean pjO = false;

        public b(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
            AppMethodBeat.i(22600);
            this.pjH = bluetoothSocket;
            this.pjJ = bVar;
            this.pjK = aVar;
            try {
                this.pjN = bluetoothSocket.getInputStream();
                AppMethodBeat.o(22600);
            } catch (IOException e2) {
                this.pjN = null;
                Log.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", e2.toString());
                AppMethodBeat.o(22600);
            }
        }

        public final void run() {
            AppMethodBeat.i(22601);
            Log.i("MicroMsg.exdevice.RecvThread", "BEGIN RecvThread");
            if (this.pjN == null) {
                Log.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
                AppMethodBeat.o(22601);
                return;
            }
            byte[] bArr = new byte[2048];
            while (!this.pjO) {
                try {
                    int read = this.pjN.read(bArr);
                    if (read > 0) {
                        Log.i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", Integer.valueOf(read));
                        Log.d("MicroMsg.exdevice.RecvThread", "data dump = %s", com.tencent.mm.plugin.exdevice.k.b.V(bArr, read));
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, read);
                        if (this.pjK != null) {
                            this.pjK.pjA.b(this.pjJ.mSessionId, bArr2);
                        }
                    }
                } catch (IOException e2) {
                    Log.e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", e2.toString());
                    try {
                        this.pjH.close();
                        AppMethodBeat.o(22601);
                        return;
                    } catch (IOException e3) {
                        Log.e("MicroMsg.exdevice.RecvThread", "Close socket failed!!! (%s)", e3.toString());
                        AppMethodBeat.o(22601);
                        return;
                    }
                }
            }
            Log.w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
            AppMethodBeat.o(22601);
        }

        public final void cancel() {
            AppMethodBeat.i(22602);
            Log.i("MicroMsg.exdevice.RecvThread", "------cancel------");
            if (this.pjO) {
                Log.w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
                AppMethodBeat.o(22602);
                return;
            }
            this.pjO = true;
            try {
                this.pjH.close();
                AppMethodBeat.o(22602);
            } catch (IOException e2) {
                Log.e("MicroMsg.exdevice.RecvThread", "close() of connect socket failed", e2);
                AppMethodBeat.o(22602);
            }
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "BluetoothChatSession_recv";
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.c.c$c  reason: collision with other inner class name */
    public static final class C0939c implements com.tencent.f.i.h {
        private b pjJ = null;
        private a pjK = null;
        private volatile boolean pjO = false;
        private volatile Runnable pjP = null;
        private OutputStream pjQ = null;
        private final LinkedList<byte[]> pjR = new LinkedList<>();
        private final LinkedList<byte[]> pjS = new LinkedList<>();

        public C0939c(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
            AppMethodBeat.i(22603);
            this.pjJ = bVar;
            this.pjK = aVar;
            try {
                OutputStream outputStream = bluetoothSocket.getOutputStream();
                this.pjP = this;
                this.pjQ = outputStream;
                AppMethodBeat.o(22603);
            } catch (IOException e2) {
                Log.e("MicroMsg.exdevice.SendThread", "temp sockets not created", e2);
                this.pjQ = null;
                if (this.pjK != null) {
                    this.pjK.pjA.c(this.pjJ.mSessionId, 11, "Can not get write stream");
                }
                AppMethodBeat.o(22603);
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 152
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
            */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 173
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.d.a.c.c.C0939c.run():void");
        }

        public final boolean aZ(byte[] bArr) {
            AppMethodBeat.i(22605);
            Log.i("MicroMsg.exdevice.SendThread", "------write------buffer length = %d", Integer.valueOf(bArr.length));
            if (this.pjP == null) {
                Log.e("MicroMsg.exdevice.SendThread", "Send thread has been close. Send data abort");
                AppMethodBeat.o(22605);
                return false;
            }
            synchronized (this) {
                try {
                    this.pjR.add(bArr);
                    notify();
                } finally {
                    AppMethodBeat.o(22605);
                }
            }
            return true;
        }

        public final void cancel() {
            AppMethodBeat.i(22606);
            this.pjP = null;
            this.pjO = true;
            synchronized (this) {
                try {
                    notify();
                } catch (Throwable th) {
                    AppMethodBeat.o(22606);
                    throw th;
                }
            }
            this.pjS.clear();
            this.pjR.clear();
            AppMethodBeat.o(22606);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "BluetoothChatSession_send";
        }
    }
}
