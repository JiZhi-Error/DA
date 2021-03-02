package com.tencent.soter.a.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;

public final class b {
    String IwV;
    c RQP;
    public f RQQ;
    public int RQR;
    public com.tencent.soter.a.d.b RQS;
    com.tencent.soter.a.a.a RQT;
    com.tencent.soter.a.a.b RQU;
    Context mContext;
    public int mScene;
    public com.tencent.soter.a.d.a wFx;

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
    }

    public static class a {
        public b RQV = new b((byte) 0);

        public a() {
            AppMethodBeat.i(28);
            AppMethodBeat.o(28);
        }

        public final a aqL(int i2) {
            this.RQV.mScene = i2;
            return this;
        }

        public final a bqn(String str) {
            this.RQV.IwV = str;
            return this;
        }

        public final a lh(Context context) {
            this.RQV.mContext = context;
            return this;
        }

        public final a a(com.tencent.soter.a.a.a aVar) {
            this.RQV.RQT = aVar;
            return this;
        }

        public final a a(com.tencent.soter.a.a.b bVar) {
            this.RQV.RQU = bVar;
            return this;
        }

        public final a aqM(int i2) {
            this.RQV.RQR = i2;
            return this;
        }
    }

    public final String toString() {
        AppMethodBeat.i(29);
        String str = "AuthenticationParam{mScene=" + this.mScene + ", mChallenge='" + this.IwV + '\'' + ", mIWrapGetChallengeStr=" + this.RQP + ", mIWrapUploadSignature=" + this.RQQ + ", mContext=" + this.mContext + ", mBiometricType=" + this.RQR + '}';
        AppMethodBeat.o(29);
        return str;
    }
}
