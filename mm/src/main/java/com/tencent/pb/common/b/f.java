package com.tencent.pb.common.b;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.pb.talkroom.sdk.e;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.wecall.talkroom.model.h;
import java.util.Iterator;
import java.util.LinkedList;

public class f {
    private static f RCS = null;
    private int RCT;
    private LinkedList<a> RCU;
    public e RCV;
    private boolean RCW;
    private boolean RCX;

    public class a {
        public String RCY;
        a RCZ;
        c RDa;
        int mTaskId;

        private a() {
        }

        /* synthetic */ a(f fVar, byte b2) {
            this();
        }
    }

    private f() {
        this.RCT = 0;
        this.RCU = null;
        this.RCV = null;
        this.RCW = false;
        this.RCX = true;
        this.RCU = new LinkedList<>();
        this.RCX = true;
    }

    private static a.x cP(byte[] bArr) {
        try {
            return (a.x) com.google.a.a.e.a(new a.x(), bArr, bArr.length);
        } catch (Exception e2) {
            b.w("NETCMD", "Exception genReadPackageData" + e2.getMessage());
            return null;
        }
    }

    private int a(a aVar, c cVar, String str, int i2, byte[] bArr, int i3) {
        byte[] bArr2;
        byte[] bArr3 = null;
        int hiY = hiY();
        try {
            if (bArr.length < 200 || bArr == null || bArr.length >= bArr.length) {
            }
            a.w wVar = new a.w();
            wVar.EX = i2;
            wVar.REE = hiY;
            wVar.userName = com.tencent.pb.a.a.a.hjq();
            wVar.RDt = i3;
            if (bArr == null) {
                b.w("NETCMD", "body null");
            } else {
                a.x xVar = new a.x();
                xVar.REH = wVar;
                xVar.body = bArr;
                bArr3 = com.google.a.a.e.b(xVar);
            }
            bArr2 = bArr3;
        } catch (Exception e2) {
            b.w("NetError", "newTaskHelper addTask body null");
            bArr2 = null;
        }
        if (bArr2 == null) {
            b.w("NETCMD", "cmd:" + i2 + "|body is null");
            return -1;
        } else if (bArr2.length > 61440) {
            b.w("NETCMD", "cmd:" + i2 + "|body too large");
            return -1;
        } else {
            a aVar2 = new a(this, (byte) 0);
            aVar2.mTaskId = hiY;
            aVar2.RCZ = aVar;
            aVar2.RDa = cVar;
            aVar2.RCY = str;
            synchronized (this.RCU) {
                this.RCU.add(aVar2);
            }
            int i4 = 1933;
            switch (i2) {
                case com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX:
                    i4 = 1918;
                    break;
                case 141:
                    i4 = 1919;
                    break;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_4 /*{ENCODED_INT: 143}*/:
                    i4 = 1927;
                    break;
                case 145:
                    i4 = 1931;
                    break;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_8 /*{ENCODED_INT: 147}*/:
                    i4 = 1932;
                    break;
                case 181:
                    i4 = 1929;
                    break;
                case 183:
                    i4 = 1928;
                    break;
                case 189:
                    i4 = 1935;
                    break;
                case 211:
                    i4 = 1937;
                    break;
                case TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS /*{ENCODED_INT: 221}*/:
                    i4 = 1938;
                    break;
                case TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM /*{ENCODED_INT: 223}*/:
                    i4 = 1939;
                    break;
            }
            b.d("NETCMD", "CLTSEND|", Integer.valueOf(hiY), Integer.valueOf(i4), str, com.tencent.pb.a.a.a.hjq());
            if (this.RCV != null) {
                this.RCV.d(hiY, i4, bArr2);
            }
            return hiY;
        }
    }

    private int hiY() {
        int i2;
        synchronized (this.RCU) {
            this.RCT++;
            i2 = this.RCT;
        }
        return i2;
    }

