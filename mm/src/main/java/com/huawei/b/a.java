package com.huawei.b;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.huawei.b.b;
import com.huawei.b.c;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private c cfQ;
    private b cfR;
    HandlerC0124a cfS;
    private int cfT;
    b cfU;
    int cfV = -1;
    private IBinder.DeathRecipient cfW = new IBinder.DeathRecipient() {
        /* class com.huawei.b.a.AnonymousClass1 */

        public final void binderDied() {
            AppMethodBeat.i(88781);
            if (a.this.cfU != null) {
                a.this.cfU.D(2101, -1, a.this.cfV);
            }
            AppMethodBeat.o(88781);
        }
    };

    public interface b {
        void D(int i2, int i3, int i4);

        void bQ(int i2, int i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.huawei.b.a$a  reason: collision with other inner class name */
    public class HandlerC0124a extends Handler {
        private final int cfY = 2001;
        private final int cfZ = 2002;
        private final int cga = 2003;
        private final int cgb = 2004;
        private final int cgc = 2005;
        private final int cgd = 2006;

        public HandlerC0124a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i2 = 2005;
            AppMethodBeat.i(88782);
            new StringBuilder("what = ").append(message.what);
            switch (message.what) {
                case 1:
                    if (a.this.cfU != null) {
                        a.this.cfU.bQ(1, a.this.cfV);
                        AppMethodBeat.o(88782);
                        return;
                    }
                    break;
                case 2:
                    if (a.this.cfU != null) {
                        a.this.cfU.bQ(2, a.this.cfV);
                        AppMethodBeat.o(88782);
                        return;
                    }
                    break;
                case 3:
                    if (a.this.cfU != null) {
                        a.this.cfU.bQ(3, a.this.cfV);
                        AppMethodBeat.o(88782);
                        return;
                    }
                    break;
                case 6:
                    if (a.this.cfU != null) {
                        a.this.cfU.D(0, message.arg1, a.this.cfV);
                    }
                    removeMessages(8);
                    AppMethodBeat.o(88782);
                    return;
                case 7:
                    if (a.this.cfU != null) {
                        switch (message.arg1) {
                            case 2001:
                                i2 = 2002;
                                break;
                            case 2002:
                                i2 = 2003;
                                break;
                            case 2003:
                            case 2006:
                                break;
                            case 2004:
                                i2 = 2000;
                                break;
                            case 2005:
                                i2 = 2006;
                                break;
                            default:
                                i2 = TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES;
                                break;
                        }
                        a.this.cfU.D(i2, -1, a.this.cfV);
                    }
                    removeMessages(8);
                    AppMethodBeat.o(88782);
                    return;
                case 8:
                    if (a.this.cfU != null) {
                        a.this.cfU.D(2001, -1, a.this.cfV);
                    }
                    removeMessages(8);
                    a.this.abort();
                    break;
            }
            AppMethodBeat.o(88782);
        }
    }

    public static a IE() {
        AppMethodBeat.i(88755);
        c IH = IH();
        if (IH == null) {
            AppMethodBeat.o(88755);
            return null;
        }
        try {
            a aVar = new a(IH, Looper.getMainLooper());
            AppMethodBeat.o(88755);
            return aVar;
        } catch (Exception e2) {
            AppMethodBeat.o(88755);
            return null;
        }
    }

    private a(c cVar, Looper looper) {
        AppMethodBeat.i(88756);
        this.cfQ = cVar;
        HandlerC0124a aVar = new HandlerC0124a(looper);
        this.cfT = 1;
        this.cfR = new b.a() {
            /* class com.huawei.b.a.AnonymousClass2 */

            @Override // com.huawei.b.b
            public final void a(int i2, int i3, int i4, byte[] bArr) {
                AppMethodBeat.i(88780);
                a.this.cfS.sendMessage(a.this.cfS.obtainMessage(i2, i3, i4, bArr));
                AppMethodBeat.o(88780);
            }
        };
        if (!this.cfQ.a(this.cfR, 1)) {
            RuntimeException runtimeException = new RuntimeException();
            AppMethodBeat.o(88756);
            throw runtimeException;
        }
        this.cfS = aVar;
        cVar.asBinder().linkToDeath(this.cfW, 0);
        AppMethodBeat.o(88756);
    }

    public final void release() {
        AppMethodBeat.i(88757);
        if (this.cfS != null) {
            this.cfS.removeMessages(8);
        }
        try {
            this.cfQ.b(this.cfR);
            this.cfQ.asBinder().unlinkToDeath(this.cfW, 0);
            AppMethodBeat.o(88757);
        } catch (RemoteException e2) {
            AppMethodBeat.o(88757);
        }
    }

    public final int[] IF() {
        AppMethodBeat.i(88758);
        try {
            int[] c2 = this.cfQ.c(this.cfR);
            AppMethodBeat.o(88758);
            return c2;
        } catch (RemoteException e2) {
            int[] iArr = new int[0];
            AppMethodBeat.o(88758);
            return iArr;
        }
    }

    public final int a(b bVar, int[] iArr) {
        int i2 = -1;
        AppMethodBeat.i(88759);
        if (iArr == null) {
            AppMethodBeat.o(88759);
        } else {
            this.cfU = bVar;
            this.cfV = 0;
            try {
                i2 = this.cfQ.a(this.cfR, iArr, (byte[]) null);
                AppMethodBeat.o(88759);
            } catch (RemoteException e2) {
                AppMethodBeat.o(88759);
            }
        }
        return i2;
    }

    public final void abort() {
        AppMethodBeat.i(88760);
        if (this.cfS != null) {
            this.cfS.removeMessages(8);
        }
        try {
            this.cfQ.a(this.cfR);
            AppMethodBeat.o(88760);
        } catch (RemoteException e2) {
            AppMethodBeat.o(88760);
        }
    }

    public static int[] IG() {
        AppMethodBeat.i(88761);
        c IH = IH();
        if (IH == null) {
            int[] iArr = new int[0];
            AppMethodBeat.o(88761);
            return iArr;
        }
        try {
            int[] II = IH.II();
            AppMethodBeat.o(88761);
            return II;
        } catch (RemoteException e2) {
            int[] iArr2 = new int[0];
            AppMethodBeat.o(88761);
            return iArr2;
        }
    }

    private static c IH() {
        AppMethodBeat.i(88762);
        c j2 = c.a.j(ServiceManager.getService("authentication_service"));
        AppMethodBeat.o(88762);
        return j2;
    }
}
