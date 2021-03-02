package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.Looper;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxmm.IConfCallBack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* access modifiers changed from: package-private */
public final class l {
    private IConfCallBack qsy = null;
    final SparseArray<HashSet<a>> qsz = new SparseArray<>(5);

    /* access modifiers changed from: package-private */
    public interface a<InParamType, OutParamType> {
        InParamType bf(byte[] bArr);

        boolean czb();

        byte[] db(OutParamType outparamtype);

        OutParamType l(int i2, InParamType inparamtype);
    }

    l() {
        AppMethodBeat.i(90820);
        AppMethodBeat.o(90820);
    }

    /* access modifiers changed from: package-private */
    public final IConfCallBack kK(boolean z) {
        IConfCallBack iConfCallBack;
        AppMethodBeat.i(90821);
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: trigger validate callback %b", Boolean.valueOf(z));
        synchronized (this) {
            if (z) {
                try {
                    this.qsy = new IConfCallBack() {
                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.AnonymousClass1 */

                        @Override // com.tencent.wxmm.IConfCallBack
                        public final byte[] callBackFromConf(int i2, int i3, byte[] bArr) {
                            AppMethodBeat.i(90818);
                            Log.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: triggered native callback: %d, %d", Integer.valueOf(i2), Integer.valueOf(i3));
                            HashSet<a> hashSet = l.this.qsz.get(i2);
                            if (hashSet == null || hashSet.size() <= 0) {
                                Log.w("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: nobody's listening to event %d, what a pity!", Integer.valueOf(i2));
                                byte[] bArr2 = new byte[1];
                                AppMethodBeat.o(90818);
                                return bArr2;
                            }
                            ArrayList arrayList = new ArrayList(1);
                            Iterator<a> it = hashSet.iterator();
                            byte[] bArr3 = new byte[1];
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null) {
                                    Object l = next.l(i3, next.bf(bArr));
                                    if (l != null) {
                                        bArr3 = next.db(l);
                                    }
                                    if (!next.czb()) {
                                        arrayList.add(next);
                                    }
                                } else {
                                    Log.e("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: item is null! weired");
                                }
                            }
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                hashSet.remove((a) it2.next());
                            }
                            AppMethodBeat.o(90818);
                            return bArr3;
                        }

                        @Override // com.tencent.wxmm.IConfCallBack
                        public final void callbackWriteLog(int i2, String str, String str2, int i3, String str3, String str4, int i4) {
                            AppMethodBeat.i(90819);
                            if (i2 >= c.cyW()) {
                                Xlog.logWrite2(i2, "CloudVoIPNative:".concat(String.valueOf(str)), str2, str3, Process.myTid(), Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str4);
                            }
                            AppMethodBeat.o(90819);
                        }
                    };
                } catch (Throwable th) {
                    AppMethodBeat.o(90821);
                    throw th;
                }
            } else {
                this.qsy = null;
            }
            this.qsz.clear();
            iConfCallBack = this.qsy;
        }
        AppMethodBeat.o(90821);
        return iConfCallBack;
    }

    /* access modifiers changed from: package-private */
    public final <ConvertedDataType, OutParamType> void a(int i2, a<ConvertedDataType, OutParamType> aVar) {
        boolean z = true;
        AppMethodBeat.i(90822);
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeCallbackMgr", "hy: registering event id: %d", Integer.valueOf(i2));
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
                AppMethodBeat.o(90822);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final <ConvertedDataType, OutParamType> void b(int i2, a<ConvertedDataType, OutParamType> aVar) {
        AppMethodBeat.i(90823);
        synchronized (this) {
            try {
                HashSet<a> hashSet = this.qsz.get(i2);
                if (hashSet != null) {
                    hashSet.remove(aVar);
                }
            } finally {
                AppMethodBeat.o(90823);
            }
        }
    }
}
