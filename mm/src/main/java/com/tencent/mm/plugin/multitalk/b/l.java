package com.tencent.mm.plugin.multitalk.b;

import android.os.Looper;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxmm.IConfCallBack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class l {
    private IConfCallBack qsy;
    private final SparseArray<HashSet<a>> qsz;

    /* access modifiers changed from: package-private */
    public interface a<InParamType, OutParamType> {
        InParamType bf(byte[] bArr);

        boolean czb();

        byte[] db(OutParamType outparamtype);

        OutParamType l(int i2, InParamType inparamtype);
    }

    l() {
        AppMethodBeat.i(239053);
        this.qsy = null;
        this.qsz = new SparseArray<>(5);
        this.qsy = new IConfCallBack() {
            /* class com.tencent.mm.plugin.multitalk.b.l.AnonymousClass1 */

            @Override // com.tencent.wxmm.IConfCallBack
            public final byte[] callBackFromConf(int i2, int i3, byte[] bArr) {
                AppMethodBeat.i(239051);
                Log.i("MicroMsg.Multitalk.ILinkNativeCallbackMgr", "hy: triggered native callback: %d, %d", Integer.valueOf(i2), Integer.valueOf(i3));
                byte[] c2 = l.this.c(i2, i3, bArr);
                AppMethodBeat.o(239051);
                return c2;
            }

            @Override // com.tencent.wxmm.IConfCallBack
            public final void callbackWriteLog(int i2, String str, String str2, int i3, String str3, String str4, int i4) {
                AppMethodBeat.i(239052);
                if (i2 >= s.cyW()) {
                    Xlog.logWrite2(i2, "CloudVoIPNative:".concat(String.valueOf(str)), str2, str3, Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str4);
                }
                AppMethodBeat.o(239052);
            }
        };
        AppMethodBeat.o(239053);
    }

    /* access modifiers changed from: package-private */
    public final IConfCallBack kK(boolean z) {
        IConfCallBack iConfCallBack;
        AppMethodBeat.i(239054);
        Log.i("MicroMsg.Multitalk.ILinkNativeCallbackMgr", "hy: trigger validate callback %b", Boolean.valueOf(z));
        synchronized (this) {
            if (z) {
                try {
                    this.qsz.clear();
                } catch (Throwable th) {
                    AppMethodBeat.o(239054);
                    throw th;
                }
            }
            iConfCallBack = this.qsy;
        }
        AppMethodBeat.o(239054);
        return iConfCallBack;
    }

    /* access modifiers changed from: package-private */
    public final byte[] c(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(239055);
        synchronized (this) {
            try {
                HashSet<a> hashSet = this.qsz.get(i2);
                if (hashSet == null || hashSet.size() <= 0) {
                    Log.w("MicroMsg.Multitalk.ILinkNativeCallbackMgr", "hy: nobody's listening to event %d, what a pity!", Integer.valueOf(i2));
                    byte[] bArr2 = new byte[1];
                    AppMethodBeat.o(239055);
                    return bArr2;
                }
                ArrayList arrayList = new ArrayList(1);
                byte[] bArr3 = new byte[1];
                Iterator<a> it = hashSet.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null) {
                        bArr3 = next.db(next.l(i3, next.bf(bArr)));
                        if (!next.czb()) {
                            arrayList.add(next);
                        }
                    } else {
                        Log.e("MicroMsg.Multitalk.ILinkNativeCallbackMgr", "hy: event %d item or buffer is null! weired", Integer.valueOf(i2));
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    hashSet.remove((a) it2.next());
                }
                return bArr3;
            } finally {
                AppMethodBeat.o(239055);
            }
        }
    }

    public final <ConvertedDataType, OutParamType> void a(int i2, a<ConvertedDataType, OutParamType> aVar) {
        boolean z = true;
        AppMethodBeat.i(239056);
        Log.i("MicroMsg.Multitalk.ILinkNativeCallbackMgr", "hy: registering event id: %d", Integer.valueOf(i2));
        synchronized (this) {
            try {
                HashSet<a> hashSet = this.qsz.get(i2);
                if (hashSet == null) {
                    hashSet = new HashSet<>(1);
                } else {
                    z = false;
                }
                hashSet.add(aVar);
                if (z) {
                    this.qsz.append(i2, hashSet);
                }
            } finally {
                AppMethodBeat.o(239056);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final <ConvertedDataType, OutParamType> void b(int i2, a<ConvertedDataType, OutParamType> aVar) {
        AppMethodBeat.i(239057);
        synchronized (this) {
            try {
                HashSet<a> hashSet = this.qsz.get(i2);
                if (hashSet != null) {
                    hashSet.remove(aVar);
                }
            } finally {
                AppMethodBeat.o(239057);
            }
        }
    }
}
