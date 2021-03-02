package com.tencent.mm.sdk.platformtools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\b¢\u0006\u0002\u0010\u0007\u001a(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0001H\b¢\u0006\u0002\u0010\t\u001a(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0001H\b¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"TAG", "", "decodeProtoBuffer", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Landroid/content/Intent;", "key", "(Landroid/content/Intent;Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "libcompatible_release"})
public final class PlatformtoolsKt {
    public static final String TAG = "MicroMsg.Platformtools";

    public static final /* synthetic */ <T extends a> T decodeProtoBuffer(MultiProcessMMKV multiProcessMMKV, String str) {
        byte[] decodeBytes;
        boolean z = true;
        AppMethodBeat.i(215496);
        p.h(multiProcessMMKV, "$this$decodeProtoBuffer");
        p.h(str, "key");
        if (multiProcessMMKV.containsKey(str) && (decodeBytes = multiProcessMMKV.decodeBytes(str)) != null) {
            if (decodeBytes.length == 0) {
                z = false;
            }
            if (z) {
                try {
                    p.hyd();
                    Object newInstance = a.class.newInstance();
                    ((a) newInstance).parseFrom(decodeBytes);
                    T t = (T) ((a) newInstance);
                    AppMethodBeat.o(215496);
                    return t;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(215496);
        return null;
    }

    public static final /* synthetic */ <T extends a> T decodeProtoBuffer(Intent intent, String str) {
        boolean z = true;
        AppMethodBeat.i(215497);
        p.h(intent, "$this$decodeProtoBuffer");
        p.h(str, "key");
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra != null) {
            if (byteArrayExtra.length == 0) {
                z = false;
            }
            if (z) {
                try {
                    p.hyd();
                    Object newInstance = a.class.newInstance();
                    ((a) newInstance).parseFrom(byteArrayExtra);
                    T t = (T) ((a) newInstance);
                    AppMethodBeat.o(215497);
                    return t;
                } catch (Exception e2) {
                    Log.printErrStackTrace("Intent.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(215497);
        return null;
    }

    public static final /* synthetic */ <T extends a> T decodeProtoBuffer(Bundle bundle, String str) {
        boolean z = true;
        AppMethodBeat.i(215498);
        p.h(bundle, "$this$decodeProtoBuffer");
        p.h(str, "key");
        byte[] byteArray = bundle.getByteArray(str);
        if (byteArray != null) {
            p.g(byteArray, LocaleUtil.ITALIAN);
            if (byteArray.length == 0) {
                z = false;
            }
            if (z) {
                try {
                    p.hyd();
                    Object newInstance = a.class.newInstance();
                    ((a) newInstance).parseFrom(byteArray);
                    T t = (T) ((a) newInstance);
                    AppMethodBeat.o(215498);
                    return t;
                } catch (Exception e2) {
                    Log.printErrStackTrace("Intent.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(215498);
        return null;
    }
}
