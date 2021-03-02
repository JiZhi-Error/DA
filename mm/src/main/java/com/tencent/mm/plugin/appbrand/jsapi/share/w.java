package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.r;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0002J8\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0011j\u0002`\u0013H\u0007J@\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J0\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\r0\u0011j\u0002`\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationLogic;", "", "()V", "SHARE_FILE_REQUEST_CODE", "", "buildMediaMsg", "Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;", "filePath", "", DownloadInfo.FILENAME, "buildSelectConversationIntent", "Landroid/content/Intent;", "doShare", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "shareCallBack", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareCallBack;", "doShareFileAfterSelectConversation", "selectedUsers", "", "customSendText", "onVideoSent", "Ljava/lang/Runnable;", "isFileLegal2Share", "isFileLegalCallback", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/IsFileLegalCallback;", "plugin-appbrand-integration_release"})
final class w {
    private static final int msy;
    public static final w msz;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "isFileLegal", "", "invoke"})
    static final class a extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ kotlin.g.a.b msA;
        final /* synthetic */ Activity msB;
        final /* synthetic */ String msC;
        final /* synthetic */ String msD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(kotlin.g.a.b bVar, Activity activity, String str, String str2) {
            super(1);
            this.msA = bVar;
            this.msB = activity;
            this.msC = str;
            this.msD = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(228529);
            if (!bool.booleanValue()) {
                Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "doShare, fail since file illegal");
                this.msA.invoke(ab.FAIL);
            } else {
                f.aK(this.msB).b(new f.c(this) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.share.w.a.AnonymousClass1 */
                    final /* synthetic */ a msE;

                    {
                        this.msE = r1;
                    }

                    @Override // com.tencent.luggage.h.f.c
                    public final boolean c(int i2, int i3, Intent intent) {
                        boolean z;
                        boolean z2 = false;
                        AppMethodBeat.i(228528);
                        Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "doShare, requestCode: " + i2 + ", resultCode: " + i3 + ", data exists: " + (intent != null));
                        w wVar = w.msz;
                        if (w.msy != i2) {
                            AppMethodBeat.o(228528);
                            return false;
                        } else if (i3 != -1) {
                            Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "doShare, cancel");
                            this.msE.msA.invoke(ab.CANCEL);
                            AppMethodBeat.o(228528);
                            return true;
                        } else if (intent == null) {
                            Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "doShare, fail since data is null");
                            this.msE.msA.invoke(ab.FAIL);
                            AppMethodBeat.o(228528);
                            return true;
                        } else {
                            String stringExtra = intent.getStringExtra("Select_Conv_User");
                            Log.d("MicroMsg.AppBrand.JsApiShareFileMessage", "doShare, selectedUsersStr: ".concat(String.valueOf(stringExtra)));
                            String str = stringExtra;
                            if (str == null || str.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "doShare, fail since selectedUsers is empty 1");
                                this.msE.msA.invoke(ab.FAIL);
                                AppMethodBeat.o(228528);
                                return true;
                            }
                            List<String> stringToList = Util.stringToList(stringExtra, ",");
                            List<String> list = stringToList;
                            if (list == null || list.isEmpty()) {
                                z2 = true;
                            }
                            if (z2) {
                                Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "doShare, fail since selectedUsers is empty 2");
                                this.msE.msA.invoke(ab.FAIL);
                                AppMethodBeat.o(228528);
                                return true;
                            }
                            String stringExtra2 = intent.getStringExtra("custom_send_text");
                            Log.d("MicroMsg.AppBrand.JsApiShareFileMessage", "doShare, customSendText: ".concat(String.valueOf(stringExtra2)));
                            w wVar2 = w.msz;
                            w.a(this.msE.msB, this.msE.msC, this.msE.msD, stringToList, stringExtra2, new Runnable(this) {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.share.w.a.AnonymousClass1.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass1 msF;

                                {
                                    this.msF = r1;
                                }

                                public final void run() {
                                    AppMethodBeat.i(228527);
                                    this.msF.msE.msA.invoke(ab.SUCCESS);
                                    AppMethodBeat.o(228527);
                                }
                            });
                            AppMethodBeat.o(228528);
                            return true;
                        }
                    }
                });
                StringBuilder sb = new StringBuilder("doShare, SHARE_VIDEO_REQUEST_CODE: ");
                w wVar = w.msz;
                Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", sb.append(w.msy).toString());
                w wVar2 = w.msz;
                Intent aaJ = w.aaJ(this.msD);
                w wVar3 = w.msz;
                com.tencent.mm.br.c.c(this.msB, ".ui.transmit.SelectConversationUI", aaJ, w.msy);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(228529);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(228534);
        w wVar = new w();
        msz = wVar;
        msy = com.tencent.luggage.sdk.g.a.aK(wVar);
        AppMethodBeat.o(228534);
    }

    private w() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ kotlin.g.a.b msH;

        c(kotlin.g.a.b bVar) {
            this.msH = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(228531);
            this.msH.invoke(Boolean.FALSE);
            AppMethodBeat.o(228531);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class d implements DialogInterface.OnClickListener {
        final /* synthetic */ kotlin.g.a.b msH;

        d(kotlin.g.a.b bVar) {
            this.msH = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(228532);
            this.msH.invoke(Boolean.FALSE);
            AppMethodBeat.o(228532);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationLogic$doShareFileAfterSelectConversation$2", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/OnSnackBarVisibilityChangeListenerAdapter;", "onHide", "", "plugin-appbrand-integration_release"})
    public static final class b extends v {
        final /* synthetic */ Runnable msG;

        b(Runnable runnable) {
            this.msG = runnable;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.share.v, com.tencent.mm.ui.widget.snackbar.a.c
        public final void onHide() {
            AppMethodBeat.i(228530);
            Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "doShareFileAfterSelectConversation, snackBar hide");
            this.msG.run();
            AppMethodBeat.o(228530);
        }
    }

    public static void a(Activity activity, String str, String str2, List<String> list, String str3, Runnable runnable) {
        boolean z = false;
        AppMethodBeat.i(228533);
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(str, "filePath");
        p.h(str2, DownloadInfo.FILENAME);
        p.h(list, "selectedUsers");
        p.h(runnable, "onVideoSent");
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.setFilePath(str);
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.title = str2;
        wXMediaMessage.description = str2;
        String str4 = str3;
        if (!(str4 == null || str4.length() == 0)) {
            z = true;
        }
        for (String str5 : list) {
            EventCenter eventCenter = EventCenter.instance;
            r rVar = new r();
            rVar.dCD.dCE = wXMediaMessage;
            rVar.dCD.toUser = str5;
            eventCenter.publish(rVar);
            if (z) {
                g.eir().ad(str5, str3, ab.JG(str5));
            }
        }
        com.tencent.mm.ui.widget.snackbar.b.a(activity, (View) null, activity.getString(R.string.dc_), new b(runnable));
        AppMethodBeat.o(228533);
    }

    public static final /* synthetic */ Intent aaJ(String str) {
        AppMethodBeat.i(228535);
        Intent intent = new Intent();
        intent.putExtra("desc_title", str);
        intent.putExtra("Retr_Msg_Type", 3);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        AppMethodBeat.o(228535);
        return intent;
    }
}
