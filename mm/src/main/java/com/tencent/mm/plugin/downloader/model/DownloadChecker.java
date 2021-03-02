package com.tencent.mm.plugin.downloader.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a.a.j;
import com.tencent.mm.plugin.downloader.c.a.a.k;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class DownloadChecker {
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cf, code lost:
        r1 = r5.group();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.DownloadChecker", "match the regex: %s", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e2, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0118, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0119, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(final java.lang.String r10, java.lang.String r11, com.tencent.xweb.WebView r12) {
        /*
        // Method dump skipped, instructions count: 284
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.downloader.model.DownloadChecker.a(java.lang.String, java.lang.String, com.tencent.xweb.WebView):boolean");
    }

    /* access modifiers changed from: package-private */
    public static class b implements com.tencent.mm.ipcinvoker.b<Bundle, DownloadInterceptBean> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<DownloadInterceptBean> dVar) {
            AppMethodBeat.i(88899);
            Bundle bundle2 = bundle;
            DownloadInterceptBean downloadInterceptBean = new DownloadInterceptBean();
            if (bundle2 == null) {
                downloadInterceptBean.result = false;
                if (dVar != null) {
                    dVar.bn(downloadInterceptBean);
                }
                AppMethodBeat.o(88899);
                return;
            }
            String string = bundle2.getString("download_url");
            String string2 = bundle2.getString("main_url");
            String string3 = bundle2.getString("scene");
            if (!Util.isNullOrNil(string)) {
                j jVar = new j();
                jVar.gqB = string;
                jVar.qFZ = string2;
                jVar.source = string3;
                d.a aVar = new d.a();
                aVar.iLN = jVar;
                aVar.iLO = new k();
                aVar.uri = "/cgi-bin/mmgame-bin/getdownloadinterceptinfo";
                aVar.funcId = 2884;
                aa.a(aVar.aXF(), new aa.a(string, string2, string3, dVar) {
                    /* class com.tencent.mm.plugin.downloader.model.DownloadChecker.AnonymousClass2 */
                    final /* synthetic */ String dnN;
                    final /* synthetic */ String qHM;
                    final /* synthetic */ com.tencent.mm.ipcinvoker.d val$callback;
                    final /* synthetic */ String val$downloadUrl;

                    {
                        this.val$downloadUrl = r1;
                        this.qHM = r2;
                        this.dnN = r3;
                        this.val$callback = r4;
                    }

                    @Override // com.tencent.mm.ak.aa.a
                    public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                        String str2;
                        AppMethodBeat.i(88892);
                        Log.i("MicroMsg.DownloadChecker", "errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        DownloadInterceptBean downloadInterceptBean = new DownloadInterceptBean();
                        if (i2 == 0 && i3 == 0) {
                            k kVar = (k) dVar.iLL.iLR;
                            if (kVar != null) {
                                int i4 = kVar.qGa;
                                String str3 = kVar.qGb;
                                com.tencent.mm.plugin.downloader.c.a.a.d dVar2 = kVar.qFW;
                                if (DownloadInterceptBean.a(dVar2)) {
                                    downloadInterceptBean.result = true;
                                    downloadInterceptBean.qHN = i4;
                                    downloadInterceptBean.qHO = str3;
                                    downloadInterceptBean.appId = dVar2.qFP.qGY == null ? null : dVar2.qFP.qGY.dNI;
                                    downloadInterceptBean.appName = dVar2.qFP.qGY == null ? null : dVar2.qFP.qGY.qGA;
                                    if (dVar2.qFP.qGY == null) {
                                        str2 = null;
                                    } else {
                                        str2 = dVar2.qFP.qGY.qGB;
                                    }
                                    downloadInterceptBean.iconUrl = str2;
                                    downloadInterceptBean.downloadUrl = dVar2.qFP.qHa.qGP.gqB;
                                    downloadInterceptBean.qHP = dVar2.qFP.qHa.qGP.qGw;
                                    downloadInterceptBean.size = dVar2.qFP.qHa.qGP.qGq;
                                    downloadInterceptBean.packageName = dVar2.qFP.qHa.qGP.qGp;
                                    downloadInterceptBean.md5 = dVar2.qFP.qHa.qGP.qGr;
                                    downloadInterceptBean.dNv = dVar2.qFP.qHa.qGP.qGs;
                                    downloadInterceptBean.qHQ = dVar2.qFP.qHa.qGT;
                                    downloadInterceptBean.qHS = new com.tencent.mm.plugin.downloader.c.b.q();
                                    downloadInterceptBean.qHS.qGz = dVar2.qFP.qHa.qGP.qGz;
                                } else {
                                    downloadInterceptBean.result = false;
                                }
                                Log.i("MicroMsg.DownloadChecker", "check download from net, ret: %d, confirmType: %d, appid: %s", Integer.valueOf(kVar.pTZ), Integer.valueOf(kVar.qGa), downloadInterceptBean.appId);
                                if (kVar.pTZ != 0) {
                                    downloadInterceptBean.result = false;
                                } else if (!downloadInterceptBean.result) {
                                    kVar.pTZ = c.qHX;
                                }
                                c.a(downloadInterceptBean.appId, this.val$downloadUrl, downloadInterceptBean.downloadUrl, String.valueOf(kVar.pTZ), this.qHM, this.dnN, String.valueOf(kVar.qGa));
                            } else {
                                downloadInterceptBean.result = false;
                            }
                        } else {
                            downloadInterceptBean.result = false;
                        }
                        if (this.val$callback != null) {
                            this.val$callback.bn(downloadInterceptBean);
                        }
                        AppMethodBeat.o(88892);
                        return 0;
                    }
                });
                AppMethodBeat.o(88899);
                return;
            }
            downloadInterceptBean.result = false;
            if (dVar != null) {
                dVar.bn(downloadInterceptBean);
            }
            AppMethodBeat.o(88899);
        }
    }

    static class a implements com.tencent.mm.ipcinvoker.b<DownloadInterceptBean, IPCLong> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(DownloadInterceptBean downloadInterceptBean, com.tencent.mm.ipcinvoker.d<IPCLong> dVar) {
            AppMethodBeat.i(192255);
            DownloadInterceptBean downloadInterceptBean2 = downloadInterceptBean;
            IPCLong iPCLong = new IPCLong();
            iPCLong.value = -1;
            if (downloadInterceptBean2 == null) {
                if (dVar != null) {
                    dVar.bn(iPCLong);
                }
                AppMethodBeat.o(192255);
                return;
            }
            if (downloadInterceptBean2.qHQ) {
                com.tencent.mm.plugin.downloader_app.a.a aVar = new com.tencent.mm.plugin.downloader_app.a.a();
                aVar.downloadUrl = downloadInterceptBean2.downloadUrl;
                aVar.qKt = downloadInterceptBean2.qHP;
                aVar.appId = downloadInterceptBean2.appId;
                aVar.appName = downloadInterceptBean2.appName;
                aVar.packageName = downloadInterceptBean2.packageName;
                aVar.qKv = downloadInterceptBean2.size;
                aVar.mYc = downloadInterceptBean2.md5;
                aVar.fileType = 1;
                aVar.scene = 8070;
                aVar.dNv = downloadInterceptBean2.dNv;
                aVar.qKz = downloadInterceptBean2.qHS.qGz;
                iPCLong.value = ((com.tencent.mm.plugin.downloader_app.api.c) g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(aVar, null);
            } else {
                g.a aVar2 = new g.a();
                aVar2.alj(downloadInterceptBean2.downloadUrl);
                aVar2.alk(downloadInterceptBean2.qHP);
                aVar2.setAppId(downloadInterceptBean2.appId);
                aVar2.setFileSize(downloadInterceptBean2.size);
                aVar2.gm(downloadInterceptBean2.packageName);
                aVar2.all(h.a(MMApplicationContext.getContext(), h.o(downloadInterceptBean2.appId, true, false), (String) null));
                aVar2.setFileMD5(downloadInterceptBean2.md5);
                aVar2.kS(true);
                aVar2.kT(true);
                aVar2.Fl(1);
                aVar2.setScene(8070);
                aVar2.V(downloadInterceptBean2.qHS.qGz);
                if (downloadInterceptBean2.dNv == 1) {
                    iPCLong.value = f.cBv().b(aVar2.qIY);
                } else {
                    iPCLong.value = f.cBv().a(aVar2.qIY);
                }
            }
            Log.i("MicroMsg.DownloadChecker", " add download task result:[%d], appid[%s]，downloaerType[%d]", Long.valueOf(iPCLong.value), downloadInterceptBean2.appId, Integer.valueOf(downloadInterceptBean2.dNv));
            if (dVar != null) {
                dVar.bn(iPCLong);
            }
            AppMethodBeat.o(192255);
        }
    }

    static class DownloadInterceptBean implements Parcelable {
        public static final Parcelable.Creator<DownloadInterceptBean> CREATOR = new Parcelable.Creator<DownloadInterceptBean>() {
            /* class com.tencent.mm.plugin.downloader.model.DownloadChecker.DownloadInterceptBean.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ DownloadInterceptBean[] newArray(int i2) {
                return new DownloadInterceptBean[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DownloadInterceptBean createFromParcel(Parcel parcel) {
                AppMethodBeat.i(88893);
                DownloadInterceptBean downloadInterceptBean = new DownloadInterceptBean(parcel, (byte) 0);
                AppMethodBeat.o(88893);
                return downloadInterceptBean;
            }
        };
        public String appId;
        public String appName;
        public int dNv;
        public String downloadUrl;
        public String iconUrl;
        public String md5;
        public String packageName;
        public int qHN;
        public String qHO;
        public String qHP;
        public boolean qHQ;
        public int qHR;
        public com.tencent.mm.plugin.downloader.c.b.q qHS;
        public boolean result;
        public long size;

        /* synthetic */ DownloadInterceptBean(Parcel parcel, byte b2) {
            this(parcel);
        }

        public DownloadInterceptBean() {
        }

        private DownloadInterceptBean(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(88894);
            this.result = parcel.readByte() != 0;
            this.qHN = parcel.readInt();
            this.qHO = parcel.readString();
            this.appId = parcel.readString();
            this.appName = parcel.readString();
            this.iconUrl = parcel.readString();
            this.downloadUrl = parcel.readString();
            this.qHP = parcel.readString();
            this.size = parcel.readLong();
            this.packageName = parcel.readString();
            this.md5 = parcel.readString();
            this.dNv = parcel.readInt();
            this.qHQ = parcel.readInt() != 1 ? false : z;
            this.qHR = parcel.readInt();
            this.qHS = new com.tencent.mm.plugin.downloader.c.b.q();
            try {
                byte[] bArr = new byte[this.qHR];
                parcel.readByteArray(bArr);
                this.qHS.parseFrom(bArr);
                AppMethodBeat.o(88894);
            } catch (IOException e2) {
                AppMethodBeat.o(88894);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int i3 = 1;
            AppMethodBeat.i(88895);
            parcel.writeByte((byte) (this.result ? 1 : 0));
            parcel.writeInt(this.qHN);
            parcel.writeString(this.qHO);
            parcel.writeString(this.appId);
            parcel.writeString(this.appName);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.downloadUrl);
            parcel.writeString(this.qHP);
            parcel.writeLong(this.size);
            parcel.writeString(this.packageName);
            parcel.writeString(this.md5);
            parcel.writeInt(this.dNv);
            if (!this.qHQ) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            try {
                if (this.qHS != null) {
                    parcel.writeInt(this.qHS.toByteArray().length);
                    parcel.writeByteArray(this.qHS.toByteArray());
                }
                AppMethodBeat.o(88895);
            } catch (IOException e2) {
                AppMethodBeat.o(88895);
            }
        }

        static {
            AppMethodBeat.i(88897);
            AppMethodBeat.o(88897);
        }

        static boolean a(com.tencent.mm.plugin.downloader.c.a.a.d dVar) {
            AppMethodBeat.i(88896);
            if (dVar == null || dVar.qFP == null || dVar.qFP.qHa == null || dVar.qFP.qHa.qGP == null || !URLUtil.isNetworkUrl(dVar.qFP.qHa.qGP.gqB)) {
                Log.i("MicroMsg.DownloadChecker", "downloadInfo is invalid");
                AppMethodBeat.o(88896);
                return false;
            }
            AppMethodBeat.o(88896);
            return true;
        }
    }

    static class c {
        static int qHT = -2018122700;
        static int qHU = -2018122701;
        static int qHV = -2018122702;
        static int qHW = -2018122703;
        static int qHX = -2018122750;

        static /* synthetic */ void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            String str8;
            String str9;
            AppMethodBeat.i(88900);
            Log.i("MicroMsg.DownloadChecker", "reportInfo, appId:[ %s ], rawDownloadUrl:[ %s ], alterDownloadUrl:[ %s ], errCode:[ %s ], mainUrl:[ %s ], source:[ %s ], confirmType:[ %s ]", str, str2, str3, str4, str5, str6, str7);
            try {
                if (!Util.isNullOrNil(str2)) {
                    str9 = URLEncoder.encode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } else {
                    str9 = str2;
                }
                try {
                    if (!Util.isNullOrNil(str3)) {
                        str8 = URLEncoder.encode(str3, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    } else {
                        str8 = str3;
                    }
                    try {
                        if (!Util.isNullOrNil(str5)) {
                            str5 = URLEncoder.encode(str5, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        }
                    } catch (UnsupportedEncodingException e2) {
                    }
                } catch (UnsupportedEncodingException e3) {
                    str8 = str3;
                }
            } catch (UnsupportedEncodingException e4) {
                str8 = str3;
                str9 = str2;
            }
            com.tencent.mm.game.report.api.b e5 = com.tencent.mm.game.report.api.b.e(16749, str, str9, str8, str4, str5, str6, str7);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(e5.hhs, e5.hht, true, false);
            AppMethodBeat.o(88900);
        }
    }
}
