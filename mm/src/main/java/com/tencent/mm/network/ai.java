package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import kotlin.g.a.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0004\u001a\u0002H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0007H\u0002¢\u0006\u0002\u0010\b\u001aD\u0010\t\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\n\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u0001H\u00012\u0014\b\b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0007H\b¢\u0006\u0002\u0010\u000b\u001aD\u0010\t\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\f\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u0001H\u00012\u0014\b\b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0007H\b¢\u0006\u0002\u0010\r\u001aD\u0010\t\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u000e\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u0001H\u00012\u0014\b\b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0007H\b¢\u0006\u0002\u0010\u000f\u001aD\u0010\t\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0010\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u0001H\u00012\u0014\b\b\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0007H\b¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, hxF = {"runUse", "R", "T", "", "target", "asException", "block", "Lkotlin/Function1;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "use", "Lcom/tencent/mm/network/MMHttpUrlConnection;", "(Lcom/tencent/mm/network/MMHttpUrlConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/mm/network/MMHttpUrlCronetConnection;", "(Lcom/tencent/mm/network/MMHttpUrlCronetConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lcom/tencent/mm/network/MMHttpsUrlConnection;", "(Lcom/tencent/mm/network/MMHttpsUrlConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/net/URLConnection;", "(Ljava/net/URLConnection;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mmkernel_release"})
public final class ai {
    public static final <T, R> R a(T t, b<? super T, ? extends R> bVar) {
        AppMethodBeat.i(197251);
        try {
            R r = (R) bVar.invoke(t);
            try {
                InputStream inputStream = t.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th) {
            }
            t.disconnect();
            AppMethodBeat.o(197251);
            return r;
        } catch (Throwable th2) {
            try {
                InputStream inputStream2 = t.getInputStream();
                if (inputStream2 != null) {
                    inputStream2.close();
                }
            } catch (Throwable th3) {
            }
            t.disconnect();
            AppMethodBeat.o(197251);
            throw th2;
        }
    }
}
