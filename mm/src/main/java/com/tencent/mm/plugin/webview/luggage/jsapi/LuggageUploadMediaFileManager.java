package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class LuggageUploadMediaFileManager {
    private static ProgressDialog gtM = null;
    public g ISU;
    public String IWD;
    public boolean IWE;
    public b IWF;
    public String mAppId;
    public MMActivity qdG;

    /* access modifiers changed from: package-private */
    public interface a {
        void f(boolean z, String str, String str2);
    }

    public interface b {
        void b(boolean z, HashMap<String, Object> hashMap);
    }

    static /* synthetic */ void a(LuggageUploadMediaFileManager luggageUploadMediaFileManager) {
        AppMethodBeat.i(78668);
        luggageUploadMediaFileManager.gco();
        AppMethodBeat.o(78668);
    }

    /* access modifiers changed from: package-private */
    public final void gco() {
        AppMethodBeat.i(78666);
        if (this.ISU.gbC() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("close_window_confirm_dialog_switch", true);
            bundle.putString("close_window_confirm_dialog_title_cn", this.qdG.getString(R.string.izo));
            bundle.putString("close_window_confirm_dialog_title_eng", this.qdG.getString(R.string.izo));
            bundle.putString("close_window_confirm_dialog_ok_cn", this.qdG.getString(R.string.izk));
            bundle.putString("close_window_confirm_dialog_ok_eng", this.qdG.getString(R.string.izk));
            bundle.putString("close_window_confirm_dialog_cancel_cn", this.qdG.getString(R.string.izl));
            bundle.putString("close_window_confirm_dialog_cancel_eng", this.qdG.getString(R.string.izl));
            this.ISU.gbC().setCloseWindowConfirmInfo(bundle);
        }
        gcp();
        AppMethodBeat.o(78666);
    }

    /* access modifiers changed from: package-private */
    public final void gcp() {
        AppMethodBeat.i(78667);
        if (this.IWE) {
            Bundle bundle = new Bundle();
            bundle.putString("local_id", this.IWD);
            bundle.putString("app_id", this.mAppId);
            bundle.putBoolean("show_progress_tips", this.IWE);
            com.tencent.mm.plugin.webview.luggage.ipc.b.a(this.qdG, bundle, c.class, new com.tencent.mm.plugin.webview.luggage.ipc.a() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.webview.luggage.ipc.a
                public final void v(Bundle bundle) {
                    AppMethodBeat.i(78646);
                    if (bundle != null) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String string = bundle.getString("media_id");
                        String string2 = bundle.getString("media_url");
                        hashMap.put("serverId", Util.nullAsNil(string));
                        hashMap.put("mediaUrl", Util.nullAsNil(string2));
                        LuggageUploadMediaFileManager.this.IWF.b(true, hashMap);
                        AppMethodBeat.o(78646);
                        return;
                    }
                    LuggageUploadMediaFileManager.this.IWF.b(false, null);
                    AppMethodBeat.o(78646);
                }
            });
            AppMethodBeat.o(78667);
            return;
        }
        final UploadMediaFileTask uploadMediaFileTask = new UploadMediaFileTask();
        uploadMediaFileTask.IWP = this.IWD;
        uploadMediaFileTask.appId = this.mAppId;
        uploadMediaFileTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(78647);
                uploadMediaFileTask.bDK();
                LuggageUploadMediaFileManager.b(LuggageUploadMediaFileManager.this);
                if (uploadMediaFileTask.success) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("serverId", Util.nullAsNil(uploadMediaFileTask.mediaId));
                    hashMap.put("mediaUrl", Util.nullAsNil(uploadMediaFileTask.IWQ));
                    LuggageUploadMediaFileManager.this.IWF.b(true, hashMap);
                    AppMethodBeat.o(78647);
                    return;
                }
                LuggageUploadMediaFileManager.this.IWF.b(false, null);
                AppMethodBeat.o(78647);
            }
        };
        uploadMediaFileTask.bDJ();
        AppBrandMainProcessService.a(uploadMediaFileTask);
        AppMethodBeat.o(78667);
    }

    public static class c implements com.tencent.mm.plugin.webview.luggage.ipc.c {
        private a IWM = new a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.a
            public final void f(boolean z, String str, String str2) {
                AppMethodBeat.i(78654);
                if (c.this.IWN != null) {
                    if (z) {
                        Bundle bundle = new Bundle();
                        bundle.putString("media_id", str);
                        bundle.putString("media_url", str2);
                        c.this.IWN.v(bundle);
                        AppMethodBeat.o(78654);
                        return;
                    }
                    c.this.IWN.v(null);
                }
                AppMethodBeat.o(78654);
            }
        };
        private com.tencent.mm.plugin.webview.luggage.ipc.a IWN;

        public c() {
            AppMethodBeat.i(78655);
            AppMethodBeat.o(78655);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.ipc.c
        public final void a(Context context, Bundle bundle, com.tencent.mm.plugin.webview.luggage.ipc.a aVar) {
            AppMethodBeat.i(78656);
            this.IWN = aVar;
            String string = bundle.getString("local_id");
            String string2 = bundle.getString("app_id");
            boolean z = bundle.getBoolean("show_progress_tips");
            WebViewJSSDKFileItem aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(string);
            if (aYO == null) {
                aVar.v(null);
                AppMethodBeat.o(78656);
                return;
            }
            switch (aYO.mediaType) {
                case 1:
                    LuggageUploadMediaFileManager.a(context, aYO, string2, string, com.tencent.mm.i.a.gpU, z, this.IWM);
                    AppMethodBeat.o(78656);
                    return;
                case 2:
                case 3:
                default:
                    LuggageUploadMediaFileManager.a(context, string2, string, com.tencent.mm.i.a.gpV, z, this.IWM);
                    AppMethodBeat.o(78656);
                    return;
                case 4:
                    LuggageUploadMediaFileManager.a(context, string2, string, com.tencent.mm.i.a.gpV, z, this.IWM);
                    AppMethodBeat.o(78656);
                    return;
            }
        }
    }

    public static class UploadMediaFileTask extends MainProcessTask {
        public static final Parcelable.Creator<UploadMediaFileTask> CREATOR = new Parcelable.Creator<UploadMediaFileTask>() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.UploadMediaFileTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ UploadMediaFileTask[] newArray(int i2) {
                return new UploadMediaFileTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ UploadMediaFileTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(78658);
                UploadMediaFileTask uploadMediaFileTask = new UploadMediaFileTask(parcel, (byte) 0);
                AppMethodBeat.o(78658);
                return uploadMediaFileTask;
            }
        };
        private a IWM;
        public String IWP;
        public String IWQ;
        public String appId;
        public Runnable lyv;
        public String mediaId;
        public boolean success;

        /* synthetic */ UploadMediaFileTask(Parcel parcel, byte b2) {
            this(parcel);
        }

        static /* synthetic */ boolean a(UploadMediaFileTask uploadMediaFileTask) {
            AppMethodBeat.i(78664);
            boolean bDU = uploadMediaFileTask.bDU();
            AppMethodBeat.o(78664);
            return bDU;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(78659);
            Log.i("MicroMsg.UploadMediaTask", "runInMainProcess");
            if (this.IWM == null) {
                this.IWM = new a() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.UploadMediaFileTask.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.a
                    public final void f(boolean z, String str, String str2) {
                        AppMethodBeat.i(78657);
                        Log.i("MicroMsg.UploadMediaTask", "success = %b, mediaId = %s, mediaUrl = %s", Boolean.valueOf(z), str, str2);
                        UploadMediaFileTask.this.success = z;
                        UploadMediaFileTask.this.mediaId = str;
                        UploadMediaFileTask.this.IWQ = str2;
                        UploadMediaFileTask.a(UploadMediaFileTask.this);
                        AppMethodBeat.o(78657);
                    }
                };
            }
            WebViewJSSDKFileItem aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(this.IWP);
            if (aYO == null) {
                bDU();
                AppMethodBeat.o(78659);
                return;
            }
            switch (aYO.mediaType) {
                case 1:
                    LuggageUploadMediaFileManager.a(MMApplicationContext.getContext(), aYO, this.appId, this.IWP, com.tencent.mm.i.a.gpU, false, this.IWM);
                    AppMethodBeat.o(78659);
                    return;
                case 2:
                case 3:
                default:
                    LuggageUploadMediaFileManager.a(MMApplicationContext.getContext(), this.appId, this.IWP, com.tencent.mm.i.a.gpV, false, this.IWM);
                    AppMethodBeat.o(78659);
                    return;
                case 4:
                    LuggageUploadMediaFileManager.a(MMApplicationContext.getContext(), this.appId, this.IWP, com.tencent.mm.i.a.gpV, false, this.IWM);
                    AppMethodBeat.o(78659);
                    return;
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(78660);
            if (this.lyv != null) {
                this.lyv.run();
            }
            AppMethodBeat.o(78660);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(78661);
            this.IWP = parcel.readString();
            this.appId = parcel.readString();
            this.mediaId = parcel.readString();
            this.IWQ = parcel.readString();
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.success = z;
            AppMethodBeat.o(78661);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(78662);
            parcel.writeString(this.IWP);
            parcel.writeString(this.appId);
            parcel.writeString(this.mediaId);
            parcel.writeString(this.IWQ);
            parcel.writeByte((byte) (this.success ? 1 : 0));
            AppMethodBeat.o(78662);
        }

        public UploadMediaFileTask() {
        }

        private UploadMediaFileTask(Parcel parcel) {
            AppMethodBeat.i(78663);
            f(parcel);
            AppMethodBeat.o(78663);
        }

        static {
            AppMethodBeat.i(78665);
            AppMethodBeat.o(78665);
        }
    }

    static /* synthetic */ void b(LuggageUploadMediaFileManager luggageUploadMediaFileManager) {
        AppMethodBeat.i(78669);
        if (luggageUploadMediaFileManager.ISU.gbC() != null) {
            m gbC = luggageUploadMediaFileManager.ISU.gbC();
            if (gbC.IUq != null) {
                gbC.IUq.dismiss();
                gbC.IUq = null;
            }
            luggageUploadMediaFileManager.ISU.gbC().setCloseWindowConfirmInfo(null);
        }
        AppMethodBeat.o(78669);
    }

    static /* synthetic */ void a(Context context, WebViewJSSDKFileItem webViewJSSDKFileItem, String str, final String str2, int i2, boolean z, final a aVar) {
        AppMethodBeat.i(78670);
        final AnonymousClass5 r8 = new f.b() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.webview.model.f.b
            public final void a(boolean z, int i2, String str, String str2, String str3, String str4) {
                AppMethodBeat.i(78648);
                Log.i("MicroMsg.UploadMediaFileHelp", " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                if (!Util.isNullOrNil(str) && str.equals(str2)) {
                    com.tencent.mm.plugin.webview.modeltools.g.gdu().b(this);
                    if (LuggageUploadMediaFileManager.gtM != null) {
                        LuggageUploadMediaFileManager.gtM.dismiss();
                        ProgressDialog unused = LuggageUploadMediaFileManager.gtM = null;
                    }
                    aVar.f(z, str2, str3);
                }
                AppMethodBeat.o(78648);
            }
        };
        com.tencent.mm.av.g c2 = q.bcR().c(Long.valueOf(q.bcR().a("", webViewJSSDKFileItem.laR, webViewJSSDKFileItem.laV ? 0 : 1, 0, new PString(), new PInt(), new PInt())));
        String str3 = webViewJSSDKFileItem.laR;
        String o = q.bcR().o(c2.iXm, "", "");
        webViewJSSDKFileItem.laR = o;
        Log.i("MicroMsg.UploadMediaFileHelp", "Image Inserted: %s", o);
        boolean a2 = com.tencent.mm.plugin.webview.modeltools.g.gdu().a(str, str2, i2, 202, 2, r8);
        Log.i("MicroMsg.UploadMediaFileHelp", "add cdn upload task result : %b", Boolean.valueOf(a2));
        webViewJSSDKFileItem.laR = str3;
        if (!a2) {
            aVar.f(false, "", "");
            AppMethodBeat.o(78670);
            return;
        }
        if (z) {
            context.getString(R.string.zb);
            gtM = h.a(context, context.getString(R.string.j5c), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.AnonymousClass6 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(78649);
                    com.tencent.mm.plugin.webview.modeltools.g.gdu().b(r8);
                    com.tencent.mm.plugin.webview.modeltools.g.gdu();
                    an.WG(str2);
                    aVar.f(false, "", "");
                    AppMethodBeat.o(78649);
                }
            });
        }
        AppMethodBeat.o(78670);
    }

    static /* synthetic */ void a(final Context context, String str, final String str2, int i2, boolean z, final a aVar) {
        AppMethodBeat.i(78671);
        final AnonymousClass7 r6 = new f.b() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.webview.model.f.b
            public final void a(boolean z, int i2, String str, String str2, String str3, String str4) {
                AppMethodBeat.i(78650);
                Log.i("MicroMsg.UploadMediaFileHelp", "on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                if (Util.isNullOrNil(str) || !str.equals(str2)) {
                    AppMethodBeat.o(78650);
                    return;
                }
                com.tencent.mm.plugin.webview.modeltools.g.gdu().b(this);
                if (LuggageUploadMediaFileManager.gtM != null) {
                    LuggageUploadMediaFileManager.gtM.dismiss();
                    ProgressDialog unused = LuggageUploadMediaFileManager.gtM = null;
                }
                aVar.f(z, str2, str3);
                AppMethodBeat.o(78650);
            }
        };
        boolean a2 = com.tencent.mm.plugin.webview.modeltools.g.gdu().a(str, str2, i2, 202, 2, r6);
        Log.i("MicroMsg.UploadMediaFileHelp", "add cdn upload task result : %b", Boolean.valueOf(a2));
        if (!a2) {
            aVar.f(false, "", "");
            AppMethodBeat.o(78671);
            return;
        }
        if (z) {
            context.getString(R.string.zb);
            com.tencent.mm.ui.base.q a3 = h.a(context, context.getString(R.string.j5c), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.AnonymousClass8 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(78651);
                    com.tencent.mm.plugin.webview.modeltools.g.gdu().b(r6);
                    com.tencent.mm.plugin.webview.modeltools.g.gdu();
                    an.WG(str2);
                    aVar.f(false, "", "");
                    AppMethodBeat.o(78651);
                }
            });
            gtM = a3;
            a3.setOnKeyListener(new DialogInterface.OnKeyListener() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.AnonymousClass9 */

                public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    AppMethodBeat.i(78653);
                    if (i2 == 4 && keyEvent.getAction() == 1) {
                        h.a(context, true, context.getString(R.string.izo), "", context.getString(R.string.izk), context.getString(R.string.izl), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.AnonymousClass9.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(78652);
                                LuggageUploadMediaFileManager.gtM.cancel();
                                AppMethodBeat.o(78652);
                            }
                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.AnonymousClass9.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        AppMethodBeat.o(78653);
                        return true;
                    }
                    AppMethodBeat.o(78653);
                    return false;
                }
            });
        }
        AppMethodBeat.o(78671);
    }
}
