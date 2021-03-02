package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.CancellationSignal;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.soter.a.a.b;
import com.tencent.soter.a.b.e;
import com.tencent.soter.a.f.c;
import com.tencent.soter.a.f.f;
import com.tencent.soter.core.biometric.BiometricManagerCompat;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.j;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import java.security.SignatureException;
import junit.framework.Assert;

public final class i extends d implements a {
    String IwV = null;
    private WeakReference<Context> OKT = null;
    String RQC = null;
    int RQR;
    com.tencent.soter.a.a.a RRE = null;
    b RRF = null;
    private a RRG = null;
    private c RRo = null;
    f RRp = null;
    j RRs = null;
    boolean RRu;
    boolean RRv;
    boolean RRw;
    private int mScene = -1;

    public i(b bVar) {
        boolean z = true;
        AppMethodBeat.i(93);
        this.RRu = Build.VERSION.SDK_INT < 23 && Build.MANUFACTURER.equalsIgnoreCase("vivo");
        this.RRv = Build.VERSION.SDK_INT >= 23 ? false : z;
        this.RRw = false;
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("param is null!");
            AppMethodBeat.o(93);
            throw illegalArgumentException;
        }
        this.mScene = bVar.mScene;
        this.RRo = bVar.RQP;
        this.RRp = bVar.RQQ;
        this.OKT = new WeakReference<>(bVar.mContext);
        this.RRF = bVar.RQU;
        this.RRE = bVar.RQT;
        this.RQR = bVar.RQR;
        this.IwV = bVar.IwV;
        AppMethodBeat.o(93);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    @SuppressLint({"DefaultLocale", "NewApi"})
    public final boolean hlM() {
        AppMethodBeat.i(94);
        if (!com.tencent.soter.a.c.b.hlG().isInit()) {
            d.w("Soter.TaskBiometricAuthentication", "soter: not initialized yet", new Object[0]);
            c(new com.tencent.soter.a.b.a(1008));
            AppMethodBeat.o(94);
            return true;
        } else if (!com.tencent.soter.a.c.b.hlG().hlC()) {
            d.w("Soter.TaskBiometricAuthentication", "soter: not support soter", new Object[0]);
            c(new com.tencent.soter.a.b.a(2));
            AppMethodBeat.o(94);
            return true;
        } else {
            Assert.assertTrue(Build.VERSION.SDK_INT >= 16);
            this.RQC = com.tencent.soter.a.c.b.hlG().hlI().get(this.mScene, "");
            if (g.isNullOrNil(this.RQC)) {
                d.w("Soter.TaskBiometricAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                c(new com.tencent.soter.a.b.a(1009, String.format("auth scene %d not initialized in map", Integer.valueOf(this.mScene))));
                AppMethodBeat.o(94);
                return true;
            } else if (!com.tencent.soter.core.a.bqh(this.RQC)) {
                d.w("Soter.TaskBiometricAuthentication", "soter: auth key %s not exists. need re-generate", this.RQC);
                c(new com.tencent.soter.a.b.a(1006, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", Integer.valueOf(this.mScene))));
                AppMethodBeat.o(94);
                return true;
            } else if (this.RRo != null || !g.isNullOrNil(this.IwV)) {
                Context context = this.OKT.get();
                if (context == null) {
                    d.w("Soter.TaskBiometricAuthentication", "soter: context instance released in preExecute", new Object[0]);
                    c(new com.tencent.soter.a.b.a(1011));
                    AppMethodBeat.o(94);
                    return true;
                } else if (!BiometricManagerCompat.from(context, Integer.valueOf(this.RQR)).hasEnrolledBiometric()) {
                    d.w("Soter.TaskBiometricAuthentication", "soter: user has not enrolled any biometric in system.", new Object[0]);
                    c(new com.tencent.soter.a.b.a(1013));
                    AppMethodBeat.o(94);
                    return true;
                } else if (com.tencent.soter.core.a.aW(context, this.RQR)) {
                    d.w("Soter.TaskBiometricAuthentication", "soter: biometric sensor frozen", new Object[0]);
                    c(new com.tencent.soter.a.b.a(1021, "Too many failed times"));
                    AppMethodBeat.o(94);
                    return true;
                } else if (this.RRE == null) {
                    d.w("Soter.TaskBiometricAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
                    this.RRE = new com.tencent.soter.a.a.a();
                    AppMethodBeat.o(94);
                    return false;
                } else {
                    if (this.RRp == null) {
                        d.w("Soter.TaskBiometricAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
                    }
                    AppMethodBeat.o(94);
                    return false;
                }
            } else {
                d.w("Soter.TaskBiometricAuthentication", "soter: challenge wrapper is null!", new Object[0]);
                c(new com.tencent.soter.a.b.a(1010, "neither get challenge wrapper nor challenge str is found in request parameter"));
                AppMethodBeat.o(94);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void hlN() {
        AppMethodBeat.i(95);
        if (this.RRE != null) {
            this.RRE.DP(true);
        }
        AppMethodBeat.o(95);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void execute() {
        AppMethodBeat.i(96);
        if (g.isNullOrNil(this.IwV)) {
            d.i("Soter.TaskBiometricAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
            this.RRo.setRequest(new c.a());
            this.RRo.a(new com.tencent.soter.a.f.b<c.b>() {
                /* class com.tencent.soter.a.g.i.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.soter.a.f.b
                public final /* synthetic */ void eB(c.b bVar) {
                    AppMethodBeat.i(73);
                    c.b bVar2 = bVar;
                    if (!g.isNullOrNil(bVar2.wFE)) {
                        i.this.IwV = bVar2.wFE;
                        i.this.hlS();
                        AppMethodBeat.o(73);
                        return;
                    }
                    d.w("Soter.TaskBiometricAuthentication", "soter: get challenge failed", new Object[0]);
                    i.this.c(new com.tencent.soter.a.b.a(1014));
                    AppMethodBeat.o(73);
                }
            });
            this.RRo.execute();
            AppMethodBeat.o(96);
            return;
        }
        d.i("Soter.TaskBiometricAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
        hlS();
        AppMethodBeat.o(96);
    }

    /* access modifiers changed from: package-private */
    public final void hlS() {
        AppMethodBeat.i(98);
        if (com.tencent.soter.core.a.hlf() == 1) {
            SoterSessionResult nI = com.tencent.soter.core.a.nI(this.RQC, this.IwV);
            if (nI == null) {
                d.w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
                c(new com.tencent.soter.a.b.a(1007));
                AppMethodBeat.o(98);
            } else if (nI.resultCode != 0) {
                d.w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
                c(new com.tencent.soter.a.b.a(1007));
                AppMethodBeat.o(98);
            } else {
                d.d("Soter.TaskBiometricAuthentication", "soter: session is %d", Long.valueOf(nI.dDZ));
                this.RRG = new a(this, null, (byte) 0);
                this.RRG.dDZ = nI.dDZ;
                b((Signature) null);
                g.hlR().postToMainThread(new Runnable() {
                    /* class com.tencent.soter.a.g.i.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(74);
                        if (i.this.RRF != null) {
                            i.this.RRF.fly();
                        }
                        AppMethodBeat.o(74);
                    }
                });
                AppMethodBeat.o(98);
            }
        } else {
            Signature bqk = com.tencent.soter.core.a.bqk(this.RQC);
            if (bqk == null) {
                d.w("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign", new Object[0]);
                c(new com.tencent.soter.a.b.a(1007));
                AppMethodBeat.o(98);
                return;
            }
            this.RRG = new a(this, bqk, (byte) 0);
            b(bqk);
            g.hlR().postToMainThread(new Runnable() {
                /* class com.tencent.soter.a.g.i.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(75);
                    if (i.this.RRF != null) {
                        i.this.RRF.fly();
                    }
                    AppMethodBeat.o(75);
                }
            });
            AppMethodBeat.o(98);
        }
    }

    /* access modifiers changed from: package-private */
    public final void hlT() {
        AppMethodBeat.i(100);
        if (this.RRs == null) {
            c(new com.tencent.soter.a.b.a(1018, "sign failed even after user authenticated the key."));
            AppMethodBeat.o(100);
            return;
        }
        this.RRp.setRequest(new f.a(this.RRs.signature, this.RRs.RPZ, this.RRs.RPY));
        this.RRp.a(new com.tencent.soter.a.f.b<f.b>() {
            /* class com.tencent.soter.a.g.i.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.soter.a.f.b
            public final /* synthetic */ void eB(f.b bVar) {
                AppMethodBeat.i(76);
                if (bVar.sPX) {
                    d.i("Soter.TaskBiometricAuthentication", "soter: upload and verify succeed", new Object[0]);
                    i.this.c(new com.tencent.soter.a.b.a(i.this.RRs));
                    AppMethodBeat.o(76);
                    return;
                }
                d.w("Soter.TaskBiometricAuthentication", "soter: upload or verify failed", new Object[0]);
                i.this.c(new com.tencent.soter.a.b.a(1019));
                AppMethodBeat.o(76);
            }
        });
        this.RRp.execute();
        AppMethodBeat.o(100);
    }

    @Override // com.tencent.soter.a.g.a
    public final void hlL() {
        AppMethodBeat.i(101);
        d.i("Soter.TaskBiometricAuthentication", "soter: called from cancellation signal", new Object[0]);
        if (this.RRG != null) {
            this.RRG.onAuthenticationCancelled();
        }
        AppMethodBeat.o(101);
    }

    @Override // com.tencent.soter.a.g.a
    public final boolean isCancelled() {
        return this.RRw;
    }

    /* access modifiers changed from: package-private */
    public class a extends BiometricManagerCompat.AuthenticationCallback {
        private Signature RRy;
        private long dDZ;

        /* synthetic */ a(i iVar, Signature signature, byte b2) {
            this(signature);
        }

        static /* synthetic */ String aI(CharSequence charSequence) {
            AppMethodBeat.i(92);
            String aH = aH(charSequence);
            AppMethodBeat.o(92);
            return aH;
        }

        private a(Signature signature) {
            this.RRy = null;
            this.RRy = signature;
        }

        private static String aH(CharSequence charSequence) {
            AppMethodBeat.i(85);
            if (charSequence == null) {
                AppMethodBeat.o(85);
                return "unknown error";
            }
            String charSequence2 = charSequence.toString();
            AppMethodBeat.o(85);
            return charSequence2;
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback
        public final void onAuthenticationError(final int i2, final CharSequence charSequence) {
            AppMethodBeat.i(86);
            d.e("Soter.TaskBiometricAuthentication", "soter: on authentication fatal error: %d, %s", Integer.valueOf(i2), charSequence);
            g.hlR().postToMainThread(new Runnable() {
                /* class com.tencent.soter.a.g.i.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(77);
                    if (i.this.RRF != null) {
                        i.this.RRF.onAuthenticationError(i2, charSequence);
                    }
                    AppMethodBeat.o(77);
                }
            });
            if (i2 == 10308) {
                i.this.c(new com.tencent.soter.a.b.a(1022, aH(charSequence)));
            } else if (i2 == 10309) {
                i.this.c(new com.tencent.soter.a.b.a(1022, aH(charSequence)));
            } else {
                i.this.c(new com.tencent.soter.a.b.a(HardCoderJNI.FUNC_CANCEL_GPU_HIGH_FREQ, aH(charSequence)));
            }
            hlV();
            AppMethodBeat.o(86);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback
        public final void onAuthenticationHelp(final int i2, final CharSequence charSequence) {
            AppMethodBeat.i(87);
            d.w("Soter.TaskBiometricAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", Integer.valueOf(i2), charSequence);
            g.hlR().postToMainThread(new Runnable() {
                /* class com.tencent.soter.a.g.i.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(78);
                    if (i.this.RRF != null) {
                        i.this.RRF.onAuthenticationHelp(i2, a.aI(charSequence));
                    }
                    AppMethodBeat.o(78);
                }
            });
            AppMethodBeat.o(87);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback
        public final void onAuthenticationSucceeded(BiometricManagerCompat.AuthenticationResult authenticationResult) {
            AppMethodBeat.i(88);
            d.i("Soter.TaskBiometricAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            g.hlR().postToMainThread(new Runnable() {
                /* class com.tencent.soter.a.g.i.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(79);
                    if (i.this.RRF != null) {
                        i.this.RRF.flz();
                    }
                    AppMethodBeat.o(79);
                }
            });
            g.hlR().aj(new Runnable() {
                /* class com.tencent.soter.a.g.i.a.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(80);
                    if (g.isNullOrNil(i.this.IwV)) {
                        d.e("Soter.TaskBiometricAuthentication", "soter: challenge is null. should not happen here", new Object[0]);
                        a.this.onAuthenticationError(-1000, "challenge is null");
                        AppMethodBeat.o(80);
                    } else if (com.tencent.soter.core.a.hlf() == 1) {
                        i iVar = i.this;
                        Signature unused = a.this.RRy;
                        try {
                            iVar.RRs = com.tencent.soter.core.a.cY(com.tencent.soter.core.a.Oz(a.this.dDZ));
                            if (iVar.RRp != null) {
                                iVar.hlT();
                                AppMethodBeat.o(80);
                                return;
                            }
                            d.i("Soter.TaskBiometricAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                            iVar.c(new com.tencent.soter.a.b.a(iVar.RRs));
                            AppMethodBeat.o(80);
                        } catch (Exception e2) {
                            d.e("Soter.TaskBiometricAuthentication", "soter: finish sign failed due to exception: %s", e2.getMessage());
                            d.a("Soter.TaskBiometricAuthentication", e2, "soter: sign failed due to exception");
                            iVar.c(new com.tencent.soter.a.b.a(1018, "sign failed even after user authenticated the key."));
                            AppMethodBeat.o(80);
                        }
                    } else {
                        try {
                            a.this.RRy.update(i.this.IwV.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
                        } catch (SignatureException e3) {
                            d.e("Soter.TaskBiometricAuthentication", "soter: exception in update", new Object[0]);
                            d.a("Soter.TaskBiometricAuthentication", e3, "soter: exception in update");
                            d.e("Soter.TaskBiometricAuthentication", "soter: remove the auth key: %s", i.this.RQC);
                            com.tencent.soter.core.a.dE(i.this.RQC, false);
                            i.this.c(new com.tencent.soter.a.b.a(TXLiteAVCode.EVT_HW_ENCODER_START_SUCC, "update signature failed. authkey removed after this failure, please check"));
                        }
                        try {
                            i iVar2 = i.this;
                            try {
                                iVar2.RRs = com.tencent.soter.core.a.cY(a.this.RRy.sign());
                                if (iVar2.RRp != null) {
                                    iVar2.hlT();
                                    AppMethodBeat.o(80);
                                    return;
                                }
                                d.i("Soter.TaskBiometricAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                                iVar2.c(new com.tencent.soter.a.b.a(iVar2.RRs));
                                AppMethodBeat.o(80);
                            } catch (SignatureException e4) {
                                d.e("Soter.TaskBiometricAuthentication", "soter: sign failed due to exception: %s", e4.getMessage());
                                d.a("Soter.TaskBiometricAuthentication", e4, "soter: sign failed due to exception");
                                iVar2.c(new com.tencent.soter.a.b.a(1018, "sign failed even after user authenticated the key."));
                                AppMethodBeat.o(80);
                            }
                        } catch (Exception e5) {
                            d.e("Soter.TaskBiometricAuthentication", "soter: exception in executeWhenAuthenticated method", new Object[0]);
                            d.a("Soter.TaskBiometricAuthentication", e5, "soter: exception when execute");
                            a.this.onAuthenticationError(-1000, "execute failed");
                            AppMethodBeat.o(80);
                        }
                    }
                }
            });
            hlV();
            AppMethodBeat.o(88);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback
        public final void onAuthenticationFailed() {
            AppMethodBeat.i(89);
            d.w("Soter.TaskBiometricAuthentication", "soter: authentication failed once", new Object[0]);
            g.hlR().postToMainThread(new Runnable() {
                /* class com.tencent.soter.a.g.i.a.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(81);
                    if (i.this.RRF != null) {
                        i.this.RRF.onAuthenticationFailed();
                    }
                    AppMethodBeat.o(81);
                }
            });
            if (i.this.RRu) {
                d.i("Soter.TaskBiometricAuthentication", "soter: should compat lower android version logic.", new Object[0]);
                i.this.RRE.DP(false);
                g.hlR().aj(new Runnable() {
                    /* class com.tencent.soter.a.g.i.a.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(83);
                        i.this.RRE.hlF();
                        AppMethodBeat.o(83);
                    }
                });
                g.hlR().m(new Runnable() {
                    /* class com.tencent.soter.a.g.i.a.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(84);
                        i.this.b(a.this.RRy);
                        AppMethodBeat.o(84);
                    }
                }, 1000);
            }
            if (i.this.RQR == 2) {
                d.i("Soter.TaskBiometricAuthentication", "soter: should compat faceid logic.", new Object[0]);
                i.this.c(new com.tencent.soter.a.b.a(HardCoderJNI.FUNC_CANCEL_GPU_HIGH_FREQ, "faceid not match"));
            }
            AppMethodBeat.o(89);
        }

        @Override // com.tencent.soter.core.biometric.BiometricManagerCompat.AuthenticationCallback
        public final void onAuthenticationCancelled() {
            AppMethodBeat.i(90);
            d.i("Soter.TaskBiometricAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
            if (i.this.RRw) {
                d.v("Soter.TaskBiometricAuthentication", "soter: during ignore cancel period", new Object[0]);
                AppMethodBeat.o(90);
                return;
            }
            g.hlR().postToMainThread(new Runnable() {
                /* class com.tencent.soter.a.g.i.a.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(82);
                    if (i.this.RRF != null) {
                        i.this.RRF.onAuthenticationCancelled();
                    }
                    AppMethodBeat.o(82);
                }
            });
            i.this.c(new com.tencent.soter.a.b.a(1020, "user cancelled authentication"));
            hlV();
            AppMethodBeat.o(90);
        }

        @SuppressLint({"NewApi"})
        private void hlV() {
            AppMethodBeat.i(91);
            if (i.this.RRv || i.this.RQR == 2) {
                i.this.RRE.DP(false);
                i.this.RRw = true;
            }
            AppMethodBeat.o(91);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.soter.a.g.d
    public final void b(e eVar) {
        AppMethodBeat.i(97);
        if ((eVar.errCode == 1018 || eVar.errCode == 1007 || eVar.errCode == 1015) && com.tencent.soter.a.c.a.a(getClass(), eVar)) {
            d.i("Soter.TaskBiometricAuthentication", "soter: same error happen too much, delete ask", new Object[0]);
            com.tencent.soter.a.a.hlE();
        }
        AppMethodBeat.o(97);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public final void b(Signature signature) {
        CancellationSignal cancellationSignal = null;
        AppMethodBeat.i(99);
        if (this.RQG) {
            d.w("Soter.TaskBiometricAuthentication", "soter: already finished. can not authenticate", new Object[0]);
            AppMethodBeat.o(99);
            return;
        }
        Context context = this.OKT.get();
        if (context == null) {
            d.w("Soter.TaskBiometricAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
            c(new com.tencent.soter.a.b.a(1011));
            AppMethodBeat.o(99);
            return;
        }
        try {
            d.v("Soter.TaskBiometricAuthentication", "soter: performing start", new Object[0]);
            BiometricManagerCompat from = BiometricManagerCompat.from(context, Integer.valueOf(this.RQR));
            BiometricManagerCompat.CryptoObject cryptoObject = new BiometricManagerCompat.CryptoObject(signature);
            if (this.RRE != null) {
                cancellationSignal = this.RRE.NHn;
            }
            from.authenticate(cryptoObject, 0, cancellationSignal, this.RRG, null);
            AppMethodBeat.o(99);
        } catch (Exception e2) {
            String message = e2.getMessage();
            d.e("Soter.TaskBiometricAuthentication", "soter: caused exception when authenticating: %s", message);
            d.a("Soter.TaskBiometricAuthentication", e2, "soter: caused exception when authenticating");
            c(new com.tencent.soter.a.b.a(HardCoderJNI.FUNC_REG_SYSTEM_EVENT_CALLBACK, String.format("start authentication failed due to %s", message)));
            AppMethodBeat.o(99);
        }
    }
}
