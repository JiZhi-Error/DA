package com.tencent.mm.ak;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.c;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class t implements i, o {
    private static int iMG = 1;
    private static t iMv = null;
    public boolean foreground = false;
    private final MMHandler handler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.ak.t.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(132317);
            t.this.a((q) message.obj, 0);
            AppMethodBeat.o(132317);
        }
    };
    private final Map<Integer, Set<i>> iMA = new HashMap();
    public Boolean iMB = null;
    private final a iMC;
    private long iMD = 21600000;
    private boolean iME = false;
    private MTimerHandler iMF = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ak.t.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            boolean z = false;
            AppMethodBeat.i(132316);
            if (t.this.iMC == null) {
                AppMethodBeat.o(132316);
                return false;
            }
            Log.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", Integer.valueOf(t.this.iMy.size()), Integer.valueOf(t.this.iMz.size()), Boolean.valueOf(t.this.foreground));
            a aVar = t.this.iMC;
            t tVar = t.this;
            if (t.this.iME && t.this.iMy.isEmpty() && t.this.iMz.isEmpty()) {
                z = true;
            }
            aVar.a(tVar, z);
            AppMethodBeat.o(132316);
            return true;
        }
    }, true);
    public g iMw;
    public MMHandlerThread iMx = null;
    private Vector<q> iMy = new Vector<>();
    private Vector<q> iMz = new Vector<>();
    private final Object lock = new Object();

    public interface a {
        void a(t tVar);

        void a(t tVar, boolean z);
    }

    static /* synthetic */ void k(t tVar) {
        AppMethodBeat.i(132358);
        tVar.aYX();
        AppMethodBeat.o(132358);
    }

    @Override // com.tencent.mm.app.o
    public final void onAppForeground(String str) {
        AppMethodBeat.i(132327);
        Log.i("MicroMsg.NetSceneQueue", "onAppForeground");
        setForeground(true);
        fx(false);
        AppMethodBeat.o(132327);
    }

    @Override // com.tencent.mm.app.o
    public final void onAppBackground(String str) {
        AppMethodBeat.i(132328);
        Log.i("MicroMsg.NetSceneQueue", "onAppBackground");
        setForeground(false);
        AppMethodBeat.o(132328);
    }

    public final void fx(boolean z) {
        AppMethodBeat.i(132329);
        this.iME = z;
        if (!this.iME) {
            this.iMF.stopTimer();
            AppMethodBeat.o(132329);
            return;
        }
        Log.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
        this.iMF.startTimer(this.iMD);
        AppMethodBeat.o(132329);
    }

    public final void a(int i2, String str, int i3, boolean z) {
        AppMethodBeat.i(132330);
        if (this.iMw == null) {
            Log.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
            AppMethodBeat.o(132330);
            return;
        }
        this.iMw.a(i2, str, i3, z);
        AppMethodBeat.o(132330);
    }

    private void setForeground(boolean z) {
        AppMethodBeat.i(132331);
        this.foreground = z;
        this.iMB = Boolean.valueOf(z);
        CrashReportFactory.setForeground(z);
        WXHardCoderJNI.foreground = z;
        if (this.iMw == null) {
            Log.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
            AppMethodBeat.o(132331);
            return;
        }
        this.iMw.fy(z);
        AppMethodBeat.o(132331);
    }

    public final int aYS() {
        AppMethodBeat.i(132332);
        try {
            if (this.iMw == null || this.iMw.aZi() == null) {
                Log.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
                if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                    AppMethodBeat.o(132332);
                    return 6;
                }
                AppMethodBeat.o(132332);
                return 0;
            }
            int bjC = this.iMw.aZi().bjC();
            AppMethodBeat.o(132332);
            return bjC;
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneQueue", "exception:%s", Util.stackTraceToString(e2));
        }
    }

    public final boolean aYT() {
        AppMethodBeat.i(132333);
        if (this.iMw != null) {
            boolean aYT = this.iMw.aYT();
            AppMethodBeat.o(132333);
            return aYT;
        }
        AppMethodBeat.o(132333);
        return true;
    }

    public final String getNetworkServerIp() {
        AppMethodBeat.i(132334);
        if (this.iMw != null) {
            String networkServerIp = this.iMw.getNetworkServerIp();
            AppMethodBeat.o(132334);
            return networkServerIp;
        }
        AppMethodBeat.o(132334);
        return "unknown";
    }

    private t(a aVar) {
        AppMethodBeat.i(132335);
        this.iMC = aVar;
        AppForegroundDelegate.INSTANCE.a(this);
        AppMethodBeat.o(132335);
    }

    public final void c(g gVar) {
        AppMethodBeat.i(132336);
        this.iMw = gVar;
        gVar.fy(this.foreground);
        aYX();
        AppMethodBeat.o(132336);
    }

    public static t a(a aVar) {
        AppMethodBeat.i(132337);
        if (iMv == null) {
            iMv = new t(aVar);
        }
        t tVar = iMv;
        AppMethodBeat.o(132337);
        return tVar;
    }

    public final void a(int i2, i iVar) {
        AppMethodBeat.i(132338);
        synchronized (this.iMA) {
            try {
                if (!this.iMA.containsKey(Integer.valueOf(i2))) {
                    this.iMA.put(Integer.valueOf(i2), new HashSet());
                }
                if (!this.iMA.get(Integer.valueOf(i2)).contains(iVar)) {
                    Set<i> set = this.iMA.get(Integer.valueOf(i2));
                    synchronized (set) {
                        try {
                            if (set.add(iVar)) {
                                ListenerInstanceMonitor.markInstanceRegistered(iVar);
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(132338);
                            throw th;
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(132338);
            }
        }
    }

    public final void b(int i2, i iVar) {
        AppMethodBeat.i(132339);
        synchronized (this.iMA) {
            try {
                Set<i> set = this.iMA.get(Integer.valueOf(i2));
                if (set != null) {
                    synchronized (set) {
                        try {
                            if (set.remove(iVar)) {
                                ListenerInstanceMonitor.markInstanceUnregistered(iVar);
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(132339);
                            throw th;
                        }
                    }
                }
            } catch (Exception e2) {
            }
            try {
            } catch (Throwable th2) {
                AppMethodBeat.o(132339);
                throw th2;
            }
        }
        AppMethodBeat.o(132339);
    }

    public final void reset() {
        AppMethodBeat.i(132340);
        Log.i("MicroMsg.NetSceneQueue", "reset");
        if (this.iMw != null) {
            this.iMw.reset();
        }
        aYV();
        aYU();
        AppMethodBeat.o(132340);
    }

    private void aYU() {
        AppMethodBeat.i(132341);
        Vector<q> vector = this.iMz;
        this.iMz = new Vector<>();
        for (q qVar : vector) {
            Log.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + qVar.getType());
            qVar.cancel();
            b(3, -1, "doScene failed clearWaitingQueue", qVar);
        }
        vector.clear();
        AppMethodBeat.o(132341);
    }

    public final void aYV() {
        AppMethodBeat.i(132342);
        Vector<q> vector = this.iMy;
        this.iMy = new Vector<>();
        for (q qVar : vector) {
            Log.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + qVar.getType());
            qVar.cancel();
            b(3, -1, "doScene failed clearRunningQueue", qVar);
        }
        vector.clear();
        AppMethodBeat.o(132342);
    }

    public final void aYW() {
        AppMethodBeat.i(132343);
        Log.i("MicroMsg.NetSceneQueue", "resetDispatcher");
        if (this.iMw != null) {
            this.iMw.reset();
            this.iMw = null;
        }
        AppMethodBeat.o(132343);
    }

    public final g azD() {
        return this.iMw;
    }

    public final void cancel(final int i2) {
        AppMethodBeat.i(132344);
        Log.printInfoStack("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(i2));
        this.iMx.postToWorker(new Runnable() {
            /* class com.tencent.mm.ak.t.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(132318);
                t.a(t.this, i2);
                AppMethodBeat.o(132318);
            }

            public final String toString() {
                AppMethodBeat.i(132319);
                String str = super.toString() + "|cancelImp_" + i2;
                AppMethodBeat.o(132319);
                return str;
            }
        });
        AppMethodBeat.o(132344);
    }

    public final void sK(final int i2) {
        AppMethodBeat.i(132345);
        Log.printInfoStack("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(i2));
        this.iMx.postToWorker(new Runnable() {
            /* class com.tencent.mm.ak.t.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(132320);
                t.b(t.this, i2);
                AppMethodBeat.o(132320);
            }

            public final String toString() {
                AppMethodBeat.i(132321);
                String str = super.toString() + "|cancelImp_" + i2;
                AppMethodBeat.o(132321);
                return str;
            }
        });
        AppMethodBeat.o(132345);
    }

    public final void a(q qVar) {
        AppMethodBeat.i(132346);
        if (qVar == null) {
            AppMethodBeat.o(132346);
            return;
        }
        Log.printInfoStack("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(qVar.hashCode()));
        qVar.cancel();
        synchronized (this.lock) {
            try {
                this.iMz.remove(qVar);
                this.iMy.remove(qVar);
            } finally {
                AppMethodBeat.o(132346);
            }
        }
    }

    public final boolean b(q qVar) {
        AppMethodBeat.i(259566);
        boolean a2 = a(qVar, 0);
        AppMethodBeat.o(259566);
        return a2;
    }

    public final boolean a(q qVar, int i2) {
        boolean z;
        AppMethodBeat.i(132348);
        Assert.assertTrue(qVar != null || i2 >= 0);
        if (this.iMx != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue("worker thread has not been set", z);
        if (!c(qVar)) {
            AppMethodBeat.o(132348);
            return false;
        }
        b(qVar, i2);
        AppMethodBeat.o(132348);
        return true;
    }

    private void b(final q qVar, int i2) {
        int i3 = 0;
        AppMethodBeat.i(132349);
        boolean aYY = aYY();
        int size = this.iMy.size();
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(qVar.getType());
        objArr[1] = Integer.valueOf(qVar.hashCode());
        objArr[2] = Integer.valueOf(qVar.getMMReqRespHash());
        objArr[3] = Integer.valueOf(size);
        objArr[4] = Integer.valueOf(this.iMz.size());
        objArr[5] = Integer.valueOf(i2);
        objArr[6] = Boolean.valueOf(aYY);
        if (this.iMw != null) {
            i3 = this.iMw.hashCode();
        }
        objArr[7] = Integer.valueOf(i3);
        Log.i("MicroMsg.NetSceneQueue", "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d", objArr);
        if (i2 == 0 && aYY && this.iMw != null) {
            synchronized (this.lock) {
                try {
                    this.iMy.add(qVar);
                    if (size == this.iMy.size()) {
                        Log.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", Integer.valueOf(qVar.getType()), Integer.valueOf(qVar.hashCode()), Integer.valueOf(size), Integer.valueOf(this.iMy.size()), Integer.valueOf(this.iMz.size()));
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(132349);
                    throw th;
                }
            }
            this.iMx.postToWorker(new Runnable() {
                /* class com.tencent.mm.ak.t.AnonymousClass5 */

                public final void run() {
                    int i2;
                    int hashCode;
                    int i3 = 0;
                    AppMethodBeat.i(132323);
                    qVar.setOnSceneEnd(t.this);
                    if (qVar.isCanceled() || t.this.iMw == null) {
                        i2 = 0;
                    } else {
                        i2 = qVar.doScene(t.this.iMw, t.this);
                        if (i2 >= 0) {
                            Object[] objArr = new Object[7];
                            objArr[0] = Integer.valueOf(qVar.getType());
                            objArr[1] = Integer.valueOf(qVar.hashCode());
                            objArr[2] = Integer.valueOf(qVar.getMMReqRespHash());
                            objArr[3] = Integer.valueOf(t.this.iMy.size());
                            objArr[4] = Integer.valueOf(t.this.iMz.size());
                            objArr[5] = Integer.valueOf(i2);
                            if (t.this.iMw == null) {
                                hashCode = 0;
                            } else {
                                hashCode = t.this.iMw.hashCode();
                            }
                            objArr[6] = Integer.valueOf(hashCode);
                            Log.i("MicroMsg.NetSceneQueue", "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d", objArr);
                            qVar.setHasCallbackToQueue(false);
                            AppMethodBeat.o(132323);
                        }
                    }
                    Object[] objArr2 = new Object[8];
                    objArr2[0] = Integer.valueOf(qVar.getType());
                    objArr2[1] = Integer.valueOf(qVar.hashCode());
                    objArr2[2] = Integer.valueOf(qVar.getMMReqRespHash());
                    objArr2[3] = Boolean.valueOf(qVar.isCanceled());
                    objArr2[4] = Integer.valueOf(t.this.iMy.size());
                    objArr2[5] = Integer.valueOf(t.this.iMz.size());
                    objArr2[6] = Integer.valueOf(i2);
                    if (t.this.iMw != null) {
                        i3 = t.this.iMw.hashCode();
                    }
                    objArr2[7] = Integer.valueOf(i3);
                    Log.w("MicroMsg.NetSceneQueue", "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d", objArr2);
                    qVar.setOnSceneEnd(null);
                    synchronized (t.this.lock) {
                        try {
                            t.this.iMy.remove(qVar);
                        } catch (Throwable th) {
                            AppMethodBeat.o(132323);
                            throw th;
                        }
                    }
                    if (!qVar.isCanceled()) {
                        t.this.handler.post(new Runnable() {
                            /* class com.tencent.mm.ak.t.AnonymousClass5.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(132322);
                                t.this.onSceneEnd(3, -1, "doScene failed", qVar);
                                AppMethodBeat.o(132322);
                            }
                        });
                        AppMethodBeat.o(132323);
                        return;
                    }
                    AppMethodBeat.o(132323);
                }

                public final String toString() {
                    AppMethodBeat.i(132324);
                    String str = super.toString() + "|doSceneImp_" + qVar + "_type=" + qVar.getType();
                    AppMethodBeat.o(132324);
                    return str;
                }
            });
        } else if (i2 > 0) {
            Message obtain = Message.obtain();
            obtain.obj = qVar;
            this.handler.sendMessageDelayed(obtain, (long) i2);
            Log.i("MicroMsg.NetSceneQueue", "timed: type=" + qVar.getType() + " id=" + qVar.hashCode() + " cur_after_sec=" + i2);
        } else {
            Log.i("MicroMsg.NetSceneQueue", "waited: type=" + qVar.getType() + " id=" + qVar.hashCode() + " cur_waiting_cnt=" + this.iMz.size());
            synchronized (this.lock) {
                try {
                    this.iMz.add(qVar);
                } catch (Throwable th2) {
                    AppMethodBeat.o(132349);
                    throw th2;
                }
            }
            Log.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.iMz.size());
        }
        if (this.iMw == null) {
            aYZ();
            AppMethodBeat.o(132349);
            return;
        }
        iMG = 1;
        AppMethodBeat.o(132349);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4 = 0;
        AppMethodBeat.i(132350);
        qVar.setHasCallbackToQueue(true);
        synchronized (this.lock) {
            try {
                this.iMy.remove(qVar);
            } finally {
                AppMethodBeat.o(132350);
            }
        }
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(qVar.getType());
        objArr[1] = Integer.valueOf(qVar.hashCode());
        objArr[2] = Integer.valueOf(qVar.getMMReqRespHash());
        objArr[3] = Integer.valueOf(this.iMy.size());
        objArr[4] = Integer.valueOf(this.iMz.size());
        if (this.iMw != null) {
            i4 = this.iMw.hashCode();
        }
        objArr[5] = Integer.valueOf(i4);
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = Integer.valueOf(i3);
        objArr[8] = str;
        Log.i("MicroMsg.NetSceneQueue", "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]", objArr);
        if (i2 == 4 && (i3 == -100 || i3 == -2023)) {
            c cVar = new c();
            cVar.dBO.errType = i2;
            cVar.dBO.errCode = i3;
            cVar.dBO.errMsg = str;
            EventCenter.instance.publish(cVar);
        }
        aYX();
        b(i2, i3, str, qVar);
        if (this.iME && this.iMy.isEmpty() && this.iMz.isEmpty()) {
            this.iMF.startTimer(this.iMD);
        }
    }

    private void b(final int i2, final int i3, final String str, final q qVar) {
        AppMethodBeat.i(132351);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.ak.t.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(132325);
                Set set = (Set) t.this.iMA.get(Integer.valueOf(qVar.getType()));
                if (set != null && set.size() > 0) {
                    HashSet<i> hashSet = new HashSet();
                    synchronized (set) {
                        try {
                            hashSet.addAll(set);
                        } catch (Throwable th) {
                            AppMethodBeat.o(132325);
                            throw th;
                        }
                    }
                    for (i iVar : hashSet) {
                        if (iVar != null && set.contains(iVar)) {
                            iVar.onSceneEnd(i2, i3, str, qVar);
                        }
                    }
                }
                Set set2 = (Set) t.this.iMA.get(-1);
                if (set2 != null && set2.size() > 0) {
                    HashSet<i> hashSet2 = new HashSet();
                    synchronized (set2) {
                        try {
                            hashSet2.addAll(set2);
                        } finally {
                            AppMethodBeat.o(132325);
                        }
                    }
                    for (i iVar2 : hashSet2) {
                        if (iVar2 != null && set2.contains(iVar2)) {
                            iVar2.onSceneEnd(i2, i3, str, qVar);
                        }
                    }
                }
            }
        });
        AppMethodBeat.o(132351);
    }

    private void aYX() {
        q qVar;
        AppMethodBeat.i(132352);
        synchronized (this.lock) {
            try {
                if (this.iMz.size() > 0) {
                    q qVar2 = this.iMz.get(0);
                    int priority = qVar2.getPriority();
                    int i2 = 1;
                    q qVar3 = qVar2;
                    while (i2 < this.iMz.size()) {
                        if (this.iMz.get(i2).getPriority() > priority) {
                            this.iMz.get(i2);
                            if (aYY()) {
                                qVar = this.iMz.get(i2);
                                priority = qVar.getPriority();
                                i2++;
                                qVar3 = qVar;
                            }
                        }
                        qVar = qVar3;
                        i2++;
                        qVar3 = qVar;
                    }
                    this.iMz.remove(qVar3);
                    Log.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.iMz.size());
                    b(qVar3, 0);
                }
            } finally {
                AppMethodBeat.o(132352);
            }
        }
    }

    private boolean aYY() {
        AppMethodBeat.i(132353);
        if (this.iMy.size() >= 50) {
            AppMethodBeat.o(132353);
            return false;
        }
        AppMethodBeat.o(132353);
        return true;
    }

    private boolean c(q qVar) {
        AppMethodBeat.i(132354);
        int type = qVar.getType();
        if (qVar.uniqueInNetsceneQueue()) {
            synchronized (this.lock) {
                try {
                    Iterator<q> it = this.iMy.iterator();
                    while (it.hasNext()) {
                        q next = it.next();
                        if (next.getType() == type) {
                            Log.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + qVar.getType() + " id=" + qVar.hashCode() + " cur_running_cnt=" + this.iMy.size());
                            if (qVar.acceptConcurrent(next)) {
                                return true;
                            }
                            if (qVar.accept(next)) {
                                Log.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + qVar.getType() + " id=" + qVar.hashCode() + " cur_running_cnt=" + this.iMy.size() + " ---" + next.hashCode());
                                if (!this.foreground) {
                                    Log.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + qVar.getType() + "acinfo[" + next.getInfo() + "] scinfo[" + qVar.getInfo() + "]");
                                    Log.appenderFlush();
                                    Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + qVar.getType(), false);
                                }
                                a(next);
                                AppMethodBeat.o(132354);
                                return true;
                            }
                            AppMethodBeat.o(132354);
                            return false;
                        }
                    }
                    Iterator<q> it2 = this.iMz.iterator();
                    while (it2.hasNext()) {
                        q next2 = it2.next();
                        if (next2.getType() == type) {
                            Log.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + qVar.getType() + " id=" + qVar.hashCode() + " cur_waiting_cnt=" + this.iMz.size());
                            if (qVar.acceptConcurrent(next2)) {
                                AppMethodBeat.o(132354);
                                return true;
                            } else if (qVar.accept(next2)) {
                                Log.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + qVar.getType() + " id=" + qVar.hashCode() + " cur_waiting_cnt=" + this.iMz.size() + " ---" + next2.hashCode());
                                if (!this.foreground) {
                                    Log.appenderFlush();
                                    Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + qVar.getType(), false);
                                }
                                a(next2);
                                AppMethodBeat.o(132354);
                                return true;
                            } else {
                                AppMethodBeat.o(132354);
                                return false;
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.o(132354);
                }
            }
        }
        AppMethodBeat.o(132354);
        return true;
    }

    private void aYZ() {
        AppMethodBeat.i(132355);
        if (this.iMC == null) {
            Log.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", this.iMC);
            AppMethodBeat.o(132355);
            return;
        }
        this.iMC.a(this);
        new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.ak.t.AnonymousClass7 */
            private long timeout = 10;

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(132326);
                if (t.this.iMw == null) {
                    long j2 = this.timeout;
                    this.timeout = j2 - 1;
                    if (j2 > 0) {
                        AppMethodBeat.o(132326);
                        return true;
                    }
                }
                t.k(t.this);
                AppMethodBeat.o(132326);
                return false;
            }
        }, true).startTimer((long) (iMG * 100));
        if (iMG < 512) {
            iMG *= 2;
        }
        AppMethodBeat.o(132355);
    }

    static /* synthetic */ void a(t tVar, int i2) {
        AppMethodBeat.i(132356);
        synchronized (tVar.lock) {
            try {
                Iterator<q> it = tVar.iMy.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null && next.hashCode() == i2) {
                        tVar.a(next);
                        return;
                    }
                }
                Iterator<q> it2 = tVar.iMz.iterator();
                while (it2.hasNext()) {
                    q next2 = it2.next();
                    if (next2 != null && next2.hashCode() == i2) {
                        tVar.a(next2);
                        AppMethodBeat.o(132356);
                        return;
                    }
                }
                AppMethodBeat.o(132356);
            } finally {
                AppMethodBeat.o(132356);
            }
        }
    }

    static /* synthetic */ void b(t tVar, int i2) {
        AppMethodBeat.i(132357);
        synchronized (tVar.lock) {
            try {
                Iterator<q> it = tVar.iMy.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null && next.hashCode() == i2) {
                        Log.printInfoStack("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(next.hashCode()));
                        next.cancel();
                        it.remove();
                    }
                }
                Iterator<q> it2 = tVar.iMz.iterator();
                while (it2.hasNext()) {
                    q next2 = it2.next();
                    if (next2 != null && next2.hashCode() == i2) {
                        Log.printInfoStack("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(next2.hashCode()));
                        next2.cancel();
                        it2.remove();
                    }
                }
            } finally {
                AppMethodBeat.o(132357);
            }
        }
    }
}
