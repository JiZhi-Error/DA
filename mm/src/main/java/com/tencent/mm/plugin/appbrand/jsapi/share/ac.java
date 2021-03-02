package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.jsapi.dc;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J:\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u000fj\u0002`\u0011H\u0007JJ\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J0\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n0\u000fj\u0002`\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationLogic;", "", "()V", "SHARE_VIDEO_REQUEST_CODE", "", "buildSelectConversationIntent", "Landroid/content/Intent;", "videoPath", "", "doShare", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "thumbPath", "shareCallBack", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareCallBack;", "doShareVideoAfterSelectConversation", "durationS", "selectedUsers", "", "customSendText", "onVideoSent", "Ljava/lang/Runnable;", "isVideoLegal2Share", "isVideoLegalCallback", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/IsFileLegalCallback;", "plugin-appbrand-integration_release"})
final class ac {
    private static final int msZ;
    public static final ac mta;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "isVideoLegal", "", "invoke"})
    static final class a extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ kotlin.g.a.b msA;
        final /* synthetic */ Activity msB;
        final /* synthetic */ String mtb;
        final /* synthetic */ String mtc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(kotlin.g.a.b bVar, Activity activity, String str, String str2) {
            super(1);
            this.msA = bVar;
            this.msB = activity;
            this.mtb = str;
            this.mtc = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(228559);
            if (!bool.booleanValue()) {
                Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, fail since video illegal");
                this.msA.invoke(ab.FAIL);
            } else {
                f.aK(this.msB).b(new f.c(this) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.share.ac.a.AnonymousClass1 */
                    final /* synthetic */ a mtd;

                    {
                        this.mtd = r1;
                    }

                    @Override // com.tencent.luggage.h.f.c
                    public final boolean c(int i2, int i3, Intent intent) {
                        boolean z;
                        boolean z2;
                        boolean z3 = false;
                        AppMethodBeat.i(228558);
                        Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, requestCode: " + i2 + ", resultCode: " + i3 + ", data exists: " + (intent != null));
                        ac acVar = ac.mta;
                        if (ac.msZ != i2) {
                            AppMethodBeat.o(228558);
                            return false;
                        } else if (i3 != -1) {
                            Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, cancel");
                            this.mtd.msA.invoke(ab.CANCEL);
                            AppMethodBeat.o(228558);
                            return true;
                        } else if (intent == null) {
                            Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, fail since data is null");
                            this.mtd.msA.invoke(ab.FAIL);
                            AppMethodBeat.o(228558);
                            return true;
                        } else {
                            String stringExtra = intent.getStringExtra("Select_Conv_User");
                            Log.d("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, selectedUsersStr: ".concat(String.valueOf(stringExtra)));
                            String str = stringExtra;
                            if (str == null || str.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, fail since selectedUsers is empty 1");
                                this.mtd.msA.invoke(ab.FAIL);
                                AppMethodBeat.o(228558);
                                return true;
                            }
                            List<String> stringToList = Util.stringToList(stringExtra, ",");
                            List<String> list = stringToList;
                            if (list == null || list.isEmpty()) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, fail since selectedUsers is empty 2");
                                this.mtd.msA.invoke(ab.FAIL);
                                AppMethodBeat.o(228558);
                                return true;
                            }
                            String stringExtra2 = intent.getStringExtra("custom_send_text");
                            Log.d("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, customSendText: ".concat(String.valueOf(stringExtra2)));
                            int Zj = dc.Zj(this.mtd.mtb);
                            if (Zj <= 0) {
                                Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, durationS: ".concat(String.valueOf(Zj)));
                                this.mtd.msA.invoke(ab.FAIL);
                                AppMethodBeat.o(228558);
                                return true;
                            }
                            String dm = dc.dm(this.mtd.mtb, this.mtd.mtc);
                            String str2 = dm;
                            if (str2 == null || str2.length() == 0) {
                                z3 = true;
                            }
                            if (z3) {
                                Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShare, thumbPath is empty");
                                this.mtd.msA.invoke(ab.FAIL);
                                AppMethodBeat.o(228558);
                                return true;
                            }
                            ac acVar2 = ac.mta;
                            ac.a(this.mtd.msB, this.mtd.mtb, dm, Zj, stringToList, stringExtra2, new Runnable(this) {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.share.ac.a.AnonymousClass1.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass1 mte;

                                {
                                    this.mte = r1;
                                }

                                public final void run() {
                                    AppMethodBeat.i(228557);
                                    this.mte.mtd.msA.invoke(ab.SUCCESS);
                                    AppMethodBeat.o(228557);
                                }
                            });
                            AppMethodBeat.o(228558);
                            return true;
                        }
                    }
                });
                StringBuilder sb = new StringBuilder("doShare, SHARE_VIDEO_REQUEST_CODE: ");
                ac acVar = ac.mta;
                Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", sb.append(ac.msZ).toString());
                ac acVar2 = ac.mta;
                Intent aaN = ac.aaN(this.mtb);
                ac acVar3 = ac.mta;
                com.tencent.mm.br.c.c(this.msB, ".ui.transmit.SelectConversationUI", aaN, ac.msZ);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(228559);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(228564);
        ac acVar = new ac();
        mta = acVar;
        msZ = com.tencent.luggage.sdk.g.a.aK(acVar);
        AppMethodBeat.o(228564);
    }

    private ac() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ kotlin.g.a.b mti;

        c(kotlin.g.a.b bVar) {
            this.mti = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(228562);
            this.mti.invoke(Boolean.FALSE);
            AppMethodBeat.o(228562);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class d implements DialogInterface.OnClickListener {
        final /* synthetic */ kotlin.g.a.b mti;

        d(kotlin.g.a.b bVar) {
            this.mti = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(228563);
            this.mti.invoke(Boolean.FALSE);
            AppMethodBeat.o(228563);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onSent"})
    public static final class b implements d.a {
        final /* synthetic */ Activity msB;
        final /* synthetic */ Runnable msG;
        final /* synthetic */ String mtf;
        final /* synthetic */ z.d mtg;

        b(String str, z.d dVar, Activity activity, Runnable runnable) {
            this.mtf = str;
            this.mtg = dVar;
            this.msB = activity;
            this.msG = runnable;
        }

        @Override // com.tencent.mm.plugin.messenger.a.d.a
        public final void bIM() {
            AppMethodBeat.i(228561);
            Log.d("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShareVideoAfterSelectConversation, send video to " + this.mtf + " done");
            z.d dVar = this.mtg;
            dVar.SYE--;
            if (this.mtg.SYE <= 0) {
                Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShareVideoAfterSelectConversation, send video done");
                com.tencent.mm.ui.widget.snackbar.b.a(this.msB, (View) null, this.msB.getString(R.string.dc_), new v(this) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.share.ac.b.AnonymousClass1 */
                    final /* synthetic */ b mth;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.mth = r1;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.v, com.tencent.mm.ui.widget.snackbar.a.c
                    public final void onHide() {
                        AppMethodBeat.i(228560);
                        Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShareVideoAfterSelectConversation, snackBar hide");
                        this.mth.msG.run();
                        AppMethodBeat.o(228560);
                    }
                });
            }
            AppMethodBeat.o(228561);
        }
    }

    public static final /* synthetic */ void a(Activity activity, String str, String str2, int i2, List list, String str3, Runnable runnable) {
        boolean z;
        AppMethodBeat.i(228565);
        z.d dVar = new z.d();
        dVar.SYE = list.size();
        String str4 = str3;
        if (!(str4 == null || str4.length() == 0)) {
            z = true;
        } else {
            z = false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str5 = (String) it.next();
            g.eir().a(activity, str5, str, str2, i2, "", "", new b(str5, dVar, activity, runnable));
            if (z) {
                g.eir().ad(str5, str3, ab.JG(str5));
            }
        }
        AppMethodBeat.o(228565);
    }

    public static final /* synthetic */ Intent aaN(String str) {
        AppMethodBeat.i(228566);
        Intent intent = new Intent();
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 1);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        AppMethodBeat.o(228566);
        return intent;
    }
}
