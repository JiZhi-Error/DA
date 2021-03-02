package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ap.a;
import com.tencent.mm.b.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class al implements StnLogic.ICallBack {
    private static WakerLock jGc = null;
    private static int jGd = 1000000205;
    private static int jGe = 205;
    private static byte[] jGf;
    private static byte[] jGg;

    private static String exception2String(Exception exc) {
        AppMethodBeat.i(132949);
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(132949);
        return stringWriter2;
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final boolean makesureAuthed(String str) {
        boolean z = false;
        AppMethodBeat.i(132950);
        if (af.bkl() == null) {
            AppMethodBeat.o(132950);
        } else {
            try {
                z = af.bkl().RT(str);
                AppMethodBeat.o(132950);
            } catch (Exception e2) {
                Log.e("StnCallBack", exception2String(e2));
                new StringBuilder().append(e2.getClass().getSimpleName()).append(":").append(e2.getStackTrace()[0]).append(", ").append(e2.getStackTrace()[1]);
                AppMethodBeat.o(132950);
            }
        }
        return z;
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final String[] onNewDns(String str) {
        return new String[0];
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final void onPush(String str, final int i2, int i3, final byte[] bArr) {
        AppMethodBeat.i(197113);
        if (af.bkn() == null) {
            AppMethodBeat.o(197113);
            return;
        }
        try {
            if (jGc == null) {
                jGc = new WakerLock(af.getContext(), "StnCallBack");
            }
            jGc.lock(1000, "StnLogic.onNotify");
            af.bkj().post(new Runnable() {
                /* class com.tencent.mm.network.al.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(132946);
                    af.bkn().j(i2, bArr);
                    AppMethodBeat.o(132946);
                }
            });
            try {
                if (af.bkp() != null) {
                    af.bkp().K("push_notify", bArr != null ? (long) bArr.length : 0);
                }
                AppMethodBeat.o(197113);
            } catch (Exception e2) {
                Log.e("StnCallBack", "onPush Exception:%s", Util.stackTraceToString(e2));
                AppMethodBeat.o(197113);
            }
        } catch (Exception e3) {
            Log.e("StnCallBack", exception2String(e3));
            new StringBuilder().append(e3.getClass().getSimpleName()).append(":").append(e3.getStackTrace()[0]).append(", ").append(e3.getStackTrace()[1]);
            AppMethodBeat.o(197113);
        }
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final boolean req2Buf(int i2, Object obj, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i3, String str) {
        AppMethodBeat.i(132952);
        if (af.bkm() == null) {
            AppMethodBeat.o(132952);
            return false;
        }
        try {
            boolean a2 = af.bkm().a(i2, byteArrayOutputStream, iArr, i3, str);
            AppMethodBeat.o(132952);
            return a2;
        } catch (Exception e2) {
            Log.e("StnCallBack", exception2String(e2));
            new StringBuilder().append(e2.getClass().getSimpleName()).append(":").append(e2.getStackTrace()[0]).append(", ").append(e2.getStackTrace()[1]);
            AppMethodBeat.o(132952);
            return false;
        }
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final int buf2Resp(int i2, Object obj, byte[] bArr, int[] iArr, int[] iArr2, int i3) {
        int i4 = -1;
        AppMethodBeat.i(132953);
        if (af.bkm() == null) {
            AppMethodBeat.o(132953);
        } else {
            try {
                i4 = af.bkm().a(i2, bArr, iArr, iArr2);
                AppMethodBeat.o(132953);
            } catch (Exception e2) {
                Log.e("StnCallBack", exception2String(e2));
                new StringBuilder().append(e2.getClass().getSimpleName()).append(":").append(e2.getStackTrace()[0]).append(", ").append(e2.getStackTrace()[1]);
                AppMethodBeat.o(132953);
            }
        }
        return i4;
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final int onTaskEnd(final int i2, final Object obj, final int i3, final int i4, final StnLogic.CgiProfile cgiProfile) {
        int i5;
        AppMethodBeat.i(197114);
        if (af.bkm() == null) {
            AppMethodBeat.o(197114);
            return 0;
        }
        Log.d("StnCallBack", "onTaskEnd " + cgiProfile.startConnectTime + " " + cgiProfile.readPacketFinishedTime);
        int i6 = 0;
        try {
            i6 = af.bkm().uz(i2);
            af.bkj().post(new Runnable() {
                /* class com.tencent.mm.network.al.AnonymousClass2 */

                /* JADX WARNING: Removed duplicated region for block: B:166:0x0605 A[ADDED_TO_REGION] */
                /* JADX WARNING: Removed duplicated region for block: B:183:0x0665 A[SYNTHETIC, Splitter:B:183:0x0665] */
                /* JADX WARNING: Removed duplicated region for block: B:40:0x0162 A[Catch:{ RemoteException -> 0x02a3 }] */
                /* JADX WARNING: Removed duplicated region for block: B:57:0x01d8  */
                /* JADX WARNING: Removed duplicated region for block: B:61:0x01eb A[Catch:{ Exception -> 0x0208 }] */
                /* JADX WARNING: Removed duplicated region for block: B:90:0x0294  */
                /* JADX WARNING: Removed duplicated region for block: B:98:0x02dc  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    // Method dump skipped, instructions count: 1936
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.network.al.AnonymousClass2.run():void");
                }
            });
            i5 = i6;
        } catch (Exception e2) {
            i5 = i6;
            Log.e("StnCallBack", exception2String(e2));
            new StringBuilder().append(e2.getClass().getSimpleName()).append(":").append(e2.getStackTrace()[0]).append(", ").append(e2.getStackTrace()[1]);
        }
        AppMethodBeat.o(197114);
        return i5;
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final void reportConnectInfo(int i2, int i3) {
        AppMethodBeat.i(132955);
        try {
            af.bki().uC(i2);
            a.sY(i2);
            AppMethodBeat.o(132955);
        } catch (Exception e2) {
            Log.e("StnCallBack", "reportConnectInfo :%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132955);
        }
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final int getLongLinkIdentifyCheckBuffer(String str, ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr) {
        AppMethodBeat.i(197115);
        iArr[0] = jGe;
        iArr[1] = jGd;
        if (a(byteArrayOutputStream, byteArrayOutputStream2) == 0 || byteArrayOutputStream.size() == 0 || byteArrayOutputStream2.size() == 0) {
            int i2 = StnLogic.ECHECK_NEXT;
            AppMethodBeat.o(197115);
            return i2;
        }
        int i3 = StnLogic.ECHECK_NOW;
        AppMethodBeat.o(197115);
        return i3;
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final boolean onLongLinkIdentifyResp(String str, byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(197116);
        if (!(bArr == null || bArr2 == null)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr2);
            } catch (IOException e2) {
            }
            onPush(str, jGd, 0, byteArrayOutputStream.toByteArray());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            af.bkl();
            v.aA(byteArray);
        }
        AppMethodBeat.o(197116);
        return true;
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final String[] requestNetCheckShortLinkHosts() {
        return new String[0];
    }

    private static int a(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2) {
        int i2 = 0;
        AppMethodBeat.i(132958);
        if (af.bkl() == null) {
            AppMethodBeat.o(132958);
        } else {
            try {
                byte[] bjM = af.bkl().bjM();
                if (bjM != null) {
                    byteArrayOutputStream.write(bjM);
                    jGf = bjM;
                }
                byte[] bArr = af.bkl().hqn;
                if (bArr != null) {
                    byteArrayOutputStream2.write(bArr);
                    jGg = bArr;
                }
                i2 = af.bkl().jEj.getUin();
                AppMethodBeat.o(132958);
            } catch (Exception e2) {
                Log.e("StnCallBack", exception2String(e2));
                if (!(jGf == null || jGg == null)) {
                    try {
                        byteArrayOutputStream.write(jGf);
                        byteArrayOutputStream2.write(jGg);
                    } catch (IOException e3) {
                    }
                }
                AppMethodBeat.o(132958);
            }
        }
        return i2;
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final void requestDoSync() {
        AppMethodBeat.i(132959);
        if (af.bkn() == null) {
            AppMethodBeat.o(132959);
            return;
        }
        try {
            af.bkj().post(new Runnable() {
                /* class com.tencent.mm.network.al.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(132948);
                    af.bkn().j(24, o.iC(7));
                    AppMethodBeat.o(132948);
                }
            });
            AppMethodBeat.o(132959);
        } catch (Exception e2) {
            Log.e("StnCallBack", exception2String(e2));
            new StringBuilder().append(e2.getClass().getSimpleName()).append(":").append(e2.getStackTrace()[0]).append(", ").append(e2.getStackTrace()[1]);
            AppMethodBeat.o(132959);
        }
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final boolean isLogoned() {
        boolean z = false;
        AppMethodBeat.i(132960);
        if (af.bkl() == null) {
            AppMethodBeat.o(132960);
        } else {
            try {
                z = af.bkl().jEj.aZb();
                AppMethodBeat.o(132960);
            } catch (Exception e2) {
                Log.e("StnCallBack", exception2String(e2));
                new StringBuilder().append(e2.getClass().getSimpleName()).append(":").append(e2.getStackTrace()[0]).append(", ").append(e2.getStackTrace()[1]);
                AppMethodBeat.o(132960);
            }
        }
        return z;
    }

    @Override // com.tencent.mars.stn.StnLogic.ICallBack
    public final void networkAnalysisCallBack(int i2, int i3, boolean z, String str) {
        AppMethodBeat.i(132961);
        Log.i("StnCallBack", "networkAnalysisCallBack: status:%d, stage:%d, isDetectEnd:%b, kvInfo:%s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str);
        try {
            af.bkl().jEr.networkAnalysisCallBack(i2, i3, z, str);
            AppMethodBeat.o(132961);
        } catch (Exception e2) {
            Log.printErrStackTrace("StnCallBack", e2, "", new Object[0]);
            new StringBuilder().append(e2.getClass().getSimpleName()).append(":").append(e2.getStackTrace()[0]).append(", ").append(e2.getStackTrace()[1]);
            AppMethodBeat.o(132961);
        }
    }
}
