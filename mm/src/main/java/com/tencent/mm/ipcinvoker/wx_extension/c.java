package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import org.apache.commons.b.g;

public final class c implements com.tencent.mm.ipcinvoker.extension.a {

    static final class a {
        private static final MultiProcessMMKV hnJ = MultiProcessMMKV.getMMKV("MicroMsg_XIPC_MMProtoBufTransfer");

        static {
            AppMethodBeat.i(146410);
            AppMethodBeat.o(146410);
        }
    }

    static MultiProcessMMKV VQ() {
        AppMethodBeat.i(146411);
        MultiProcessMMKV multiProcessMMKV = a.hnJ;
        AppMethodBeat.o(146411);
        return multiProcessMMKV;
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final boolean bp(Object obj) {
        return obj instanceof com.tencent.mm.bw.a;
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final void a(Object obj, Parcel parcel) {
        byte[] bArr;
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(146412);
        if (obj == null) {
            parcel.writeString(null);
            AppMethodBeat.o(146412);
            return;
        }
        com.tencent.mm.bw.a aVar = (com.tencent.mm.bw.a) obj;
        parcel.writeString(aVar.getClass().getName());
        try {
            bArr = aVar.toByteArray();
        } catch (Exception e2) {
            Log.e("MicroMsg.XIPC.MMProtoBufTransfer", "writeToParcel, e = %s", e2);
            bArr = new byte[0];
        }
        MultiProcessMMKV multiProcessMMKV = a.hnJ;
        if (bArr.length > 102400 && multiProcessMMKV != null) {
            try {
                long j2 = multiProcessMMKV.totalSize();
                if (j2 >= 20971520) {
                    Log.e("MicroMsg.XIPC.MMProtoBufTransfer", "mmkv totalSize[%d] too large, skip use mmkv", Long.valueOf(j2));
                } else {
                    String a2 = g.a(new String[]{MMApplicationContext.getProcessName(), obj.getClass().getName(), new StringBuilder().append(obj.hashCode()).toString(), new StringBuilder().append(SystemClock.elapsedRealtimeNanos()).toString()}, "$");
                    multiProcessMMKV.encode(a2, bArr);
                    if (multiProcessMMKV.containsKey(a2)) {
                        parcel.writeString(a2);
                    } else {
                        z = false;
                    }
                    z2 = z;
                }
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.XIPC.MMProtoBufTransfer", th, "encode bytes to mmkv", new Object[0]);
            }
        }
        if (!z2) {
            parcel.writeString(null);
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        AppMethodBeat.o(146412);
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final Object d(Parcel parcel) {
        byte[] bArr;
        com.tencent.mm.bw.a aVar;
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(146413);
        String readString = parcel.readString();
        if (TextUtils.isEmpty(readString)) {
            AppMethodBeat.o(146413);
            return null;
        }
        String readString2 = parcel.readString();
        if (!TextUtils.isEmpty(readString2)) {
            MultiProcessMMKV multiProcessMMKV = a.hnJ;
            try {
                bArr = multiProcessMMKV.decodeBytes(readString2);
                if (bArr == null) {
                    try {
                        Log.e("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel, NULL bytes, gProtoBufXProcessStore[%s]", multiProcessMMKV);
                        try {
                            multiProcessMMKV.removeValueForKey(readString2);
                            if (bArr != null && bArr.length >= 1048576) {
                                multiProcessMMKV.trim();
                            }
                        } catch (Throwable th3) {
                        }
                        AppMethodBeat.o(146413);
                        return null;
                    } catch (Throwable th4) {
                        th2 = th4;
                        try {
                            Log.printErrStackTrace("MicroMsg.XIPC.MMProtoBufTransfer", th2, "readFromParcel", new Object[0]);
                            try {
                                multiProcessMMKV.removeValueForKey(readString2);
                                multiProcessMMKV.trim();
                            } catch (Throwable th5) {
                            }
                            AppMethodBeat.o(146413);
                            return null;
                        } catch (Throwable th6) {
                            th = th6;
                            try {
                                multiProcessMMKV.removeValueForKey(readString2);
                                multiProcessMMKV.trim();
                            } catch (Throwable th7) {
                            }
                            AppMethodBeat.o(146413);
                            throw th;
                        }
                    }
                } else {
                    try {
                        multiProcessMMKV.removeValueForKey(readString2);
                        if (bArr != null && bArr.length >= 1048576) {
                            multiProcessMMKV.trim();
                        }
                    } catch (Throwable th8) {
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                bArr = null;
                multiProcessMMKV.removeValueForKey(readString2);
                if (bArr != null && bArr.length >= 1048576) {
                    multiProcessMMKV.trim();
                }
                AppMethodBeat.o(146413);
                throw th;
            }
        } else {
            bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
        }
        try {
            aVar = (com.tencent.mm.bw.a) org.a.a.bF(org.a.a.forName(readString)).hPX().object;
            aVar.parseFrom(bArr);
        } catch (Throwable th10) {
            Log.e("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel, e = %s", th10);
            aVar = null;
        }
        AppMethodBeat.o(146413);
        return aVar;
    }
}
