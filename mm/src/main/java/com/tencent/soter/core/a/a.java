package com.tencent.soter.core.a;

import android.content.Context;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.a.b;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
public final class a {
    public static final e RPk;
    public Context mContext;

    public interface e {
        void a(Context context, d dVar, CancellationSignal cancellationSignal, b bVar);

        boolean hasEnrolledFingerprints(Context context);

        boolean isHardwareDetected(Context context);
    }

    public static a lf(Context context) {
        AppMethodBeat.i(88611);
        a aVar = new a(context);
        AppMethodBeat.o(88611);
        return aVar;
    }

    private a(Context context) {
        this.mContext = context;
    }

    static {
        AppMethodBeat.i(88614);
        if (com.tencent.soter.core.a.hlj()) {
            RPk = new C2190a();
            AppMethodBeat.o(88614);
            return;
        }
        RPk = new f();
        AppMethodBeat.o(88614);
    }

    public final boolean hasEnrolledFingerprints() {
        AppMethodBeat.i(88612);
        boolean hasEnrolledFingerprints = RPk.hasEnrolledFingerprints(this.mContext);
        AppMethodBeat.o(88612);
        return hasEnrolledFingerprints;
    }

    public final void a(d dVar, CancellationSignal cancellationSignal, b bVar) {
        AppMethodBeat.i(88613);
        RPk.a(this.mContext, dVar, cancellationSignal, bVar);
        AppMethodBeat.o(88613);
    }

    public static class d {
        final Cipher mCipher;
        final Mac mMac;
        final Signature mSignature;

        public d(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public d(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public d(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }
    }

    public static final class c {
        private d RPm;

        public c(d dVar) {
            this.RPm = dVar;
        }
    }

    public static abstract class b {
        public void onAuthenticationError(int i2, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        }

        public void fme() {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationCancelled() {
        }
    }

    static class f implements e {
        @Override // com.tencent.soter.core.a.a.e
        public final boolean hasEnrolledFingerprints(Context context) {
            return false;
        }

        @Override // com.tencent.soter.core.a.a.e
        public final boolean isHardwareDetected(Context context) {
            return false;
        }

        @Override // com.tencent.soter.core.a.a.e
        public final void a(Context context, d dVar, CancellationSignal cancellationSignal, b bVar) {
        }
    }

    /* renamed from: com.tencent.soter.core.a.a$a  reason: collision with other inner class name */
    static class C2190a implements e {
        @Override // com.tencent.soter.core.a.a.e
        public final boolean hasEnrolledFingerprints(Context context) {
            AppMethodBeat.i(88606);
            boolean hasEnrolledFingerprints = b.hasEnrolledFingerprints(context);
            AppMethodBeat.o(88606);
            return hasEnrolledFingerprints;
        }

        @Override // com.tencent.soter.core.a.a.e
        public final boolean isHardwareDetected(Context context) {
            AppMethodBeat.i(88607);
            boolean isHardwareDetected = b.isHardwareDetected(context);
            AppMethodBeat.o(88607);
            return isHardwareDetected;
        }

        static void a(b.a aVar) {
            AppMethodBeat.i(88609);
            com.tencent.soter.core.c.d.w("Soter.FingerprintManagerCompat", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            aVar.onAuthenticationError(10308, "Too many failed times");
            AppMethodBeat.o(88609);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004f A[SYNTHETIC, Splitter:B:15:0x004f] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
        @Override // com.tencent.soter.core.a.a.e
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(final android.content.Context r10, com.tencent.soter.core.a.a.d r11, android.os.CancellationSignal r12, final com.tencent.soter.core.a.a.b r13) {
            /*
            // Method dump skipped, instructions count: 181
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.soter.core.a.a.C2190a.a(android.content.Context, com.tencent.soter.core.a.a$d, android.os.CancellationSignal, com.tencent.soter.core.a.a$b):void");
        }

        static /* synthetic */ boolean a(b.a aVar, Context context) {
            AppMethodBeat.i(88610);
            if (c.isSystemHasAntiBruteForce()) {
                com.tencent.soter.core.c.d.v("Soter.FingerprintManagerCompat", "soter: using system anti brute force strategy", new Object[0]);
                AppMethodBeat.o(88610);
                return false;
            } else if (c.isCurrentTweenTimeAvailable(context)) {
                if (!c.isCurrentFailTimeAvailable(context)) {
                    com.tencent.soter.core.c.d.v("Soter.FingerprintManagerCompat", "soter: unfreeze former frozen status", new Object[0]);
                    c.unFreeze(context);
                }
                AppMethodBeat.o(88610);
                return false;
            } else if (c.isCurrentFailTimeAvailable(context)) {
                com.tencent.soter.core.c.d.v("Soter.FingerprintManagerCompat", "soter: failure time available", new Object[0]);
                AppMethodBeat.o(88610);
                return false;
            } else {
                a(aVar);
                AppMethodBeat.o(88610);
                return true;
            }
        }
    }
}
