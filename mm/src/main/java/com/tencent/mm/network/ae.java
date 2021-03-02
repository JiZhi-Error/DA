package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mars.Mars;
import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.af;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class ae {
    final a[] jFA = new a[100];

    /* access modifiers changed from: package-private */
    public static class a {
        t jFE;
        n jFF;
        e jFG;
        long startTime;
        int taskId;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public ae() {
        AppMethodBeat.i(132894);
        AppMethodBeat.o(132894);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(132895);
        reset();
        super.finalize();
        AppMethodBeat.o(132895);
    }

    /* access modifiers changed from: package-private */
    public final boolean bjY() {
        AppMethodBeat.i(132896);
        synchronized (this.jFA) {
            for (int i2 = 0; i2 < 100; i2++) {
                try {
                    if (this.jFA[i2] != null && this.jFA[i2].jFE.aZo().isAxAuth()) {
                        try {
                            AppMethodBeat.o(132896);
                            return true;
                        } catch (Throwable th) {
                            AppMethodBeat.o(132896);
                            throw th;
                        }
                    }
                } catch (RemoteException e2) {
                    this.jFA[i2] = null;
                    Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", Util.stackTraceToString(e2), Integer.valueOf(i2));
                }
            }
            AppMethodBeat.o(132896);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean bjZ() {
        AppMethodBeat.i(132897);
        synchronized (this.jFA) {
            for (int i2 = 0; i2 < 100; i2++) {
                try {
                    if (this.jFA[i2] != null && (252 == this.jFA[i2].jFE.getType() || 701 == this.jFA[i2].jFE.getType() || 702 == this.jFA[i2].jFE.getType() || 763 == this.jFA[i2].jFE.getType() || 3941 == this.jFA[i2].jFE.getType())) {
                        Log.w("MicroMsg.MMNativeNetTaskAdapter", "hasAuthCmd Auth inQueue: netid=" + i2 + " type=" + this.jFA[i2].jFE.getType());
                        try {
                            AppMethodBeat.o(132897);
                            return true;
                        } catch (Throwable th) {
                            AppMethodBeat.o(132897);
                            throw th;
                        }
                    }
                } catch (RemoteException e2) {
                    this.jFA[i2] = null;
                    Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", Util.stackTraceToString(e2), Integer.valueOf(i2));
                }
            }
            AppMethodBeat.o(132897);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean bka() {
        AppMethodBeat.i(132898);
        synchronized (this.jFA) {
            for (int i2 = 0; i2 < 100; i2++) {
                try {
                    if (this.jFA[i2] != null && 1000 == this.jFA[i2].jFE.getType()) {
                        Log.w("MicroMsg.MMNativeNetTaskAdapter", "hasWithoutLoginCmd inQueue: netid=" + i2 + " type=" + this.jFA[i2].jFE.getType());
                        try {
                            AppMethodBeat.o(132898);
                            return true;
                        } catch (Throwable th) {
                            AppMethodBeat.o(132898);
                            throw th;
                        }
                    }
                } catch (RemoteException e2) {
                    this.jFA[i2] = null;
                    Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", Util.stackTraceToString(e2), Integer.valueOf(i2));
                }
            }
            AppMethodBeat.o(132898);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final t gc(boolean z) {
        AppMethodBeat.i(132899);
        synchronized (this.jFA) {
            t tVar = null;
            for (int i2 = 0; i2 < 100; i2++) {
                try {
                    if (this.jFA[i2] != null) {
                        if (z) {
                            try {
                                if (this.jFA[i2].jFE instanceof t.a) {
                                    continue;
                                }
                            } catch (RemoteException e2) {
                                Log.w("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", Util.stackTraceToString(e2));
                            }
                        }
                        if (z || (this.jFA[i2].jFE instanceof t.a)) {
                            if (252 == this.jFA[i2].jFE.getType() || 701 == this.jFA[i2].jFE.getType() || 763 == this.jFA[i2].jFE.getType() || 702 == this.jFA[i2].jFE.getType() || 3941 == this.jFA[i2].jFE.getType()) {
                                Log.e("MicroMsg.MMNativeNetTaskAdapter", "getAutoAuthRR Auth inQueue: netid=" + i2 + " type=" + this.jFA[i2].jFE.getType());
                                return null;
                            } else if (tVar == null) {
                                tVar = this.jFA[i2].jFE;
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.o(132899);
                }
            }
            AppMethodBeat.o(132899);
            return tVar;
        }
    }

    public final int bkb() {
        AppMethodBeat.i(132900);
        int i2 = 0;
        for (int i3 = 0; i3 < 100; i3++) {
            try {
                if (this.jFA[i3] != null) {
                    this.jFA[i3].jFE.getType();
                }
            } catch (RemoteException e2) {
                Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s, remove index:%d", Util.stackTraceToString(e2), Integer.valueOf(i3));
                i2++;
                this.jFA[i3] = null;
            }
        }
        AppMethodBeat.o(132900);
        return i2;
    }

    static boolean uy(int i2) {
        if (i2 == 10 || i2 == 268369922) {
            return true;
        }
        return false;
    }

    public final int a(t tVar, n nVar, e eVar, int i2) {
        int i3;
        int timeOut;
        AppMethodBeat.i(132901);
        if (tVar == null) {
            Log.e("MicroMsg.MMNativeNetTaskAdapter", "startTask  rr is null");
            AppMethodBeat.o(132901);
            return -1;
        }
        tVar.hashCode();
        StnLogic.Task task = new StnLogic.Task();
        synchronized (this.jFA) {
            int i4 = 0;
            while (true) {
                if (i4 >= 100) {
                    i3 = -1;
                    break;
                }
                try {
                    if (this.jFA[i4] == null) {
                        this.jFA[i4] = new a((byte) 0);
                        this.jFA[i4].jFE = tVar;
                        this.jFA[i4].jFF = nVar;
                        this.jFA[i4].jFG = eVar;
                        this.jFA[i4].startTime = Util.nowMilliSecond();
                        this.jFA[i4].taskId = task.taskID;
                        task.cmdID = tVar.aZo().getCmdId();
                        task.cgi = tVar.getUri();
                        if (tVar.aZr()) {
                            Log.i("MicroMsg.MMNativeNetTaskAdapter", "keep-alive for cgi=" + task.cgi);
                            task.headers.put("Connection", "Keep-Alive");
                        }
                        int type = tVar.getType();
                        task.needAuthed = (tVar.getOptions() & 1) != 1;
                        if (type == 126 || type == 252 || type == 701 || type == 702 || type == 763 || type == 3941) {
                            task.needAuthed = false;
                            if (type == 701 || type == 252) {
                                task.retryCount = 1;
                            }
                        }
                        if (type == 2962) {
                            task.retryCount = 2;
                        }
                        task.limitFlow = true;
                        if (type == 149 || type == 193 || type == 110 || type == 220 || type == 323 || type == 324 || type == 326 || type == 327 || type == 703 || type == 2580 || type == 3767) {
                            task.limitFlow = false;
                        }
                        if (type == 703 || type == 3767) {
                            task.limitFrequency = false;
                        }
                        task.channelStrategy = 0;
                        if (type == 233 || type == 835 || type == 238) {
                            task.channelStrategy = 1;
                        }
                        task.sendOnly = false;
                        if (uy(type)) {
                            task.sendOnly = true;
                        }
                        if (tVar.aZo().getShortSupport() && tVar.getUri() != null && tVar.getUri().length() > 0) {
                            task.channelSelect |= 1;
                        }
                        if (task.cmdID != 0) {
                            task.channelSelect |= 2;
                        }
                        task.reportArg = String.valueOf(type);
                        if (type == 522) {
                            task.totalTimeout = 300000;
                            task.priority = 0;
                        }
                        if (type == 710) {
                            task.totalTimeout = 15000;
                            task.serverProcessCost = 0;
                        }
                        if (type == 2632 && (timeOut = tVar.getTimeOut()) != 0) {
                            task.totalTimeout = timeOut;
                        }
                        if (tVar.getIsLongPolling()) {
                            Log.i("MicroMsg.MMNativeNetTaskAdapter", "this is long-polling cgi");
                            task.longPolling = true;
                            task.longPollingTimeout = tVar.getLongPollingTimeout();
                            int timeOut2 = tVar.getTimeOut();
                            if (timeOut2 != 0) {
                                task.totalTimeout = timeOut2;
                            }
                            task.retryCount = 0;
                        }
                        Log.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi startTask inQueue netid:%d hash[%d,%d] net:%d cgi:%s needAuthed:%b", Integer.valueOf(i4), Integer.valueOf(task.taskID), Integer.valueOf(tVar.getMMReqRespHash()), Integer.valueOf(task.channelSelect), task.cgi, Boolean.valueOf(task.needAuthed));
                        i3 = i4;
                    } else {
                        i4++;
                    }
                } catch (RemoteException e2) {
                    Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", Util.stackTraceToString(e2));
                }
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(132901);
                throw th;
            }
        }
        if (-1 != i3) {
            if (i2 == 1) {
                task.retryCount = 0;
            }
            StnLogic.startTask(task);
        } else {
            Log.e("MicroMsg.MMNativeNetTaskAdapter", "startTask err");
        }
        Log.d("MicroMsg.MMNativeNetTaskAdapter", "startTask retsult=".concat(String.valueOf(i3)));
        AppMethodBeat.o(132901);
        return i3;
    }

    public final void reset() {
        AppMethodBeat.i(132902);
        Log.i("MicroMsg.MMNativeNetTaskAdapter", "reset");
        StnLogic.resetAndInitEncoderVersion(Mars.currentCertVer());
        synchronized (this.jFA) {
            for (int i2 = 0; i2 < 100; i2++) {
                try {
                    if (this.jFA[i2] != null) {
                        try {
                            Log.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi reset outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i2), Integer.valueOf(this.jFA[i2].jFE.getType()), Integer.valueOf(this.jFA[i2].jFE.getMMReqRespHash()));
                            this.jFA[i2] = null;
                        } catch (RemoteException e2) {
                            Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", Util.stackTraceToString(e2));
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(132902);
                    throw th;
                }
            }
        }
        AppMethodBeat.o(132902);
    }

    public final void m(int i2, int i3, String str) {
        AppMethodBeat.i(132903);
        Log.i("MicroMsg.MMNativeNetTaskAdapter", "clearTaskAndCallback errType=" + i2 + ", errCode=" + i3 + ", errMsg=" + str);
        StnLogic.clearTask();
        StnLogic.resetAndInitEncoderVersion(Mars.currentCertVer());
        a[] aVarArr = new a[100];
        synchronized (this.jFA) {
            for (int i4 = 0; i4 < 100; i4++) {
                try {
                    aVarArr[i4] = this.jFA[i4];
                    this.jFA[i4] = null;
                } catch (Throwable th) {
                    AppMethodBeat.o(132903);
                    throw th;
                }
            }
        }
        for (int i5 = 0; i5 < 100; i5++) {
            if (aVarArr[i5] != null) {
                try {
                    Log.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi clearTaskAndCallback outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i5), Integer.valueOf(aVarArr[i5].jFE.getType()), Integer.valueOf(aVarArr[i5].jFE.getMMReqRespHash()));
                    aVarArr[i5].jFF.a(i5, i2, i3, str, aVarArr[i5].jFE, null);
                } catch (Exception e2) {
                    Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", Util.stackTraceToString(e2));
                }
            }
        }
        AppMethodBeat.o(132903);
    }

    /* access modifiers changed from: package-private */
    public final int uz(int i2) {
        int i3 = 0;
        AppMethodBeat.i(132904);
        synchronized (this.jFA) {
            try {
                int uA = uA(i2);
                if (-1 == uA) {
                    Log.e("MicroMsg.MMNativeNetTaskAdapter", "-1 == index");
                } else {
                    try {
                        i3 = this.jFA[uA].jFE.aZp().getRetCode();
                        AppMethodBeat.o(132904);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", Util.stackTraceToString(e2));
                        AppMethodBeat.o(132904);
                    }
                }
            } finally {
                AppMethodBeat.o(132904);
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i3, String str) {
        boolean z;
        byte[] qe;
        byte[] aZa;
        int i4;
        boolean z2;
        AppMethodBeat.i(132905);
        synchronized (this.jFA) {
            try {
                int uA = uA(i2);
                if (-1 == uA) {
                    z = false;
                } else {
                    try {
                        boolean MG = this.jFA[uA].jFG.MG(str);
                        Log.i("MicroMsg.MMNativeNetTaskAdapter", "link: %d req2Buf somr isfg:%b  cookie: %s, type: %d host[%s]", Integer.valueOf(i3), Boolean.valueOf(this.jFA[uA].jFG.isForeground()), Util.encodeHexString(this.jFA[uA].jFG.aZa()), Integer.valueOf(this.jFA[uA].jFE.getType()), str);
                        int i5 = 1;
                        if (!this.jFA[uA].jFE.isSingleSession()) {
                            i5 = 2;
                            this.jFA[uA].jFE.aZo().setPassKey(this.jFA[uA].jFG.qe(3));
                            Log.i("MicroMsg.MMNativeNetTaskAdapter", "summerauths isSingleSession false type:[%s]", Integer.valueOf(this.jFA[uA].jFE.getType()));
                        }
                        if (MG) {
                            Log.i("MicroMsg.MMNativeNetTaskAdapter", "set axauth sessionkey ".concat(String.valueOf(str)));
                            this.jFA[uA].jFE.aZo().setPassKey(this.jFA[uA].jFG.MF(str));
                            byte[] ME = this.jFA[uA].jFG.ME(str);
                            byte[] MD = this.jFA[uA].jFG.MD(str);
                            this.jFA[uA].jFE.aZo().setUseAxsession(true);
                            if (ME != null) {
                                Log.i("MicroMsg.MMNativeNetTaskAdapter", "axauth sessionkey length[%d]", Integer.valueOf(ME.length));
                            } else {
                                Log.w("MicroMsg.MMNativeNetTaskAdapter", "axauth axsessionkey is null");
                            }
                            if (MD != null) {
                                Log.i("MicroMsg.MMNativeNetTaskAdapter", "axauth cookie length[%d]", Integer.valueOf(MD.length));
                            } else {
                                Log.w("MicroMsg.MMNativeNetTaskAdapter", "axauth cookie is null");
                            }
                            e.INSTANCE.idkeyStat(148, 123, 1, false);
                            qe = ME;
                            aZa = MD;
                            i4 = 2;
                        } else {
                            qe = this.jFA[uA].jFG.qe(i5);
                            aZa = this.jFA[uA].jFG.aZa();
                            i4 = i5;
                        }
                        this.jFA[uA].jFE.aZo().setSessionKey(qe);
                        if (i4 == 1) {
                            int type = this.jFA[uA].jFE.getType();
                            if (type == 1000 || type == 502 || type == 930 || type == 503 || type == 654 || type == 755 || type == 931 || type == 733 || type == 784 || type == 722 || type == 627) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                this.jFA[uA].jFE.aZo().setPassKey(null);
                            }
                        }
                        if (this.jFA[uA].jFE.getNewExtFlags() != 0) {
                            this.jFA[uA].jFE.aZo().sL(this.jFA[uA].jFE.getNewExtFlags());
                            this.jFA[uA].jFE.aZo().an(this.jFA[uA].jFE.getTransHeader());
                        }
                        this.jFA[uA].jFE.aZo().setUin(this.jFA[uA].jFG.getUin());
                        z = this.jFA[uA].jFE.aZo().a(this.jFA[uA].jFE.getType(), qe, i4 == 2 ? 13 : 0, aZa, this.jFA[uA].jFG.aZc(), 0, this.jFA[uA].jFG.isForeground());
                        if (z) {
                            byteArrayOutputStream.write(this.jFA[uA].jFE.aZo().aZm());
                        } else {
                            iArr[0] = 0;
                            e.INSTANCE.idkeyStat(162, (long) iArr[0], 1, false);
                            Log.e("MicroMsg.MMNativeNetTaskAdapter", "request to buffer using jni failed");
                        }
                    } catch (RemoteException e2) {
                        iArr[0] = 1;
                        e.INSTANCE.idkeyStat(162, (long) iArr[0], 1, false);
                        Log.e("MicroMsg.MMNativeNetTaskAdapter", "RemoteException:%s", Util.stackTraceToString(e2));
                        z = false;
                    } catch (IOException e3) {
                        iArr[0] = 2;
                        e.INSTANCE.idkeyStat(162, (long) iArr[0], 1, false);
                        Log.e("MicroMsg.MMNativeNetTaskAdapter", "IOException:%s", Util.stackTraceToString(e3));
                        z = false;
                    } catch (Exception e4) {
                        iArr[0] = 3;
                        e.INSTANCE.idkeyStat(162, (long) iArr[0], 1, false);
                        Log.e("MicroMsg.MMNativeNetTaskAdapter", "Exception:%s", Util.stackTraceToString(e4));
                        z = false;
                    }
                    try {
                        if (af.bkp() != null) {
                            af.bkp().F(this.jFA[uA].jFE.getType(), byteArrayOutputStream != null ? (long) byteArrayOutputStream.size() : 0);
                        }
                    } catch (Exception e5) {
                        Log.e("MicroMsg.MMNativeNetTaskAdapter", "iDataPackageReporter Exception:%s", Util.stackTraceToString(e5));
                    }
                    Log.d("MicroMsg.MMNativeNetTaskAdapter", "req2Buf bOk: %b", Boolean.valueOf(z));
                    AppMethodBeat.o(132905);
                }
            } finally {
                AppMethodBeat.o(132905);
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final int a(int i2, byte[] bArr, int[] iArr, int[] iArr2) {
        int i3;
        RemoteException e2;
        long j2;
        int i4;
        long j3;
        AppMethodBeat.i(132906);
        synchronized (this.jFA) {
            try {
                int uA = uA(i2);
                if (-1 == uA) {
                    i3 = -1;
                } else {
                    int i5 = StnLogic.RESP_FAIL_HANDLE_DEFAULT;
                    try {
                        byte[] passKey = this.jFA[uA].jFE.aZo().getPassKey();
                        long eCDHEngine = this.jFA[uA].jFE.aZo().getECDHEngine();
                        i aZp = this.jFA[uA].jFE.aZp();
                        boolean a2 = aZp.a(this.jFA[uA].jFE.getType(), bArr, passKey, eCDHEngine);
                        if (this.jFA[uA].jFE.aZo().useAxSession()) {
                            Log.d("MicroMsg.MMNativeNetTaskAdapter", "axauth cgi is axcgi");
                        } else {
                            Log.d("MicroMsg.MMNativeNetTaskAdapter", "axauth cgi is not axcgi");
                        }
                        if (a2) {
                            int headExtFlags = aZp.getHeadExtFlags();
                            iArr2[0] = 0;
                            aZp.getRetCode();
                            if ((headExtFlags & 2) == 0) {
                                iArr2[0] = iArr2[0] | 2;
                                e.INSTANCE.idkeyStat(656, 0, 1, false);
                            }
                            if ((headExtFlags & 4) == 0) {
                                iArr2[0] = iArr2[0] | 4;
                                e.INSTANCE.idkeyStat(656, 1, 1, false);
                            }
                            if (aZp.aZa() != null && -13 == aZp.getRetCode()) {
                                if (this.jFA[uA].jFE.aZo().useAxSession()) {
                                    Log.w("MicroMsg.MMNativeNetTaskAdapter", "axsession cgi sessionkey timeout");
                                    e.INSTANCE.idkeyStat(162, 9, 1, false);
                                }
                                if (af.bkl() != null) {
                                    af.bkl().bjL();
                                }
                            }
                            if (-13 == aZp.getRetCode()) {
                                i4 = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                                try {
                                    iArr[0] = aZp.getRetCode();
                                } catch (RemoteException e3) {
                                    e2 = e3;
                                    i5 = i4;
                                    e.INSTANCE.idkeyStat(162, 5, 1, false);
                                    Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", Util.stackTraceToString(e2));
                                    i3 = i5;
                                    AppMethodBeat.o(132906);
                                    return i3;
                                } catch (Exception e4) {
                                    e = e4;
                                    i5 = i4;
                                    e.INSTANCE.idkeyStat(162, 7, 1, false);
                                    Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", Util.stackTraceToString(e));
                                    i3 = i5;
                                    AppMethodBeat.o(132906);
                                    return i3;
                                }
                            } else if (-3002 == aZp.getRetCode() || -3003 == aZp.getRetCode() || -3006 == aZp.getRetCode()) {
                                i4 = StnLogic.RESP_FAIL_HANDLE_TASK_END;
                                iArr[0] = aZp.getRetCode();
                            } else if (-3001 == aZp.getRetCode()) {
                                i4 = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                                iArr[0] = aZp.getRetCode();
                            } else {
                                i4 = StnLogic.RESP_FAIL_HANDLE_NORMAL;
                            }
                            String uri = this.jFA[uA].jFE.getUri();
                            if (!v.jEd.isEmpty() && uri.contains(v.jEd)) {
                                Log.i("MicroMsg.MMNativeNetTaskAdapter", "axauth cgi %s session time", uri);
                                v.jEd = "";
                                i4 = StnLogic.RESP_FAIL_HANDLE_SESSION_TIMEOUT;
                                iArr[0] = -13;
                                if (af.bkl() != null) {
                                    af.bkl().bjL();
                                }
                            }
                            if (af.bkp() != null) {
                                af.a bkp = af.bkp();
                                String nullAs = Util.nullAs(uri, BuildConfig.COMMAND);
                                if (bArr != null) {
                                    j3 = (long) bArr.length;
                                } else {
                                    j3 = 0;
                                }
                                bkp.K(nullAs, j3);
                            }
                            i3 = i4;
                        } else {
                            e.INSTANCE.idkeyStat(162, 4, 1, false);
                            Log.e("MicroMsg.MMNativeNetTaskAdapter", "buf to resp failed, change server and try again");
                            if (af.bkp() != null) {
                                af.a bkp2 = af.bkp();
                                if (bArr != null) {
                                    j2 = (long) bArr.length;
                                } else {
                                    j2 = 0;
                                }
                                bkp2.K("resp_fail", j2);
                            }
                            i3 = i5;
                        }
                    } catch (RemoteException e5) {
                        e2 = e5;
                        e.INSTANCE.idkeyStat(162, 5, 1, false);
                        Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", Util.stackTraceToString(e2));
                        i3 = i5;
                        AppMethodBeat.o(132906);
                        return i3;
                    } catch (Exception e6) {
                        e = e6;
                        e.INSTANCE.idkeyStat(162, 7, 1, false);
                        Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", Util.stackTraceToString(e));
                        i3 = i5;
                        AppMethodBeat.o(132906);
                        return i3;
                    }
                    AppMethodBeat.o(132906);
                }
            } finally {
                AppMethodBeat.o(132906);
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final int uA(int i2) {
        int i3 = 0;
        while (i3 < 100 && (this.jFA[i3] == null || i2 != this.jFA[i3].taskId)) {
            i3++;
        }
        if (100 <= i3) {
            return -1;
        }
        return i3;
    }
}
