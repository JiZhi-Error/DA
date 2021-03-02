package com.tencent.mm.platformtools;

import a.f;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.permission.PermissionHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class p {
    private static Executor jMN;

    public interface a {
        void bP(String str, String str2);

        void bQ(String str, String str2);
    }

    static /* synthetic */ void L(Runnable runnable) {
        AppMethodBeat.i(223690);
        K(runnable);
        AppMethodBeat.o(223690);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    static {
        /*
            r6 = 223691(0x369cb, float:3.13458E-40)
            r2 = 1
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            r0 = 0
            com.tencent.mm.platformtools.p.jMN = r0
            java.lang.Class<com.tencent.mm.plugin.expt.b.b> r0 = com.tencent.mm.plugin.expt.b.b.class
            com.tencent.mm.kernel.c.a r0 = com.tencent.mm.kernel.g.af(r0)     // Catch:{ Throwable -> 0x004d }
            com.tencent.mm.plugin.expt.b.b r0 = (com.tencent.mm.plugin.expt.b.b) r0     // Catch:{ Throwable -> 0x004d }
            if (r0 == 0) goto L_0x0059
            com.tencent.mm.plugin.expt.b.b$a r3 = com.tencent.mm.plugin.expt.b.b.a.clicfg_media_exporting_async     // Catch:{ Throwable -> 0x004d }
            r4 = 1
            int r0 = r0.a(r3, r4)     // Catch:{ Throwable -> 0x004d }
        L_0x001c:
            if (r0 == 0) goto L_0x001f
            r1 = r2
        L_0x001f:
            if (r1 == 0) goto L_0x0028
            com.tencent.mm.platformtools.p$1 r2 = new com.tencent.mm.platformtools.p$1
            r2.<init>()
            com.tencent.mm.platformtools.p.jMN = r2
        L_0x0028:
            java.lang.String r2 = "MicroMsg.ExportFileUtil"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "res update cliCfg = "
            r3.<init>(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r3 = ", exportingAsync = "
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.tencent.mm.sdk.platformtools.Log.i(r2, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x004d:
            r0 = move-exception
            java.lang.String r3 = "MicroMsg.ExportFileUtil"
            java.lang.String r4 = ""
            java.lang.Object[] r5 = new java.lang.Object[r1]
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r3, r0, r4, r5)
        L_0x0059:
            r0 = r1
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.p.<clinit>():void");
    }

    public static void a(Context context, final android.support.v4.e.c<Boolean> cVar) {
        AppMethodBeat.i(223675);
        Log.i("MicroMsg.ExportFileUtil", "[+] Called checkStoragePermission, ctx: %s", context);
        if (PermissionHelper.bdR("android.permission.WRITE_EXTERNAL_STORAGE")) {
            Log.i("MicroMsg.ExportFileUtil", "[+] hasPermission = true");
            cVar.accept(Boolean.TRUE);
            AppMethodBeat.o(223675);
        } else if (!(context instanceof Activity)) {
            Log.e("MicroMsg.ExportFileUtil", "[-] Context [%s] is not an ui context, regard as user denied since we can't ask him.");
            cVar.accept(Boolean.FALSE);
            AppMethodBeat.o(223675);
        } else {
            Log.i("MicroMsg.ExportFileUtil", "requestPermission");
            PermissionHelper.aX((Activity) context).a(context.getString(R.string.flp), context.getString(R.string.c2y), "android.permission.WRITE_EXTERNAL_STORAGE", new c(context) {
                /* class com.tencent.mm.platformtools.p.AnonymousClass4 */

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.platformtools.p.c
                public final void blu() {
                    AppMethodBeat.i(223656);
                    Log.i("MicroMsg.ExportFileUtil", "[+] onPermissionGranted");
                    cVar.accept(Boolean.TRUE);
                    AppMethodBeat.o(223656);
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.platformtools.p.c
                public final void blv() {
                    AppMethodBeat.i(223657);
                    Log.i("MicroMsg.ExportFileUtil", "[-] onPermissionGranted");
                    cVar.accept(Boolean.FALSE);
                    AppMethodBeat.o(223657);
                }
            });
            AppMethodBeat.o(223675);
        }
    }

    public static void a(Context context, final Runnable runnable, final Runnable runnable2) {
        AppMethodBeat.i(223676);
        Log.i("MicroMsg.ExportFileUtil", "[+] Called requestStoragePermission, ctx: %s", context);
        if (!(context instanceof Activity)) {
            Log.e("MicroMsg.ExportFileUtil", "[-] Context [%s] is not an ui context, regard as user denied since we can't ask him.");
            K(runnable2);
            AppMethodBeat.o(223676);
            return;
        }
        PermissionHelper.aX((Activity) context).a(context.getString(R.string.flp), context.getString(R.string.c2y), "android.permission.WRITE_EXTERNAL_STORAGE", new c(context) {
            /* class com.tencent.mm.platformtools.p.AnonymousClass5 */

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.platformtools.p.c
            public final void blu() {
                AppMethodBeat.i(223658);
                p.L(runnable);
                AppMethodBeat.o(223658);
            }

            /* access modifiers changed from: protected */
            @Override // com.tencent.mm.platformtools.p.c
            public final void blv() {
                AppMethodBeat.i(223659);
                p.L(runnable2);
                AppMethodBeat.o(223659);
            }
        });
        AppMethodBeat.o(223676);
    }

    public static void I(final Context context, final String str) {
        AppMethodBeat.i(223677);
        AnonymousClass6 r0 = new Runnable() {
            /* class com.tencent.mm.platformtools.p.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(223660);
                Toast.makeText(context, str, 1).show();
                AppMethodBeat.o(223660);
            }
        };
        if (Looper.myLooper() != null) {
            r0.run();
            AppMethodBeat.o(223677);
            return;
        }
        h.RTc.aW(r0);
        AppMethodBeat.o(223677);
    }

    private static void K(Runnable runnable) {
        AppMethodBeat.i(223678);
        if (runnable == null) {
            AppMethodBeat.o(223678);
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
            AppMethodBeat.o(223678);
        } else {
            h.RTc.aV(runnable);
            AppMethodBeat.o(223678);
        }
    }

    public static void a(Context context, final Callable<String> callable, final android.support.v4.e.c<String> cVar) {
        AppMethodBeat.i(223679);
        a(context, new android.support.v4.e.c<Boolean>() {
            /* class com.tencent.mm.platformtools.p.AnonymousClass7 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(Boolean bool) {
                AppMethodBeat.i(223663);
                final Boolean bool2 = bool;
                a.h.b(new Callable<Boolean>() {
                    /* class com.tencent.mm.platformtools.p.AnonymousClass7.AnonymousClass3 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // java.util.concurrent.Callable
                    public final /* bridge */ /* synthetic */ Boolean call() {
                        return bool2;
                    }
                }).a(new f<Boolean, String>() {
                    /* class com.tencent.mm.platformtools.p.AnonymousClass7.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [a.h] */
                    @Override // a.f
                    public final /* synthetic */ String a(a.h<Boolean> hVar) {
                        AppMethodBeat.i(223662);
                        if (hVar.getResult().booleanValue()) {
                            String str = (String) callable.call();
                            AppMethodBeat.o(223662);
                            return str;
                        }
                        AppMethodBeat.o(223662);
                        return null;
                    }
                }, p.blt()).a(new f<String, Void>() {
                    /* class com.tencent.mm.platformtools.p.AnonymousClass7.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [a.h] */
                    @Override // a.f
                    public final /* synthetic */ Void a(a.h<String> hVar) {
                        AppMethodBeat.i(223661);
                        cVar.accept(hVar.getResult());
                        AppMethodBeat.o(223661);
                        return null;
                    }
                }, a.h.aBO);
                AppMethodBeat.o(223663);
            }
        });
        AppMethodBeat.o(223679);
    }

    private static String Sl(String str) {
        AppMethodBeat.i(223680);
        String akC = s.akC(str);
        if (Util.isNullOrNil(akC) || akC.equalsIgnoreCase("pic")) {
            akC = "jpg";
        }
        String exportImagePath = AndroidMediaUtil.getExportImagePath(akC);
        AppMethodBeat.o(223680);
        return exportImagePath;
    }

    public static void a(final Context context, final String str, final a aVar) {
        AppMethodBeat.i(223681);
        final String Sl = Sl(str);
        s.boN(s.boZ(Sl));
        Log.i("MicroMsg.ExportFileUtil", "[+] Called exportImageWithPermissionRequest, src: %s, dest: %s", str, Sl);
        a(context, new Callable<String>() {
            /* class com.tencent.mm.platformtools.p.AnonymousClass8 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ String call() {
                AppMethodBeat.i(223664);
                String J = p.J(context, str);
                AppMethodBeat.o(223664);
                return J;
            }
        }, new android.support.v4.e.c<String>() {
            /* class com.tencent.mm.platformtools.p.AnonymousClass9 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(String str) {
                AppMethodBeat.i(223665);
                String str2 = str;
                if (aVar != null) {
                    if (!TextUtils.isEmpty(str2)) {
                        aVar.bP(str, str2);
                        AppMethodBeat.o(223665);
                        return;
                    }
                    aVar.bQ(str, Sl);
                }
                AppMethodBeat.o(223665);
            }
        });
        AppMethodBeat.o(223681);
    }

    public static String J(Context context, String str) {
        AppMethodBeat.i(223682);
        Log.i("MicroMsg.ExportFileUtil", "[+] Called exportImage, src: %s", str);
        String K = K(context, str);
        AppMethodBeat.o(223682);
        return K;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d0, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d1, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.ExportFileUtil", r6, "rotate img failed.", new java.lang.Object[0]);
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ea, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e9 A[ExcHandler: all (r0v6 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:18:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String K(android.content.Context r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.p.K(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004b A[Catch:{ Throwable -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String L(android.content.Context r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.p.L(android.content.Context, java.lang.String):java.lang.String");
    }

    private static String Sm(String str) {
        AppMethodBeat.i(223686);
        String z = aa.z(new o(com.tencent.mm.loader.j.b.aLH(), new o(str).getName()).her());
        AppMethodBeat.o(223686);
        return z;
    }

    public static void c(final Context context, final String str, final a aVar) {
        AppMethodBeat.i(223687);
        final String Sm = Sm(str);
        s.boN(s.boZ(Sm));
        Log.i("MicroMsg.ExportFileUtil", "[+] Called exportToPublicDownloadDirWithPermissionRequest, src: %s, dest: %s", str, Sm);
        a(context, new Callable<String>() {
            /* class com.tencent.mm.platformtools.p.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ String call() {
                AppMethodBeat.i(223654);
                String M = p.M(context, str);
                AppMethodBeat.o(223654);
                return M;
            }
        }, new android.support.v4.e.c<String>() {
            /* class com.tencent.mm.platformtools.p.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(String str) {
                AppMethodBeat.i(223655);
                String str2 = str;
                if (aVar != null) {
                    if (!TextUtils.isEmpty(str2)) {
                        aVar.bP(str, str2);
                        AppMethodBeat.o(223655);
                        return;
                    }
                    aVar.bQ(str, Sm);
                }
                AppMethodBeat.o(223655);
            }
        });
        AppMethodBeat.o(223687);
    }

    public static String M(Context context, String str) {
        AppMethodBeat.i(223688);
        String N = N(context, str);
        AppMethodBeat.o(223688);
        return N;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0077 A[SYNTHETIC, Splitter:B:13:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String N(android.content.Context r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 237
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.p.N(android.content.Context, java.lang.String):java.lang.String");
    }

    static abstract class c implements PermissionHelper.e, PermissionHelper.f {
        private String jMY = null;
        private final WeakReference<Context> mContextRef;

        /* access modifiers changed from: protected */
        public abstract void blu();

        /* access modifiers changed from: protected */
        public abstract void blv();

        c(Context context) {
            this.mContextRef = new WeakReference<>(context);
        }

        @Override // com.tencent.mm.pluginsdk.permission.PermissionHelper.e
        public final void Sn(String str) {
            this.jMY = str;
            blu();
        }

        @Override // com.tencent.mm.pluginsdk.permission.PermissionHelper.e
        public final void a(final PermissionHelper.c cVar, String str) {
            this.jMY = str;
            Context context = this.mContextRef.get();
            if (context == null) {
                Log.e("MicroMsg.ExportFileUtil", "[-] context is recycled, skip rest steps.");
                return;
            }
            com.tencent.mm.ui.base.h.a(context, context.getString(R.string.c2y), context.getString(R.string.flp), context.getString(R.string.e_k), context.getString(R.string.fl1), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.platformtools.p.c.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(223673);
                    dialogInterface.dismiss();
                    cVar.a(c.this);
                    AppMethodBeat.o(223673);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.platformtools.p.c.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(223674);
                    dialogInterface.dismiss();
                    c.this.blv();
                    AppMethodBeat.o(223674);
                }
            });
        }

        @Override // com.tencent.mm.pluginsdk.permission.PermissionHelper.f
        public final void blw() {
            if (PermissionHelper.bdR(this.jMY)) {
                blu();
            } else {
                blv();
            }
        }

        @Override // com.tencent.mm.pluginsdk.permission.PermissionHelper.f
        public final void blx() {
            blv();
        }
    }

    public static final class b {
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0149, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(223668);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0150, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0151, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0152, code lost:
            r4 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0153, code lost:
            if (r6 != null) goto L_0x0155;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0155, code lost:
            if (r4 != null) goto L_0x0157;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            r6.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x015a, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(223668);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0160, code lost:
            throw r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0180, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0181, code lost:
            r3 = r2;
            r4 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0188, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0189, code lost:
            r4.addSuppressed(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x018d, code lost:
            r6.close();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x013f A[SYNTHETIC, Splitter:B:50:0x013f] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0155  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0165  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0180 A[ExcHandler: all (r2v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:35:0x011e] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0184  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static android.net.Uri a(android.content.Context r8, java.lang.String r9, java.lang.String r10, android.net.Uri r11) {
            /*
            // Method dump skipped, instructions count: 416
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.p.b.a(android.content.Context, java.lang.String, java.lang.String, android.net.Uri):android.net.Uri");
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x012f  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0151  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String h(android.content.Context r9, android.net.Uri r10) {
            /*
            // Method dump skipped, instructions count: 368
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.p.b.h(android.content.Context, android.net.Uri):java.lang.String");
        }

        public static Uri O(Context context, String str) {
            AppMethodBeat.i(223670);
            Uri a2 = a(context, str, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            AppMethodBeat.o(223670);
            return a2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static android.net.Uri a(android.content.Context r9, java.lang.String r10, android.net.Uri r11) {
            /*
            // Method dump skipped, instructions count: 214
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.p.b.a(android.content.Context, java.lang.String, android.net.Uri):android.net.Uri");
        }

        public static Uri P(Context context, String str) {
            AppMethodBeat.i(223671);
            Uri a2 = a(context, str, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            if (a2 == null) {
                a2 = O(context, str);
            }
            AppMethodBeat.o(223671);
            return a2;
        }
    }

    public static void b(final Context context, final String str, final a aVar) {
        AppMethodBeat.i(223684);
        final String exportImagePath = AndroidMediaUtil.getExportImagePath("mp4");
        s.boN(s.boZ(exportImagePath));
        Log.i("MicroMsg.ExportFileUtil", "[+] Called exportVideoWithPermissionRequest, src: %s, dest: %s", str, exportImagePath);
        a(context, new Callable<String>() {
            /* class com.tencent.mm.platformtools.p.AnonymousClass10 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ String call() {
                AppMethodBeat.i(223666);
                String L = p.L(context, str);
                AppMethodBeat.o(223666);
                return L;
            }
        }, new android.support.v4.e.c<String>() {
            /* class com.tencent.mm.platformtools.p.AnonymousClass11 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(String str) {
                AppMethodBeat.i(223667);
                String str2 = str;
                if (aVar != null) {
                    if (!TextUtils.isEmpty(str2)) {
                        aVar.bP(str, str2);
                        AppMethodBeat.o(223667);
                        return;
                    }
                    aVar.bQ(str, exportImagePath);
                }
                AppMethodBeat.o(223667);
            }
        });
        AppMethodBeat.o(223684);
    }

    static /* synthetic */ Executor blt() {
        return jMN != null ? jMN : a.h.aBO;
    }
}
