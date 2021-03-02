package com.tencent.mm.plugin.sns.ad.c;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;

public final class b {

    public interface a {
        void b(String str, int i2, Object obj);
    }

    /* renamed from: com.tencent.mm.plugin.sns.ad.c.b$b  reason: collision with other inner class name */
    static abstract class AbstractC1703b {
        protected final String Dsr;
        protected final int Dss;
        protected final a Dst;

        public AbstractC1703b(String str, int i2, a aVar) {
            this.Dsr = str;
            this.Dss = i2;
            this.Dst = aVar;
        }

        /* access modifiers changed from: protected */
        public final void o(final int i2, final Object obj) {
            final a aVar = this.Dst;
            if (aVar != null) {
                try {
                    h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ad.c.b.AbstractC1703b.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(201862);
                            try {
                                Log.d("SnsAd.FinderLivingRequest", "onResult:: snsId = " + AbstractC1703b.this.Dsr + ", action type = " + AbstractC1703b.this.Dss + ", errorCode = " + i2);
                                aVar.b(AbstractC1703b.this.Dsr, i2, obj);
                                AppMethodBeat.o(201862);
                            } catch (Throwable th) {
                                AppMethodBeat.o(201862);
                            }
                        }
                    });
                } catch (Throwable th) {
                }
            }
        }
    }

    static class d extends AbstractC1703b implements af.a<Boolean> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.i.a.af.a
        public final /* synthetic */ void bn(Boolean bool) {
            int i2 = 0;
            AppMethodBeat.i(201864);
            Boolean bool2 = bool;
            if (bool2 == null) {
                try {
                    Log.w("SnsAd.FinderLivingRequest", "the RequestSuccessCallBack value is null");
                } catch (Throwable th) {
                    AppMethodBeat.o(201864);
                    return;
                }
            }
            boolean booleanValue = bool2 == null ? false : bool2.booleanValue();
            if (this.Dss == 1) {
                if (booleanValue) {
                    i2 = 513;
                } else {
                    i2 = CdnLogic.kAppTypeFestivalImage;
                }
            } else if (this.Dss == 3) {
                if (booleanValue) {
                    i2 = 770;
                } else {
                    i2 = 771;
                }
            }
            o(0, Integer.valueOf(i2));
            AppMethodBeat.o(201864);
        }

        public d(String str, int i2, a aVar) {
            super(str, i2, aVar);
        }
    }

    static class c extends AbstractC1703b implements af.a<Integer> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.i.a.af.a
        public final /* synthetic */ void bn(Integer num) {
            int i2 = -1;
            AppMethodBeat.i(201863);
            Integer num2 = num;
            int intValue = num2 == null ? -1 : num2.intValue();
            if (intValue != 0) {
                i2 = intValue;
            }
            try {
                o(i2, null);
                AppMethodBeat.o(201863);
            } catch (Throwable th) {
                AppMethodBeat.o(201863);
            }
        }

        public c(String str, int i2, a aVar) {
            super(str, i2, aVar);
        }
    }

    static class e extends AbstractC1703b implements af.a<Void> {
        e(String str, int i2, a aVar) {
            super(str, i2, aVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.i.a.af.a
        public final /* synthetic */ void bn(Void r4) {
            AppMethodBeat.i(201865);
            try {
                o(0, null);
                AppMethodBeat.o(201865);
            } catch (Throwable th) {
                AppMethodBeat.o(201865);
            }
        }
    }

    public static void a(String str, String str2, String str3, a aVar) {
        AppMethodBeat.i(201866);
        try {
            af finderUtilApi = getFinderUtilApi();
            if (finderUtilApi == null) {
                Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in requestLivingNoticeState, is there something wrong in wechat??!!");
                AppMethodBeat.o(201866);
                return;
            }
            finderUtilApi.a(str2, str3, new d(str, 1, aVar), new c(str, 1, aVar));
            AppMethodBeat.o(201866);
        } catch (Throwable th) {
            Log.e("SnsAd.FinderLivingRequest", "requestLivingNoticeState is failed: sns id = ".concat(String.valueOf(str)));
            AppMethodBeat.o(201866);
        }
    }

    public static void a(String str, String str2, a aVar) {
        AppMethodBeat.i(201867);
        try {
            af finderUtilApi = getFinderUtilApi();
            if (finderUtilApi == null) {
                Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in requestLivingState, is there something wrong in wechat??!!");
                AppMethodBeat.o(201867);
                return;
            }
            d dVar = new d(str, 3, aVar);
            new c(str, 3, aVar);
            long safeParseLong = Util.safeParseLong(str2);
            if (safeParseLong != 0) {
                finderUtilApi.a(safeParseLong, dVar);
                AppMethodBeat.o(201867);
                return;
            }
            Log.e("SnsAd.FinderLivingRequest", "is the liveId not number in requestLivingState????");
            AppMethodBeat.o(201867);
        } catch (Throwable th) {
            Log.e("SnsAd.FinderLivingRequest", "requestLivingState is failed: sns id = ".concat(String.valueOf(str)));
            AppMethodBeat.o(201867);
        }
    }

    public static void b(String str, String str2, String str3, a aVar) {
        AppMethodBeat.i(201868);
        try {
            af finderUtilApi = getFinderUtilApi();
            if (finderUtilApi == null) {
                Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in subscribeLivingNotice, is there something wrong in wechat??!!");
                AppMethodBeat.o(201868);
                return;
            }
            finderUtilApi.b(str2, str3, new e(str, 2, aVar), new c(str, 2, aVar));
            AppMethodBeat.o(201868);
        } catch (Throwable th) {
            Log.e("SnsAd.FinderLivingRequest", "subscribeLivingNotice is failed: sns id = ".concat(String.valueOf(str)));
            AppMethodBeat.o(201868);
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, a aVar) {
        AppMethodBeat.i(201869);
        try {
            af finderUtilApi = getFinderUtilApi();
            if (finderUtilApi == null) {
                Log.e("SnsAd.FinderLivingRequest", "the IFinderUtilApi is null in showLivingRoom, is there something wrong in wechat??!!");
                AppMethodBeat.o(201869);
                return;
            }
            long safeParseLong = Util.safeParseLong(str2);
            if (safeParseLong != 0) {
                finderUtilApi.a(str, safeParseLong, str3, str4, new e(str5, 4, aVar), new c(str5, 4, aVar));
                AppMethodBeat.o(201869);
                return;
            }
            Log.e("SnsAd.FinderLivingRequest", "is the liveId not number in showLivingRoom????");
            AppMethodBeat.o(201869);
        } catch (Throwable th) {
            AppMethodBeat.o(201869);
        }
    }

    public static void ao(Context context, int i2) {
        AppMethodBeat.i(201870);
        if (context == null) {
            AppMethodBeat.o(201870);
        } else if (i2 == 0) {
            try {
                u.cG(context, context.getString(R.string.h3v));
                AppMethodBeat.o(201870);
            } catch (Throwable th) {
                AppMethodBeat.o(201870);
            }
        } else if (i2 == -200045) {
            u.cH(context, context.getString(R.string.h3t));
            AppMethodBeat.o(201870);
        } else if (i2 == -200023) {
            u.cH(context, context.getString(R.string.h3s));
            AppMethodBeat.o(201870);
        } else {
            u.cH(context, context.getString(R.string.h3u));
            AppMethodBeat.o(201870);
        }
    }

    private static af getFinderUtilApi() {
        AppMethodBeat.i(201871);
        aj ajVar = (aj) g.ah(aj.class);
        if (ajVar != null) {
            af finderUtilApi = ajVar.getFinderUtilApi();
            AppMethodBeat.o(201871);
            return finderUtilApi;
        }
        AppMethodBeat.o(201871);
        return null;
    }
}
