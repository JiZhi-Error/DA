package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.launching.z;
import com.tencent.mm.plugin.appbrand.p.e;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;

public final class ModularizingPkgRetrieverWC implements e, com.tencent.mm.vending.e.a {
    final LoadParams mWs;
    volatile e.a mWt;
    transient com.tencent.mm.plugin.appbrand.jsapi.q.a mWu;

    /* synthetic */ ModularizingPkgRetrieverWC(String str, int i2, int i3, String str2, byte b2) {
        this(str, i2, i3, str2);
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        this.mWt = null;
    }

    private ModularizingPkgRetrieverWC(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(47305);
        this.mWu = new com.tencent.mm.plugin.appbrand.jsapi.q.a();
        this.mWs = new LoadParams(str, i2, i3, str2, b.aeU(str), (byte) 0);
        AppMethodBeat.o(47305);
    }

    @Override // com.tencent.mm.plugin.appbrand.p.e
    public final void start() {
        AppMethodBeat.i(47306);
        Log.i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "startLoad %s", this.mWs.toString());
        this.mWu.setName("loadPackage");
        this.mWu.startTime = Util.nowMilliSecond();
        this.mWu.r(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, this.mWs.cBp);
        XIPCInvoker.a(MainProcessIPCService.dkO, this.mWs, a.class, new d<WxaPkgResultProgressPair>() {
            /* class com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(WxaPkgResultProgressPair wxaPkgResultProgressPair) {
                AppMethodBeat.i(47288);
                WxaPkgResultProgressPair wxaPkgResultProgressPair2 = wxaPkgResultProgressPair;
                try {
                    switch (AnonymousClass3.mWy[wxaPkgResultProgressPair2.mWC.ordinal()]) {
                        case 1:
                            WxaPkgWrappingInfo wxaPkgWrappingInfo = wxaPkgResultProgressPair2.mWA;
                            String str = wxaPkgWrappingInfo == null ? null : wxaPkgWrappingInfo.pkgPath;
                            Log.i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "onFinish, input = %s, result = %s", ModularizingPkgRetrieverWC.this.mWs.toString(), str);
                            e.a aVar = ModularizingPkgRetrieverWC.this.mWt;
                            if (aVar != null) {
                                aVar.YR(str);
                            }
                            ModularizingPkgRetrieverWC.this.mWu.endTime = Util.nowMilliSecond();
                            ModularizingPkgRetrieverWC.this.mWu.r("size", Long.valueOf(wxaPkgWrappingInfo == null ? 0 : s.boW(wxaPkgWrappingInfo.pkgPath)));
                            try {
                                ModularizingPkgRetrieverWC.this.mWu.d(b.aeU(ModularizingPkgRetrieverWC.this.mWs.appId).kGW.bsE());
                                AppMethodBeat.o(47288);
                                return;
                            } catch (Exception e2) {
                                AppMethodBeat.o(47288);
                                return;
                            }
                        case 2:
                            WxaPkgLoadProgress wxaPkgLoadProgress = wxaPkgResultProgressPair2.mWB;
                            e.a aVar2 = ModularizingPkgRetrieverWC.this.mWt;
                            if (wxaPkgLoadProgress == null || aVar2 == null) {
                                Log.e("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "hy: non progress info! should not happen");
                                break;
                            } else {
                                aVar2.a(wxaPkgLoadProgress);
                                AppMethodBeat.o(47288);
                                return;
                            }
                    }
                    AppMethodBeat.o(47288);
                } catch (NullPointerException e3) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(47287);
                            NullPointerException nullPointerException = e3;
                            AppMethodBeat.o(47287);
                            throw nullPointerException;
                        }
                    });
                    AppMethodBeat.o(47288);
                }
            }
        });
        AppMethodBeat.o(47306);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] mWy = new int[WxaPkgResultProgressPair.a.values().length];

        static {
            AppMethodBeat.i(47289);
            try {
                mWy[WxaPkgResultProgressPair.a.Finish.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mWy[WxaPkgResultProgressPair.a.Progressing.ordinal()] = 2;
                AppMethodBeat.o(47289);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(47289);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.p.e
    public final void a(e.a aVar) {
        this.mWt = aVar;
    }

    static final class LoadParams implements Parcelable {
        public static final Parcelable.Creator<LoadParams> CREATOR = new Parcelable.Creator<LoadParams>() {
            /* class com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.LoadParams.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ LoadParams[] newArray(int i2) {
                return new LoadParams[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ LoadParams createFromParcel(Parcel parcel) {
                AppMethodBeat.i(47293);
                LoadParams loadParams = new LoadParams(parcel);
                AppMethodBeat.o(47293);
                return loadParams;
            }
        };
        public final String appId;
        public final String cBp;
        public final int dMe;
        public final QualitySession mUY;
        public final int pkgVersion;

        /* synthetic */ LoadParams(String str, int i2, int i3, String str2, QualitySession qualitySession, byte b2) {
            this(str, i2, i3, str2, qualitySession);
        }

        private LoadParams(String str, int i2, int i3, String str2, QualitySession qualitySession) {
            this.appId = str;
            this.dMe = i2;
            this.pkgVersion = i3;
            this.cBp = str2;
            this.mUY = qualitySession;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(47294);
            parcel.writeString(this.appId);
            parcel.writeInt(this.dMe);
            parcel.writeInt(this.pkgVersion);
            parcel.writeString(this.cBp);
            parcel.writeParcelable(this.mUY, i2);
            AppMethodBeat.o(47294);
        }

        LoadParams(Parcel parcel) {
            AppMethodBeat.i(47295);
            this.appId = parcel.readString();
            this.dMe = parcel.readInt();
            this.pkgVersion = parcel.readInt();
            this.cBp = parcel.readString();
            this.mUY = (QualitySession) parcel.readParcelable(QualitySession.class.getClassLoader());
            AppMethodBeat.o(47295);
        }

        static {
            AppMethodBeat.i(47297);
            AppMethodBeat.o(47297);
        }

        public final String toString() {
            AppMethodBeat.i(47296);
            String str = "LoadParams{appId='" + this.appId + '\'' + ", pkgType=" + this.dMe + ", pkgVersion=" + this.pkgVersion + ", moduleName='" + this.cBp + '\'' + '}';
            AppMethodBeat.o(47296);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class WxaPkgResultProgressPair implements Parcelable {
        public static final Parcelable.Creator<WxaPkgResultProgressPair> CREATOR = new Parcelable.Creator<WxaPkgResultProgressPair>() {
            /* class com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.WxaPkgResultProgressPair.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WxaPkgResultProgressPair[] newArray(int i2) {
                return new WxaPkgResultProgressPair[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WxaPkgResultProgressPair createFromParcel(Parcel parcel) {
                AppMethodBeat.i(47298);
                WxaPkgResultProgressPair wxaPkgResultProgressPair = new WxaPkgResultProgressPair(parcel);
                AppMethodBeat.o(47298);
                return wxaPkgResultProgressPair;
            }
        };
        WxaPkgWrappingInfo mWA;
        WxaPkgLoadProgress mWB;
        private a mWC;

        WxaPkgResultProgressPair(Parcel parcel) {
            AppMethodBeat.i(47302);
            this.mWA = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
            this.mWB = (WxaPkgLoadProgress) parcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader());
            this.mWC = (a) parcel.readSerializable();
            AppMethodBeat.o(47302);
        }

        static {
            AppMethodBeat.i(47304);
            AppMethodBeat.o(47304);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(47303);
            parcel.writeParcelable(this.mWA, i2);
            parcel.writeParcelable(this.mWB, i2);
            parcel.writeSerializable(this.mWC);
            AppMethodBeat.o(47303);
        }

        /* access modifiers changed from: package-private */
        public enum a {
            Finish,
            Progressing;

            public static a valueOf(String str) {
                AppMethodBeat.i(47300);
                a aVar = (a) Enum.valueOf(a.class, str);
                AppMethodBeat.o(47300);
                return aVar;
            }

            static {
                AppMethodBeat.i(47301);
                AppMethodBeat.o(47301);
            }
        }

        WxaPkgResultProgressPair(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            this.mWA = wxaPkgWrappingInfo;
            this.mWC = a.Finish;
        }

        WxaPkgResultProgressPair(WxaPkgLoadProgress wxaPkgLoadProgress) {
            this.mWB = wxaPkgLoadProgress;
            this.mWC = a.Progressing;
        }
    }

    static final class a implements com.tencent.mm.ipcinvoker.b<LoadParams, WxaPkgResultProgressPair> {
        private d<WxaPkgResultProgressPair> hnd = null;

        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(LoadParams loadParams, d<WxaPkgResultProgressPair> dVar) {
            z aiVar;
            AppMethodBeat.i(47292);
            LoadParams loadParams2 = loadParams;
            this.hnd = dVar;
            String str = loadParams2.appId;
            String str2 = loadParams2.cBp;
            int i2 = loadParams2.dMe;
            int i3 = loadParams2.pkgVersion;
            if (j.a.vP(i2)) {
                aiVar = new ah(str, str2, i3);
            } else {
                aiVar = new ai(str, str2, i2);
            }
            aiVar.a(new z.b() {
                /* class com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.launching.z.b
                public final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    AppMethodBeat.i(47290);
                    if (a.this.hnd != null) {
                        a.this.hnd.bn(new WxaPkgResultProgressPair(wxaPkgWrappingInfo));
                        a.this.hnd = null;
                    }
                    AppMethodBeat.o(47290);
                }
            });
            aiVar.a(new z.a() {
                /* class com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC.a.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.launching.z.a
                public final void a(WxaPkgLoadProgress wxaPkgLoadProgress) {
                    AppMethodBeat.i(47291);
                    Log.i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "hy: prepare job progress callback, %s", wxaPkgLoadProgress.toString());
                    if (a.this.hnd != null) {
                        a.this.hnd.bn(new WxaPkgResultProgressPair(wxaPkgLoadProgress));
                    }
                    AppMethodBeat.o(47291);
                }
            });
            if (loadParams2.mUY != null) {
                aiVar.a(loadParams2.mUY);
            }
            aiVar.prepareAsync();
            AppMethodBeat.o(47292);
        }
    }
}
