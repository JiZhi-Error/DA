package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cr.a;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.miniutil.MiniReaderLogic;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ui.AppBrandMiniQBDownloadProxyUI;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.xweb.f;
import com.tencent.xweb.util.h;
import java.util.HashMap;

public final class OpenFileRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
    public static final Parcelable.Creator<OpenFileRequest> CREATOR = new Parcelable.Creator<OpenFileRequest>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ OpenFileRequest[] newArray(int i2) {
            return new OpenFileRequest[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OpenFileRequest createFromParcel(Parcel parcel) {
            AppMethodBeat.i(174795);
            OpenFileRequest openFileRequest = new OpenFileRequest(parcel);
            AppMethodBeat.o(174795);
            return openFileRequest;
        }
    };
    public String appId;
    public String filePath;
    public String gCr;
    public boolean lwF;

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
        return a.class;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final String bDO() {
        return "QbDocumentReader";
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final void k(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(174834);
        super.k(parcel);
        this.filePath = parcel.readString();
        this.gCr = parcel.readString();
        this.appId = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.lwF = z;
        AppMethodBeat.o(174834);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(174835);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.filePath);
        parcel.writeString(this.gCr);
        parcel.writeString(this.appId);
        parcel.writeInt(this.lwF ? 1 : 0);
        AppMethodBeat.o(174835);
    }

    public OpenFileRequest() {
    }

    OpenFileRequest(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.i(174836);
        AppMethodBeat.o(174836);
    }

    /* access modifiers changed from: package-private */
    public static final class OpenResult extends AppBrandProxyUIProcessTask.ProcessResult {
        public static final Parcelable.Creator<OpenResult> CREATOR = new Parcelable.Creator<OpenResult>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.OpenResult.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ OpenResult[] newArray(int i2) {
                return new OpenResult[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ OpenResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(174830);
                OpenResult openResult = new OpenResult(parcel);
                AppMethodBeat.o(174830);
                return openResult;
            }
        };
        public int ret;

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult
        public final void k(Parcel parcel) {
            AppMethodBeat.i(174831);
            this.ret = parcel.readInt();
            AppMethodBeat.o(174831);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(174832);
            parcel.writeInt(this.ret);
            AppMethodBeat.o(174832);
        }

        OpenResult() {
        }

        OpenResult(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.i(174833);
            AppMethodBeat.o(174833);
        }
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private static final int lVC = (a.class.hashCode() & 65535);
        private String appId = "";
        private String fileName = "";
        private String filePath = "";
        private String gCr = "";
        private boolean lVD;
        private MiniReaderLogic.a<Integer> lVE = null;
        private boolean lwF;
        private ValueCallback<String> lwJ = new ValueCallback<String>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(226797);
                String str2 = str;
                Log.i("MicroMsg.AppBrand.OpenFileRequest", "openReadFile, receiveValue = %s", str2);
                if ("query for feature_wx_float_window successfully".equals(str2)) {
                    if (a.this.bDL() != null) {
                        a.this.bDL().lwH = true;
                        MiniReaderLogic.a(a.this.bDL().lwE.eqW(), true, (Context) a.j(a.this), a.this.filePath, a.this.fileName, a.this.gCr, a.this.token, (ValueCallback<String>) a.this.lwJ, (ValueCallback<Integer>) a.n(a.this), a.this.appId, a.this.lwF);
                        AppMethodBeat.o(226797);
                        return;
                    }
                } else if ("xwebFileReaderReachEnd".equals(str2)) {
                    Log.d("MicroMsg.AppBrand.OpenFileRequest", "xweb file reader reach end");
                    AppMethodBeat.o(226797);
                    return;
                } else if ("xwebFileReaderUserOperated".equals(str2)) {
                    Log.d("MicroMsg.AppBrand.OpenFileRequest", "xweb file reader user operated");
                    AppMethodBeat.o(226797);
                    return;
                } else if (!"fileReaderClosed".equals(str2) || a.q(a.this)) {
                    if ("fileReaderMenuClicked".equals(str2)) {
                        e eVar = new e((Context) a.t(a.this), 1, false);
                        eVar.HLX = new o.f() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.AnonymousClass6.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(m mVar) {
                                AppMethodBeat.i(226793);
                                mVar.d(0, a.bGr());
                                if (!(a.this.bDL() == null || a.this.bDL().lwE == null)) {
                                    mVar.d(3, a.bGs());
                                }
                                mVar.d(1, a.bGt());
                                mVar.d(4, a.bGu());
                                mVar.d(5, a.bGv());
                                AppMethodBeat.o(226793);
                            }
                        };
                        eVar.HLY = new o.g() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.AnonymousClass6.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                AppMethodBeat.i(226796);
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        h.bsL(a.this.gCr);
                                        com.tencent.mm.cr.a.a(a.u(a.this), a.this.filePath, a.this.fileName, a.this.gCr);
                                        AppMethodBeat.o(226796);
                                        return;
                                    case 1:
                                        h.bsM(a.this.gCr);
                                        com.tencent.mm.pluginsdk.ui.tools.a.b(a.v(a.this), a.this.filePath, a.this.gCr);
                                        AppMethodBeat.o(226796);
                                        return;
                                    case 2:
                                        if (!(a.this.bDL() == null || a.this.bDL().lwE == null)) {
                                            a.this.bDL().lwE.ic(false);
                                            AppMethodBeat.o(226796);
                                            return;
                                        }
                                    case 3:
                                        if (!(a.this.bDL() == null || a.this.bDL().lwE == null)) {
                                            a.this.bDL().lwE.ic(true);
                                            AppMethodBeat.o(226796);
                                            return;
                                        }
                                    case 4:
                                        a.w(a.this);
                                        AppMethodBeat.o(226796);
                                        return;
                                    case 5:
                                        p.c(a.x(a.this), a.this.filePath, new p.a() {
                                            /* class com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.AnonymousClass6.AnonymousClass2.AnonymousClass1 */

                                            @Override // com.tencent.mm.platformtools.p.a
                                            public final void bP(String str, String str2) {
                                                AppMethodBeat.i(226794);
                                                Toast.makeText(a.y(a.this), a.z(a.this).getString(R.string.hp6, new Object[]{AndroidMediaUtil.getFriendlySdcardPath(str2)}), 1).show();
                                                AppMethodBeat.o(226794);
                                            }

                                            @Override // com.tencent.mm.platformtools.p.a
                                            public final void bQ(String str, String str2) {
                                                AppMethodBeat.i(226795);
                                                Toast.makeText(a.A(a.this), a.B(a.this).getString(R.string.hp5), 1).show();
                                                AppMethodBeat.o(226795);
                                            }
                                        });
                                        break;
                                }
                                AppMethodBeat.o(226796);
                            }
                        };
                        eVar.dGm();
                    }
                } else if (a.this.bDL() == null) {
                    a.r(a.this);
                    AppMethodBeat.o(226797);
                    return;
                } else if (a.this.bDL().lwG) {
                    a.s(a.this);
                    AppMethodBeat.o(226797);
                    return;
                } else {
                    Log.i("MicroMsg.AppBrand.OpenFileRequest", "opCallback isFinishCurPage:%s", Boolean.valueOf(a.this.bDL().lwG));
                    a.this.bDL().lwG = true;
                    AppMethodBeat.o(226797);
                    return;
                }
                AppMethodBeat.o(226797);
            }
        };
        private String token = "";

        a() {
            AppMethodBeat.i(174804);
            AppMethodBeat.o(174804);
        }

        static /* synthetic */ MMActivity A(a aVar) {
            AppMethodBeat.i(226828);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226828);
            return bDF;
        }

        static /* synthetic */ MMActivity B(a aVar) {
            AppMethodBeat.i(226829);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226829);
            return bDF;
        }

        static /* synthetic */ void a(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226804);
            aVar.b(processResult);
            AppMethodBeat.o(226804);
        }

        static /* synthetic */ void a(a aVar, String str, String str2) {
            AppMethodBeat.i(226806);
            aVar.dx(str, str2);
            AppMethodBeat.o(226806);
        }

        static /* synthetic */ MMActivity b(a aVar) {
            AppMethodBeat.i(226799);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226799);
            return bDF;
        }

        static /* synthetic */ void b(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226805);
            aVar.b(processResult);
            AppMethodBeat.o(226805);
        }

        static /* synthetic */ void c(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226807);
            aVar.b(processResult);
            AppMethodBeat.o(226807);
        }

        static /* synthetic */ boolean c(a aVar) {
            AppMethodBeat.i(226801);
            boolean bDG = aVar.bDG();
            AppMethodBeat.o(226801);
            return bDG;
        }

        static /* synthetic */ void d(a aVar) {
            AppMethodBeat.i(226802);
            aVar.bGp();
            AppMethodBeat.o(226802);
        }

        static /* synthetic */ boolean e(a aVar) {
            AppMethodBeat.i(226803);
            boolean bDG = aVar.bDG();
            AppMethodBeat.o(226803);
            return bDG;
        }

        static /* synthetic */ MMActivity h(a aVar) {
            AppMethodBeat.i(226808);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226808);
            return bDF;
        }

        static /* synthetic */ MMActivity i(a aVar) {
            AppMethodBeat.i(226810);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226810);
            return bDF;
        }

        static /* synthetic */ MMActivity j(a aVar) {
            AppMethodBeat.i(226811);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226811);
            return bDF;
        }

        static /* synthetic */ MiniReaderLogic.a n(a aVar) {
            AppMethodBeat.i(226812);
            MiniReaderLogic.a<Integer> bGq = aVar.bGq();
            AppMethodBeat.o(226812);
            return bGq;
        }

        static /* synthetic */ boolean q(a aVar) {
            AppMethodBeat.i(226813);
            boolean bDG = aVar.bDG();
            AppMethodBeat.o(226813);
            return bDG;
        }

        static /* synthetic */ void r(a aVar) {
            AppMethodBeat.i(226814);
            aVar.b((AppBrandProxyUIProcessTask.ProcessResult) null);
            AppMethodBeat.o(226814);
        }

        static /* synthetic */ void s(a aVar) {
            AppMethodBeat.i(226815);
            aVar.b((AppBrandProxyUIProcessTask.ProcessResult) null);
            AppMethodBeat.o(226815);
        }

        static /* synthetic */ MMActivity t(a aVar) {
            AppMethodBeat.i(226816);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226816);
            return bDF;
        }

        static /* synthetic */ MMActivity u(a aVar) {
            AppMethodBeat.i(226822);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226822);
            return bDF;
        }

        static /* synthetic */ MMActivity v(a aVar) {
            AppMethodBeat.i(226823);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226823);
            return bDF;
        }

        static /* synthetic */ MMActivity x(a aVar) {
            AppMethodBeat.i(226825);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226825);
            return bDF;
        }

        static /* synthetic */ MMActivity y(a aVar) {
            AppMethodBeat.i(226826);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226826);
            return bDF;
        }

        static /* synthetic */ MMActivity z(a aVar) {
            AppMethodBeat.i(226827);
            MMActivity bDF = aVar.bDF();
            AppMethodBeat.o(226827);
            return bDF;
        }

        static {
            AppMethodBeat.i(174829);
            AppMethodBeat.o(174829);
        }

        private void dx(String str, String str2) {
            AppMethodBeat.i(174805);
            String mimeTypeByFileExt = MimeTypeUtil.getMimeTypeByFileExt(str2);
            OpenResult openResult = new OpenResult();
            try {
                Intent intent = new Intent();
                intent.setPackage(null);
                intent.setAction("android.intent.action.VIEW");
                FileProviderHelper.setIntentDataAndType((Context) bDF(), intent, new com.tencent.mm.vfs.o(str), mimeTypeByFileExt, false);
                intent.addFlags(268435456);
                int i2 = Build.VERSION.SDK_INT;
                intent.addFlags(524288);
                MMActivity bDF = bDF();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(bDF, bl.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/file/OpenFileRequest$OpenLogic", "openOuterAppDirectly", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                bDF.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(bDF, "com/tencent/mm/plugin/appbrand/jsapi/file/OpenFileRequest$OpenLogic", "openOuterAppDirectly", "(Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                openResult.ret = 0;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.OpenFileRequest", "start outer view with mime(%s), e = %s", mimeTypeByFileExt, e2);
                openResult.ret = 2147483646;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(174796);
                        Toast.makeText(MMApplicationContext.getContext(), (int) R.string.ms, 0).show();
                        AppMethodBeat.o(174796);
                    }
                });
            }
            b(openResult);
            AppMethodBeat.o(174805);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
            String str;
            AppMethodBeat.i(174806);
            this.appId = ((OpenFileRequest) processRequest).appId;
            this.filePath = ((OpenFileRequest) processRequest).filePath;
            this.gCr = ((OpenFileRequest) processRequest).gCr;
            this.lwF = ((OpenFileRequest) processRequest).lwF;
            this.token = Integer.toString(bDF().hashCode());
            if (ChannelUtil.isGPVersion()) {
                dx(this.filePath, this.gCr);
                AppMethodBeat.o(174806);
                return;
            }
            try {
                int lastIndexOf = this.filePath.lastIndexOf(47) + 1;
                if (lastIndexOf < 0 || lastIndexOf == this.filePath.length()) {
                    lastIndexOf = 0;
                }
                String str2 = this.filePath;
                str = str2.substring(lastIndexOf, str2.length());
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.OpenFileRequest", "get file name error " + e2.getMessage());
                str = "";
            }
            this.fileName = str;
            this.lVD = ((b) g.af(b.class)).a(b.a.clicfg_android_appbrand_opendocument_use_miniqb, false);
            final TBSOneManager defaultInstance = TBSOneManager.getDefaultInstance(bDF());
            com.tencent.mm.cr.a.Rzb = new a.AbstractC0307a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.AnonymousClass2 */

                @Override // com.tencent.mm.cr.a.AbstractC0307a
                public final boolean bGw() {
                    AppMethodBeat.i(226785);
                    boolean z = a.this.lVD;
                    AppMethodBeat.o(226785);
                    return z;
                }

                @Override // com.tencent.mm.cr.a.AbstractC0307a
                public final boolean bGx() {
                    boolean z;
                    AppMethodBeat.i(226786);
                    if (!defaultInstance.isComponentInstalled("file")) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Log.i("MicroMsg.AppBrand.OpenFileRequest", "needDownloadMiniQB: %b", Boolean.valueOf(z));
                    AppMethodBeat.o(226786);
                    return z;
                }

                @Override // com.tencent.mm.cr.a.AbstractC0307a
                public final void bGy() {
                    AppMethodBeat.i(226787);
                    MMActivity b2 = a.b(a.this);
                    if (b2 == null) {
                        Log.w("MicroMsg.AppBrand.OpenFileRequest", "get context return null");
                        AppMethodBeat.o(226787);
                        return;
                    }
                    a.a(a.this, b2, defaultInstance);
                    AppMethodBeat.o(226787);
                }

                @Override // com.tencent.mm.cr.a.AbstractC0307a
                public final void d(int i2, Context context, String str, String str2, String str3, boolean z, HashMap<String, String> hashMap, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2) {
                    AppMethodBeat.i(226788);
                    au.a(i2, context, str, str2, str3, z, hashMap, valueCallback, valueCallback2);
                    AppMethodBeat.o(226788);
                }

                @Override // com.tencent.mm.cr.a.AbstractC0307a
                public final void r(Context context, String str, String str2) {
                    AppMethodBeat.i(226789);
                    au.o(context, str, str2);
                    AppMethodBeat.o(226789);
                }
            };
            bGp();
            AppMethodBeat.o(174806);
        }

        private void bGp() {
            AppMethodBeat.i(226798);
            if (bDL() != null) {
                bDL().appId = this.appId;
                bDL().a(this.filePath, this.gCr, this.token, this.fileName, this.lwF);
                bDL().lwJ = this.lwJ;
                bDL().bDR();
                MiniReaderLogic.a(bDL().lwE.eqW(), bDF(), this.filePath, this.fileName, this.gCr, this.token, this.lwJ, bGq(), this.appId, this.lwF);
                AppMethodBeat.o(226798);
                return;
            }
            com.tencent.mm.cr.a.a(bDF(), this.filePath, this.fileName, this.gCr, this.token, f.a.NONE, this.lwJ, bGq(), this.lwF);
            AppMethodBeat.o(226798);
        }

        private MiniReaderLogic.a<Integer> bGq() {
            AppMethodBeat.i(174807);
            if (this.lVE != null) {
                this.lVE.iBj = true;
            }
            this.lVE = new MiniReaderLogic.a<Integer>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.AnonymousClass4 */

                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.i(174802);
                    Integer num = (Integer) obj;
                    if (this.iBj) {
                        Log.i("MicroMsg.AppBrand.OpenFileRequest", "openReadFile, ignore ret = %d", num);
                        AppMethodBeat.o(174802);
                        return;
                    }
                    Log.i("MicroMsg.AppBrand.OpenFileRequest", "openReadFile, ret = %d", num);
                    if (num.intValue() == -102) {
                        try {
                            a.a(a.this, a.this.filePath, a.this.gCr);
                            AppMethodBeat.o(174802);
                            return;
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.AppBrand.OpenFileRequest", e2, " openOuterAppDirectly exp = %s ", e2);
                        }
                    }
                    OpenResult openResult = new OpenResult();
                    openResult.ret = num.intValue();
                    if (-102 == openResult.ret) {
                        a.c(a.this, openResult);
                        AppMethodBeat.o(174802);
                        return;
                    }
                    if (num.intValue() == 0) {
                        com.tencent.mm.cr.a.e(a.h(a.this), a.this.filePath, a.this.gCr, openResult.ret);
                        a.d(a.this, openResult);
                    }
                    AppMethodBeat.o(174802);
                }
            };
            if (bDL() != null) {
                bDL().lwI = this.lVE;
            }
            MiniReaderLogic.a<Integer> aVar = this.lVE;
            AppMethodBeat.o(174807);
            return aVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest$a$a  reason: collision with other inner class name */
        public static final class C0661a implements com.tencent.mm.ipcinvoker.b<IPCString, IPCInteger> {
            private C0661a() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
            @Override // com.tencent.mm.ipcinvoker.b
            public final /* synthetic */ void invoke(IPCString iPCString, d<IPCInteger> dVar) {
                AppMethodBeat.i(174803);
                IPCString iPCString2 = iPCString;
                if (iPCString2 == null) {
                    Log.e("MicroMsg.AppBrand.OpenFileRequest", "IPCFav data null");
                    AppMethodBeat.o(174803);
                    return;
                }
                cz czVar = new cz();
                ((ad) g.af(ad.class)).a(czVar, 13, iPCString2.value, s.bpb(iPCString2.value) + "." + s.akC(iPCString2.value), "");
                EventCenter.instance.publish(czVar);
                if (dVar != null) {
                    dVar.bn(new IPCInteger(czVar.dGa.ret));
                }
                AppMethodBeat.o(174803);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void bDM() {
            AppMethodBeat.i(174808);
            super.bDM();
            bDF().getWindow().setBackgroundDrawableResource(R.color.ac_);
            if (this.lVD) {
                au.o(bDF(), this.token, this.filePath);
            }
            AppMethodBeat.o(174808);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask, com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(174809);
            if (lVC == i2) {
                OpenResult openResult = new OpenResult();
                if (-1 == i3) {
                    openResult.ret = 0;
                } else {
                    openResult.ret = Integer.MAX_VALUE;
                }
                b(openResult);
                AppMethodBeat.o(174809);
                return;
            }
            b((AppBrandProxyUIProcessTask.ProcessResult) null);
            AppMethodBeat.o(174809);
        }

        static /* synthetic */ void a(a aVar, Context context, final TBSOneManager tBSOneManager) {
            AppMethodBeat.i(226800);
            com.tencent.luggage.h.f.aK(context).a(new Intent(context, AppBrandMiniQBDownloadProxyUI.class), new f.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.AnonymousClass3 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.luggage.h.f.b
                public final void a(int i2, Intent intent) {
                    AppMethodBeat.i(226790);
                    switch (i2) {
                        case -1:
                            if (!a.c(a.this)) {
                                a.d(a.this);
                                AppMethodBeat.o(226790);
                                return;
                            }
                            Log.e("MicroMsg.AppBrand.OpenFileRequest", "read file after proxy activity destroyed");
                            AppMethodBeat.o(226790);
                            return;
                        case 0:
                            if (!tBSOneManager.isComponentInstalled("file") || a.e(a.this)) {
                                Log.w("MicroMsg.AppBrand.OpenFileRequest", "RESULT_CANCELED");
                                OpenResult openResult = new OpenResult();
                                openResult.ret = 2147483645;
                                a.a(a.this, openResult);
                                AppMethodBeat.o(226790);
                                return;
                            }
                            Log.w("MicroMsg.AppBrand.OpenFileRequest", "RESULT_CANCELED, but file component has been installed");
                            a.d(a.this);
                            AppMethodBeat.o(226790);
                            return;
                        case 2:
                            Log.w("MicroMsg.AppBrand.OpenFileRequest", "miniqb is downloading now!");
                            OpenResult openResult2 = new OpenResult();
                            openResult2.ret = Integer.MAX_VALUE;
                            a.b(a.this, openResult2);
                            break;
                    }
                    AppMethodBeat.o(226790);
                }
            });
            AppMethodBeat.o(226800);
        }

        static /* synthetic */ void d(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(226809);
            if (aVar.lwz != null) {
                aVar.lwz.c(processResult);
            }
            AppMethodBeat.o(226809);
        }

        static /* synthetic */ String bGr() {
            AppMethodBeat.i(226817);
            String string = MMApplicationContext.getResources().getString(R.string.g5c);
            AppMethodBeat.o(226817);
            return string;
        }

        static /* synthetic */ String bGs() {
            AppMethodBeat.i(226818);
            String string = MMApplicationContext.getResources().getString(R.string.cei);
            AppMethodBeat.o(226818);
            return string;
        }

        static /* synthetic */ String bGt() {
            AppMethodBeat.i(226819);
            String string = MMApplicationContext.getResources().getString(R.string.b3m);
            AppMethodBeat.o(226819);
            return string;
        }

        static /* synthetic */ String bGu() {
            AppMethodBeat.i(226820);
            String string = MMApplicationContext.getResources().getString(R.string.c8z);
            AppMethodBeat.o(226820);
            return string;
        }

        static /* synthetic */ String bGv() {
            AppMethodBeat.i(226821);
            String string = MMApplicationContext.getResources().getString(R.string.c2x);
            AppMethodBeat.o(226821);
            return string;
        }

        static /* synthetic */ void w(a aVar) {
            AppMethodBeat.i(226824);
            com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCString(aVar.filePath), C0661a.class, new d<IPCInteger>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.AnonymousClass5 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.ipcinvoker.d
                public final /* synthetic */ void bn(IPCInteger iPCInteger) {
                    AppMethodBeat.i(226792);
                    IPCInteger iPCInteger2 = iPCInteger;
                    if (iPCInteger2 == null) {
                        Log.e("MicroMsg.AppBrand.OpenFileRequest", "fav ipc callback data null");
                        AppMethodBeat.o(226792);
                        return;
                    }
                    int i2 = iPCInteger2.value;
                    Log.i("MicroMsg.AppBrand.OpenFileRequest", "fav result:%d", Integer.valueOf(i2));
                    final MMActivity i3 = a.i(a.this);
                    if (i2 == 0) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.AnonymousClass5.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(226791);
                                com.tencent.mm.ui.widget.snackbar.b.r(i3, i3.getString(R.string.caf));
                                AppMethodBeat.o(226791);
                            }
                        });
                    }
                    AppMethodBeat.o(226792);
                }
            });
            AppMethodBeat.o(226824);
        }
    }
}
