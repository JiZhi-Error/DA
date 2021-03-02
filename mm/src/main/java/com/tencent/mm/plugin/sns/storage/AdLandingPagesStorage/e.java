package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class e {
    public static void a(final String str, final String str2, boolean z, final int i2, int i3, final f.a aVar) {
        AppMethodBeat.i(203153);
        if (Util.isNullOrNil(str2)) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(97298);
                    if (aVar != null) {
                        aVar.eWO();
                    }
                    AppMethodBeat.o(97298);
                }
            });
            AppMethodBeat.o(203153);
        } else if (s.YS(str2)) {
            Log.i("MicroMsg.AdLandingPageDownloadFileHelper", "small file %s is already exists", str2);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(97291);
                    if (aVar != null) {
                        aVar.aNH(str2);
                    }
                    AppMethodBeat.o(97291);
                }
            });
            AppMethodBeat.o(203153);
        } else {
            new f(str, str2, z, i2, i3, new f.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWN() {
                    AppMethodBeat.i(97295);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(97292);
                            if (aVar != null) {
                                aVar.eWN();
                            }
                            AppMethodBeat.o(97292);
                        }
                    });
                    AppMethodBeat.o(97295);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void eWO() {
                    AppMethodBeat.i(97296);
                    Log.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for small file %s", str);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.AnonymousClass2.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(97293);
                            if (aVar != null) {
                                aVar.eWO();
                            }
                            AppMethodBeat.o(97293);
                        }
                    });
                    if (i2 == 41) {
                        k.c(1, 0, 0, str);
                    }
                    AppMethodBeat.o(97296);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                public final void aNH(final String str) {
                    AppMethodBeat.i(97297);
                    Log.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for small file %s", str);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.AnonymousClass2.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(97294);
                            if (aVar != null) {
                                aVar.aNH(str);
                            }
                            AppMethodBeat.o(97294);
                        }
                    });
                    if (i2 == 41) {
                        k.c(0, 0, 0, str);
                    }
                    AppMethodBeat.o(97297);
                }
            }).execute(new Void[0]);
            AppMethodBeat.o(203153);
        }
    }

    public static void a(final String str, String str2, String str3, final int i2, final f.a aVar) {
        AppMethodBeat.i(203154);
        final String str4 = str2 + str3;
        if (!Util.isNullOrNil(str4)) {
            if (s.YS(str4)) {
                Log.i("MicroMsg.AdLandingPageDownloadFileHelper", "cdn file %s is already exists", str4);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(97307);
                        aVar.aNH(str4);
                        AppMethodBeat.o(97307);
                    }
                });
                AppMethodBeat.o(203154);
                return;
            }
            new d(str, str2, str3, i2, new d.a() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.AnonymousClass8 */

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a
                public final void eWO() {
                    AppMethodBeat.i(97310);
                    Log.i("MicroMsg.AdLandingPageDownloadFileHelper", " download error for cdn file %s", str);
                    aVar.eWO();
                    if (i2 == 0) {
                        k.c(1, 1, 1, str);
                    }
                    AppMethodBeat.o(97310);
                }

                @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a
                public final void aNH(String str) {
                    AppMethodBeat.i(97311);
                    Log.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for cdn file %s, path %s", str, str);
                    aVar.aNH(str4);
                    if (i2 == 0) {
                        k.c(0, 1, 1, str);
                    }
                    AppMethodBeat.o(97311);
                }
            }).execute(new Void[0]);
        }
        AppMethodBeat.o(203154);
    }
}