    public final a aqt(int i2) {
        a aVar;
        synchronized (this.RCU) {
            Iterator<a> it = this.RCU.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = it.next();
                if (aVar.mTaskId == i2) {
                    break;
                }
            }
        }
        return aVar;
    }

    public static f hiZ() {
        if (RCS == null) {
            synchronized (f.class) {
                if (RCS == null) {
                    RCS = new f();
                }
            }
        }
        return RCS;
    }

    /* access modifiers changed from: package-private */
    public final int a(a aVar, c cVar, int i2, String str, byte[] bArr, int i3) {
        if (!this.RCX) {
            b.w("NETCMD", "doSendTask mIsInitSucc is false");
            return -1;
        } else if (this.RCW) {
            b.w("NETCMD", "doSendTask fail: isRefreshing, cmd=" + i2 + ", cmdTag=" + str);
            return -1;
        } else {
            try {
                return a(aVar, cVar, str, i2, bArr, i3);
            } catch (Throwable th) {
                b.w("NETCMD", "Exception doSendTask", th);
                return -1;
            }
        }
    }

    public final int a(a aVar, String str, com.google.a.a.e eVar) {
        try {
            return a(aVar, (c) null, 31, str, com.google.a.a.e.b(eVar), 0);
        } catch (Exception e2) {
            b.w("NETCMD", "doSendTask exception:", e2);
            return -1;
        }
    }

    public static int cQ(byte[] bArr) {
        if (bArr == null) {
            b.w("NETCMD", "CLTNOT onNotify1 data == null ", 0);
            h.asK(-1601);
            if (!TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.hqJ().xOr) || !TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.hqJ().SuH)) {
                com.tencent.wecall.talkroom.model.a.hqJ().SuY.ag("notify", "datanull");
            } else {
                h.a(com.tencent.wecall.talkroom.model.a.hqJ().yvK, com.tencent.wecall.talkroom.model.a.hqJ().HgX, "notify", "datanull");
            }
            return -1;
        }
        b.d("NETCMD", "CLTNOT onNotify data len=", Integer.valueOf(bArr.length));
        return com.tencent.wecall.talkroom.model.a.hqJ().dc(bArr);
    }

    public final void a(a aVar, int i2, byte[] bArr) {
        try {
            if (aVar.RDa != null) {
                aVar.RDa.onResp(i2, bArr);
            }
            if (aVar.RCZ != null) {
                aVar.RCZ.hu(aVar.RCY, i2);
            }
        } catch (Exception e2) {
            b.w("NETCMD", "postRespData", e2.getMessage());
        }
        synchronized (this.RCU) {
            this.RCU.remove(aVar);
        }
    }

    public final int u(int i2, byte[] bArr) {
        String str;
        a aqt = aqt(i2);
        if (aqt != null || -1000 == i2) {
            a.x cP = cP(bArr);
            if (cP == null || cP.REH == null) {
                Object[] objArr = new Object[2];
                objArr[0] = " pack.head: ";
                if (cP == null) {
                    str = " pack is null ";
                } else {
                    str = " head is " + cP.REH;
                }
                objArr[1] = str;
                b.w("NETCMD", objArr);
                a(aqt, -3, (byte[]) null);
                return -1;
            }
            int i3 = cP.REH.ret;
            int i4 = cP.REH.REG;
            String str2 = cP.REH.userName;
            if (com.tencent.pb.common.a.a.RCj) {
                Toast.makeText(c.Hhs, "retCode: " + i3 + " debugCode: " + i4, 0).show();
            }
            if (i3 != 0 && aqt != null) {
                b.w("NETCMD", "CLTRCV", Integer.valueOf(i2), aqt.RCY, Integer.valueOf(i3), str2, Integer.valueOf(i4));
            } else if (aqt != null) {
                b.d("NETCMD", "CLTRCV", Integer.valueOf(i2), aqt.RCY, Integer.valueOf(i3), str2, Integer.valueOf(i4));
            }
            byte[] bArr2 = cP.body;
            if (bArr2 != null) {
                a(aqt, i3, bArr2);
                return 0;
            }
            a(aqt, i3, (byte[]) null);
            return 0;
        }
        b.w("NETCMD", "buf2Resp fail: taskId:" + i2 + " not found");
        com.tencent.pb.common.c.e.U(20007, 3, "-1202");
        return 1;
    }
}
