package com.bumptech.glide.load.b.b;

import android.support.v4.e.l;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.g.g;
import com.bumptech.glide.g.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.xwalk.core.XWalkAppVersion;

public final class j {
    private final g<com.bumptech.glide.load.g, String> aJn = new g<>(1000);
    private final l.a<a> aJo = com.bumptech.glide.g.a.a.a(10, new a.AbstractC0066a<a>() {
        /* class com.bumptech.glide.load.b.b.j.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.bumptech.glide.g.a.a.AbstractC0066a
        public final /* synthetic */ a oR() {
            AppMethodBeat.i(77166);
            a pl = pl();
            AppMethodBeat.o(77166);
            return pl;
        }

        private static a pl() {
            AppMethodBeat.i(77165);
            try {
                a aVar = new a(MessageDigest.getInstance(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM));
                AppMethodBeat.o(77165);
                return aVar;
            } catch (NoSuchAlgorithmException e2) {
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(77165);
                throw runtimeException;
            }
        }
    });

    public j() {
        AppMethodBeat.i(77168);
        AppMethodBeat.o(77168);
    }

    public final String e(com.bumptech.glide.load.g gVar) {
        String str;
        AppMethodBeat.i(77169);
        synchronized (this.aJn) {
            try {
                str = this.aJn.get(gVar);
            } finally {
                AppMethodBeat.o(77169);
            }
        }
        if (str == null) {
            str = f(gVar);
        }
        synchronized (this.aJn) {
            try {
                this.aJn.put(gVar, str);
            } finally {
                AppMethodBeat.o(77169);
            }
        }
        return str;
    }

    private String f(com.bumptech.glide.load.g gVar) {
        AppMethodBeat.i(77170);
        a aVar = (a) com.bumptech.glide.g.j.checkNotNull(this.aJo.acquire(), "Argument must not be null");
        try {
            gVar.a(aVar.aJq);
            return k.m(aVar.aJq.digest());
        } finally {
            this.aJo.release(aVar);
            AppMethodBeat.o(77170);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a implements a.c {
        private final b aGi = new b.a();
        final MessageDigest aJq;

        a(MessageDigest messageDigest) {
            AppMethodBeat.i(77167);
            this.aJq = messageDigest;
            AppMethodBeat.o(77167);
        }

        @Override // com.bumptech.glide.g.a.a.c
        public final b oK() {
            return this.aGi;
        }
    }
}
