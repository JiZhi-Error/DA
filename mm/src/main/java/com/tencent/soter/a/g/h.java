package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.CancellationSignal;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.soter.a.b.e;
import com.tencent.soter.a.d.b;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;
import com.tencent.soter.core.a.a;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.j;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import java.security.SignatureException;
import junit.framework.Assert;

@Deprecated
public final class h extends d implements a {
    String IwV = null;
    private WeakReference<Context> OKT = null;
    String RQC = null;
    private c RRo = null;
    f RRp = null;
    com.tencent.soter.a.d.a RRq = null;
    b RRr = null;
    j RRs = null;
    private a RRt = null;
    boolean RRu;
    boolean RRv;
    boolean RRw;
    private int mScene = -1;

    public h(b bVar) {
        boolean z = true;
        AppMethodBeat.i(64);
        this.RRu = Build.VERSION.SDK_INT < 23 && Build.MANUFACTURER.equalsIgnoreCase("vivo");
        this.RRv = Build.VERSION.SDK_INT >= 23 ? false : z;
        this.RRw = false;
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("param is null!");
            AppMethodBeat.o(64);
            throw illegalArgumentException;
        }
        this.mScene = bVar.mScene;
        this.RRo = bVar.RQP;
        this.RRp = bVar.RQQ;
        this.OKT = new WeakReference<>(bVar.mContext);
        this.RRr = bVar.RQS;
        this.RRq = bVar.wFx;
        this.IwV = bVar.IwV;
        AppMethodBeat.o(64);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    @SuppressLint({"DefaultLocale", "NewApi"})
    public final boolean hlM() {
        AppMethodBeat.i(65);
        if (!com.tencent.soter.a.c.b.hlG().isInit()) {
            d.w("Soter.TaskAuthentication", "soter: not initialized yet", new Object[0]);
            c(new com.tencent.soter.a.b.a(1008));
            AppMethodBeat.o(65);
            return true;
        } else if (!com.tencent.soter.a.c.b.hlG().hlC()) {
            d.w("Soter.TaskAuthentication", "soter: not support soter", new Object[0]);
            c(new com.tencent.soter.a.b.a(2));
            AppMethodBeat.o(65);
            return true;
        } else {
            Assert.assertTrue(Build.VERSION.SDK_INT >= 16);
            this.RQC = com.tencent.soter.a.c.b.hlG().hlI().get(this.mScene, "");
            if (g.isNullOrNil(this.RQC)) {
                d.w("Soter.TaskAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                c(new com.tencent.soter.a.b.a(1009, String.format("auth scene %d not initialized in map", Integer.valueOf(this.mScene))));
                AppMethodBeat.o(65);
                return true;
            } else if (!com.tencent.soter.core.a.bqh(this.RQC)) {
                d.w("Soter.TaskAuthentication", "soter: auth key %s not exists. need re-generate", this.RQC);
                c(new com.tencent.soter.a.b.a(1006, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", Integer.valueOf(this.mScene))));
                AppMethodBeat.o(65);
                return true;
            } else if (this.RRo != null || !g.isNullOrNil(this.IwV)) {
                Context context = this.OKT.get();
                if (context == null) {
                    d.w("Soter.TaskAuthentication", "soter: context instance released in preExecute", new Object[0]);
                    c(new com.tencent.soter.a.b.a(1011));
                    AppMethodBeat.o(65);
                    return true;
                } else if (!com.tencent.soter.core.a.a.lf(context).hasEnrolledFingerprints()) {
                    d.w("Soter.TaskAuthentication", "soter: user has not enrolled any fingerprint in system.", new Object[0]);
                    c(new com.tencent.soter.a.b.a(1012));
                    AppMethodBeat.o(65);
                    return true;
                } else if (com.tencent.soter.core.a.le(context)) {
                    d.w("Soter.TaskAuthentication", "soter: fingerprint sensor frozen", new Object[0]);
                    c(new com.tencent.soter.a.b.a(1021, "Too many failed times"));
                    AppMethodBeat.o(65);
                    return true;
                } else if (this.RRq == null) {
                    d.w("Soter.TaskAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
                    this.RRq = new com.tencent.soter.a.d.a();
                    AppMethodBeat.o(65);
                    return false;
                } else {
                    if (this.RRp == null) {
                        d.w("Soter.TaskAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
                    }
                    AppMethodBeat.o(65);
                    return false;
                }
            } else {
                d.w("Soter.TaskAuthentication", "soter: challenge wrapper is null!", new Object[0]);
                c(new com.tencent.soter.a.b.a(1010, "neither get challenge wrapper nor challenge str is found in request parameter"));
                AppMethodBeat.o(65);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void hlN() {
        AppMethodBeat.i(66);
        if (this.RRq != null) {
            this.RRq.DR(true);
        }
        AppMethodBeat.o(66);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void execute() {
        AppMethodBeat.i(67);
        if (g.isNullOrNil(this.IwV)) {
            d.i("Soter.TaskAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
            this.RRo.setRequest(new c.a());
            this.RRo.a(new com.tencent.soter.a.f.b<c.b>() {
                /* class com.tencent.soter.a.g.h.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.soter.a.f.b
                public final /* synthetic */ void eB(c.b bVar) {
                    AppMethodBeat.i(45);
                    c.b bVar2 = bVar;
                    if (!g.isNullOrNil(bVar2.wFE)) {
                        h.this.IwV = bVar2.wFE;
                        h.this.hlS();
                        AppMethodBeat.o(45);
                        return;
                    }
                    d.w("Soter.TaskAuthentication", "soter: get challenge failed", new Object[0]);
                    h.this.c(new com.tencent.soter.a.b.a(1014));
                    AppMethodBeat.o(45);
                }
            });
            this.RRo.execute();
            AppMethodBeat.o(67);
            return;
        }
        d.i("Soter.TaskAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
        hlS();
        AppMethodBeat.o(67);
    }

    /* access modifiers changed from: package-private */
    public final void hlS() {
        AppMethodBeat.i(69);
        if (com.tencent.soter.core.a.hlf() == 1) {
            SoterSessionResult nI = com.tencent.soter.core.a.nI(this.RQC, this.IwV);
            if (nI == null) {
                d.w("Soter.TaskAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
                c(new com.tencent.soter.a.b.a(1007));
                AppMethodBeat.o(69);
            } else if (nI.resultCode != 0) {
                d.w("Soter.TaskAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
                c(new com.tencent.soter.a.b.a(1007));
                AppMethodBeat.o(69);
            } else {
                d.d("Soter.TaskAuthentication", "soter: session is %d", Long.valueOf(nI.dDZ));
                this.RRt = new a(this, null, (byte) 0);
                this.RRt.dDZ = nI.dDZ;
                a(null);
                g.hlR().postToMainThread(new Runnable() {
                    /* class com.tencent.soter.a.g.h.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(46);
                        if (h.this.RRr != null) {
                            h.this.RRr.fly();
                        }
                        AppMethodBeat.o(46);
                    }
                });
                AppMethodBeat.o(69);
            }
        } else {
            Signature bqk = com.tencent.soter.core.a.bqk(this.RQC);
            if (bqk == null) {
                d.w("Soter.TaskAuthentication", "soter: error occurred when init sign", new Object[0]);
                c(new com.tencent.soter.a.b.a(1007));
                AppMethodBeat.o(69);
                return;
            }
            this.RRt = new a(this, bqk, (byte) 0);
            a(bqk);
            g.hlR().postToMainThread(new Runnable() {
                /* class com.tencent.soter.a.g.h.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(47);
                    if (h.this.RRr != null) {
                        h.this.RRr.fly();
                    }
                    AppMethodBeat.o(47);
                }
            });
            AppMethodBeat.o(69);
        }
    }

    /* access modifiers changed from: package-private */
    public final void hlT() {
        AppMethodBeat.i(71);
        if (this.RRs == null) {
            c(new com.tencent.soter.a.b.a(1018, "sign failed even after user authenticated the key."));
            AppMethodBeat.o(71);
            return;
        }
        this.RRp.setRequest(new f.a(this.RRs.signature, this.RRs.RPZ, this.RRs.RPY));
        this.RRp.a(new com.tencent.soter.a.f.b<f.b>() {
            /* class com.tencent.soter.a.g.h.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.soter.a.f.b
            public final /* synthetic */ void eB(f.b bVar) {
                AppMethodBeat.i(48);
                if (bVar.sPX) {
                    d.i("Soter.TaskAuthentication", "soter: upload and verify succeed", new Object[0]);
                    h.this.c(new com.tencent.soter.a.b.a(h.this.RRs));
                    AppMethodBeat.o(48);
                    return;
                }
                d.w("Soter.TaskAuthentication", "soter: upload or verify failed", new Object[0]);
                h.this.c(new com.tencent.soter.a.b.a(1019));
                AppMethodBeat.o(48);
            }
        });
        this.RRp.execute();
        AppMethodBeat.o(71);
    }

    @Override // com.tencent.soter.a.g.a
    public final void hlL() {
        AppMethodBeat.i(72);
        d.i("Soter.TaskAuthentication", "soter: called from cancellation signal", new Object[0]);
        if (this.RRt != null) {
            this.RRt.onAuthenticationCancelled();
        }
        AppMethodBeat.o(72);
    }

    @Override // com.tencent.soter.a.g.a
    public final boolean isCancelled() {
        return this.RRw;
    }

    /* access modifiers changed from: package-private */
    public class a extends a.b {
        Signature RRy;
        long dDZ;

        /* synthetic */ a(h hVar, Signature signature, byte b2) {
            this(signature);
        }

        private a(Signature signature) {
            this.RRy = null;
            this.RRy = signature;
        }

        static String aH(CharSequence charSequence) {
            AppMethodBeat.i(57);
            if (charSequence == null) {
                AppMethodBeat.o(57);
                return "unknown error";
            }
            String charSequence2 = charSequence.toString();
            AppMethodBeat.o(57);
            return charSequence2;
        }

        @Override // com.tencent.soter.core.a.a.b
        public final void onAuthenticationError(final int i2, final CharSequence charSequence) {
            AppMethodBeat.i(58);
            d.e("Soter.TaskAuthentication", "soter: on authentication fatal error: %d, %s", Integer.valueOf(i2), charSequence);
            if (i2 != 10308) {
                g.hlR().postToMainThread(new Runnable() {
                    /* class com.tencent.soter.a.g.h.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(49);
                        if (h.this.RRr != null) {
                            h.this.RRr.onAuthenticationError(i2, charSequence);
                        }
                        AppMethodBeat.o(49);
                    }
                });
                h.this.c(new com.tencent.soter.a.b.a(HardCoderJNI.FUNC_GPU_HIGH_FREQ, aH(charSequence)));
            } else {
                h.this.c(new com.tencent.soter.a.b.a(1021, aH(charSequence)));
            }
            hlU();
            AppMethodBeat.o(58);
        }

        @Override // com.tencent.soter.core.a.a.b
        public final void onAuthenticationHelp(final int i2, final CharSequence charSequence) {
            AppMethodBeat.i(59);
            d.w("Soter.TaskAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", Integer.valueOf(i2), charSequence);
            g.hlR().postToMainThread(new Runnable() {
                /* class com.tencent.soter.a.g.h.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(50);
                    if (h.this.RRr != null) {
                        h.this.RRr.onAuthenticationHelp(i2, a.aH(charSequence));
                    }
                    AppMethodBeat.o(50);
                }
            });
            AppMethodBeat.o(59);
        }

        @Override // com.tencent.soter.core.a.a.b
        public final void fme() {
            AppMethodBeat.i(60);
            d.i("Soter.TaskAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            g.hlR().aj(new Runnable() {
                /* class com.tencent.soter.a.g.h.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(51);
                    if (g.isNullOrNil(h.this.IwV)) {
                        d.e("Soter.TaskAuthentication", "soter: challenge is null. should not happen here", new Object[0]);
                        a.this.onAuthenticationError(-1000, "challenge is null");
                        AppMethodBeat.o(51);
                    } else if (com.tencent.soter.core.a.hlf() == 1) {
                        h hVar = h.this;
                        try {
                            hVar.RRs = com.tencent.soter.core.a.cY(com.tencent.soter.core.a.Oz(a.this.dDZ));
                            if (hVar.RRp != null) {
                                hVar.hlT();
                                AppMethodBeat.o(51);
                                return;
                            }
                            d.i("Soter.TaskAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                            hVar.c(new com.tencent.soter.a.b.a(hVar.RRs));
                            AppMethodBeat.o(51);
                        } catch (Exception e2) {
                            d.e("Soter.TaskAuthentication", "soter: finish sign failed due to exception: %s", e2.getMessage());
                            d.a("Soter.TaskAuthentication", e2, "soter: sign failed due to exception");
                            hVar.c(new com.tencent.soter.a.b.a(1018, "sign failed even after user authenticated the key."));
                            AppMethodBeat.o(51);
                        }
                    } else {
                        try {
                            a.this.RRy.update(h.this.IwV.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
                        } catch (SignatureException e3) {
                            d.e("Soter.TaskAuthentication", "soter: exception in update", new Object[0]);
                            d.a("Soter.TaskAuthentication", e3, "soter: exception in update");
                            d.e("Soter.TaskAuthentication", "soter: remove the auth key: %s", h.this.RQC);
                            com.tencent.soter.core.a.dE(h.this.RQC, false);
                            h.this.c(new com.tencent.soter.a.b.a(TXLiteAVCode.EVT_HW_ENCODER_START_SUCC, "update signature failed. authkey removed after this failure, please check"));
                        }
                        try {
                            h hVar2 = h.this;
                            try {
                                hVar2.RRs = com.tencent.soter.core.a.cY(a.this.RRy.sign());
                                if (hVar2.RRp != null) {
                                    hVar2.hlT();
                                    AppMethodBeat.o(51);
                                    return;
                                }
                                d.i("Soter.TaskAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                                hVar2.c(new com.tencent.soter.a.b.a(hVar2.RRs));
                                AppMethodBeat.o(51);
                            } catch (SignatureException e4) {
                                d.e("Soter.TaskAuthentication", "soter: sign failed due to exception: %s", e4.getMessage());
                                d.a("Soter.TaskAuthentication", e4, "soter: sign failed due to exception");
                                hVar2.c(new com.tencent.soter.a.b.a(1018, "sign failed even after user authenticated the key."));
                                AppMethodBeat.o(51);
                            }
                        } catch (Exception e5) {
                            d.e("Soter.TaskAuthentication", "soter: exception in executeWhenAuthenticated method", new Object[0]);
                            d.a("Soter.TaskAuthentication", e5, "soter: exception when execute");
                            a.this.onAuthenticationError(-1000, "execute failed");
                            AppMethodBeat.o(51);
                        }
                    }
                }
            });
            g.hlR().postToMainThread(new Runnable() {
                /* class com.tencent.soter.a.g.h.a.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(52);
                    if (h.this.RRr != null) {
                        h.this.RRr.flz();
                    }
                    AppMethodBeat.o(52);
                }
            });
            hlU();
            AppMethodBeat.o(60);
        }

        @Override // com.tencent.soter.core.a.a.b
        public final void onAuthenticationFailed() {
            AppMethodBeat.i(61);
            super.onAuthenticationFailed();
            d.w("Soter.TaskAuthentication", "soter: authentication failed once", new Object[0]);
            g.hlR().postToMainThread(new Runnable() {
                /* class com.tencent.soter.a.g.h.a.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(53);
                    if (h.this.RRr != null) {
                        h.this.RRr.onAuthenticationFailed();
                    }
                    AppMethodBeat.o(53);
                }
            });
            if (h.this.RRu) {
                d.i("Soter.TaskAuthentication", "soter: should compat lower android version logic.", new Object[0]);
                h.this.RRq.DR(false);
                g.hlR().aj(new Runnable() {
                    /* class com.tencent.soter.a.g.h.a.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(55);
                        h.this.RRq.hlF();
                        AppMethodBeat.o(55);
                    }
                });
                g.hlR().m(new Runnable() {
                    /* class com.tencent.soter.a.g.h.a.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(56);
                        h.this.a(a.this.RRy);
                        AppMethodBeat.o(56);
                    }
                }, 1000);
            }
            AppMethodBeat.o(61);
        }

        @Override // com.tencent.soter.core.a.a.b
        public final void onAuthenticationCancelled() {
            AppMethodBeat.i(62);
            d.i("Soter.TaskAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
            if (h.this.RRw) {
                d.v("Soter.TaskAuthentication", "soter: during ignore cancel period", new Object[0]);
                AppMethodBeat.o(62);
                return;
            }
            super.onAuthenticationCancelled();
            g.hlR().postToMainThread(new Runnable() {
                /* class com.tencent.soter.a.g.h.a.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(54);
                    if (h.this.RRr != null) {
                        h.this.RRr.onAuthenticationCancelled();
                    }
                    AppMethodBeat.o(54);
                }
            });
            h.this.c(new com.tencent.soter.a.b.a(1020, "user cancelled authentication"));
            hlU();
            AppMethodBeat.o(62);
        }

        @SuppressLint({"NewApi"})
        private void hlU() {
            AppMethodBeat.i(63);
            if (h.this.RRv) {
                h.this.RRq.DR(false);
                h.this.RRw = true;
            }
            AppMethodBeat.o(63);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void b(e eVar) {
        AppMethodBeat.i(68);
        if ((eVar.errCode == 1018 || eVar.errCode == 1007 || eVar.errCode == 1015) && com.tencent.soter.a.c.a.a(getClass(), eVar)) {
            d.i("Soter.TaskAuthentication", "soter: same error happen too much, delete ask", new Object[0]);
            com.tencent.soter.a.a.hlE();
        }
        AppMethodBeat.o(68);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public final void a(Signature signature) {
        CancellationSignal cancellationSignal;
        AppMethodBeat.i(70);
        if (this.RQG) {
            d.w("Soter.TaskAuthentication", "soter: already finished. can not authenticate", new Object[0]);
            AppMethodBeat.o(70);
            return;
        }
        Context context = this.OKT.get();
        if (context == null) {
            d.w("Soter.TaskAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
            c(new com.tencent.soter.a.b.a(1011));
            AppMethodBeat.o(70);
            return;
        }
        try {
            d.v("Soter.TaskAuthentication", "soter: performing start", new Object[0]);
            com.tencent.soter.core.a.a lf = com.tencent.soter.core.a.a.lf(context);
            a.d dVar = new a.d(signature);
            if (this.RRq != null) {
                cancellationSignal = this.RRq.NHn;
            } else {
                cancellationSignal = null;
            }
            lf.a(dVar, cancellationSignal, this.RRt);
            AppMethodBeat.o(70);
        } catch (Exception e2) {
            String message = e2.getMessage();
            d.e("Soter.TaskAuthentication", "soter: caused exception when authenticating: %s", message);
            d.a("Soter.TaskAuthentication", e2, "soter: caused exception when authenticating");
            c(new com.tencent.soter.a.b.a(HardCoderJNI.FUNC_REG_SYSTEM_EVENT_CALLBACK, String.format("start authentication failed due to %s", message)));
            AppMethodBeat.o(70);
        }
    }
}
