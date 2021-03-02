package com.tencent.mm.plugin.appbrand.dynamic.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, final String[] strArr, String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(121281);
        if (((g) com.tencent.mm.kernel.g.af(g.class)).aXI().aXP()) {
            if ("//widget".equals(strArr[0])) {
                if (strArr.length >= 2) {
                    String lowerCase = strArr[1].toLowerCase();
                    switch (lowerCase.hashCode()) {
                        case -1408208058:
                            if (lowerCase.equals("assert")) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case 547812385:
                            if (lowerCase.equals("debugger")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1704329003:
                            if (lowerCase.equals("jniassert")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            com.tencent.mm.ch.a.post(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.dynamic.c.a.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(121275);
                                    String packageName = MMApplicationContext.getPackageName();
                                    if (strArr.length > 2 && !TextUtils.isEmpty(strArr[2])) {
                                        packageName = packageName + ":" + strArr[2];
                                    }
                                    h.a(packageName, null, C0571a.class, null);
                                    AppMethodBeat.o(121275);
                                }
                            });
                            AppMethodBeat.o(121281);
                            break;
                        case true:
                            com.tencent.mm.ch.a.post(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.dynamic.c.a.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(121276);
                                    String packageName = MMApplicationContext.getPackageName();
                                    if (strArr.length > 2 && !TextUtils.isEmpty(strArr[2])) {
                                        packageName = packageName + ":" + strArr[2];
                                    }
                                    h.a(packageName, null, b.class, null);
                                    AppMethodBeat.o(121276);
                                }
                            });
                            AppMethodBeat.o(121281);
                            break;
                        case true:
                            if (strArr.length > 2 && !TextUtils.isEmpty(strArr[2])) {
                                String str2 = strArr[2];
                                switch (str2.hashCode()) {
                                    case 46428:
                                        if (str2.equals("-cr")) {
                                            z2 = true;
                                            break;
                                        }
                                        z2 = true;
                                        break;
                                    case 46800:
                                        if (str2.equals("-or")) {
                                            z2 = false;
                                            break;
                                        }
                                        z2 = true;
                                        break;
                                    case 1450433:
                                        if (str2.equals("-ocb")) {
                                            z2 = true;
                                            break;
                                        }
                                        z2 = true;
                                        break;
                                    default:
                                        z2 = true;
                                        break;
                                }
                                switch (z2) {
                                    case false:
                                        ((g) com.tencent.mm.kernel.g.af(g.class)).aXI().fu(true);
                                        break;
                                    case true:
                                        ((g) com.tencent.mm.kernel.g.af(g.class)).aXI().fu(false);
                                        break;
                                    case true:
                                        ((g) com.tencent.mm.kernel.g.af(g.class)).aXI().cV(context);
                                        break;
                                }
                                AppMethodBeat.o(121281);
                                break;
                            } else {
                                AppMethodBeat.o(121281);
                                break;
                            }
                        default:
                            AppMethodBeat.o(121281);
                            break;
                    }
                } else {
                    AppMethodBeat.o(121281);
                }
            } else {
                AppMethodBeat.o(121281);
            }
        } else {
            AppMethodBeat.o(121281);
        }
        return true;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c.a$a  reason: collision with other inner class name */
    static class C0571a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private C0571a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(121278);
            com.tencent.mm.ch.a.x(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.c.a.C0571a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(121277);
                    Assert.assertTrue(String.format("execute assert process(%s) command", com.tencent.mm.ipcinvoker.g.axZ()), false);
                    AppMethodBeat.o(121277);
                }
            });
            AppMethodBeat.o(121278);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(121280);
            com.tencent.mm.ch.a.x(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.c.a.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(121279);
                    MMProtocalJni.setClientPackVersion(-1);
                    AppMethodBeat.o(121279);
                }
            });
            AppMethodBeat.o(121280);
        }
    }
}
