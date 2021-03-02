package com.tencent.mm.msgsubscription.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.ShowInfo;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import com.tencent.mm.msgsubscription.c.a;
import com.tencent.mm.msgsubscription.ui.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0007J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController;", "Lcom/tencent/mm/msgsubscription/model/biz_service/IBrandSubscribeMsgRequestController;", "()V", "TAG", "", "actionMachine", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getSubscribeMsgList", "", "requestTask", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "isGetAction", "", NativeProtocol.WEB_DIALOG_ACTION, "isSubscribeAction", "nextAction", "subscribeMsgList", "SubscribeMsgRequestCallback", "SubscribeMsgRequestTask", "plugin-comm_release"})
public final class a {
    private static HashMap<Integer, Integer> jzP = ae.g(s.U(1, 0), s.U(3, 2), s.U(2, 0));
    public static final a jzQ = new a();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "", "dismissProgressDialog", "", "onCancel", "onDismissDialog", "onError", NativeProtocol.WEB_DIALOG_ACTION, "", "errCode", "errMsg", "", "onGetSubscribeListSuccess", "showDialog", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onShowDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "containerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "onSubscribeMsgSuccess", "plugin-comm_release"})
    /* renamed from: com.tencent.mm.msgsubscription.b.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0465a {
        void a(k kVar, e eVar);

        void a(boolean z, SubscribeMsgRequestResult subscribeMsgRequestResult);

        void b(SubscribeMsgRequestResult subscribeMsgRequestResult);

        void biV();

        void biW();

        void i(int i2, int i3, String str);
    }

    static {
        AppMethodBeat.i(223320);
        AppMethodBeat.o(223320);
    }

    private a() {
    }

    public static final int un(int i2) {
        AppMethodBeat.i(223317);
        Integer num = jzP.get(Integer.valueOf(i2));
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(223317);
            return intValue;
        }
        AppMethodBeat.o(223317);
        return -1;
    }

    public static final boolean uo(int i2) {
        return i2 == 3 || i2 == 1;
    }

    public static final boolean up(int i2) {
        return i2 == 2;
    }

    public static void a(b bVar) {
        AppMethodBeat.i(223318);
        p.h(bVar, "requestTask");
        bVar.run();
        AppMethodBeat.o(223318);
    }

    public static void b(b bVar) {
        AppMethodBeat.i(223319);
        p.h(bVar, "requestTask");
        bVar.run();
        AppMethodBeat.o(223319);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 H2\u00020\u0001:\u0001HBI\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\tj\b\u0012\u0004\u0012\u00020\u0007`\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0012J,\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00052\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0.H\u0002J \u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000200H\u0002J\u0018\u00104\u001a\u0002002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00101\u001a\u000202H\u0002J\u0006\u00105\u001a\u000200J\u0018\u00106\u001a\u0002002\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u000209H\u0002J\u0006\u0010:\u001a\u000200J\u000e\u0010;\u001a\u0002002\u0006\u0010<\u001a\u00020\u0005J,\u0010=\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@H\u0002J(\u0010A\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u0002022\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u0002000CH\u0002J \u0010D\u001a\u00020)2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u0002022\u0006\u00108\u001a\u000209H\u0002J \u0010E\u001a\u0002002\u0006\u0010F\u001a\u00020\u00072\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u0002000CH\u0002J \u0010G\u001a\u0002002\u0006\u0010F\u001a\u00020\u00072\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u0002000CH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R.\u0010 \u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010\tj\n\u0012\u0004\u0012\u00020!\u0018\u0001`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010\u0010\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\tj\b\u0012\u0004\u0012\u00020\u0007`\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, hxF = {"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "", "context", "Landroid/content/Context;", NativeProtocol.WEB_DIALOG_ACTION, "", "bizAppId", "", "templateIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", IssueStorage.COLUMN_EXT_INFO, "requestCallback", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "(Landroid/content/Context;ILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;)V", "bizUsername", "subscribeUrl", "content", "(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;)V", "buffer", "", "mAlertDialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "mBizService", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "mDialogContainerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mFromScene", "mSubscribeMsgDialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "mSubscribeReportInfo", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeDialogReportInfo;", "subscribeMsgTmpItems", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getSubscribeMsgTmpItems", "()Ljava/util/ArrayList;", "setSubscribeMsgTmpItems", "(Ljava/util/ArrayList;)V", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "applyUserAction", "", "event", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "dispatchSuccessResult", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "initReportInfo", "onGetSubscribeMsgListSuccess", "release", "reportSubscribeAuth", "showType", AppMeasurement.Param.TIMESTAMP, "", "run", "setFromScene", "fromScene", "showAlertDialog", "title", "okOnClickListener", "Landroid/content/DialogInterface$OnClickListener;", "showSettingPageAlert", "callback", "Lkotlin/Function0;", "showSubscribeRequestDialog", "showSuccessToast", "msg", "showToast", "Companion", "plugin-comm_release"})
    public static final class b {
        public static final C0466a jAa = new C0466a((byte) 0);
        private int action;
        private byte[] buffer;
        private final String content;
        private final Context context;
        private String dVu;
        private final String extInfo;
        public int gwE;
        ArrayList<SubscribeMsgTmpItem> jzR;
        private ArrayList<String> jzS;
        public com.tencent.mm.ui.widget.a.d jzT;
        public com.tencent.mm.msgsubscription.ui.b jzU;
        private com.tencent.mm.plugin.appbrand.widget.dialog.e jzV;
        private com.tencent.mm.msgsubscription.b.a jzW;
        private a.C0469a jzX;
        private final String jzY;
        private final AbstractC0465a jzZ;
        private SubscribeMsgRequestDialogUiData jzc;
        private final String jzp;

        static {
            AppMethodBeat.i(223313);
            AppMethodBeat.o(223313);
        }

        public b(Context context2, int i2, String str, String str2, String str3, String str4, String str5, AbstractC0465a aVar) {
            kotlin.g.b.p.h(context2, "context");
            kotlin.g.b.p.h(str, "bizUsername");
            kotlin.g.b.p.h(str2, "bizAppId");
            kotlin.g.b.p.h(str3, "subscribeUrl");
            kotlin.g.b.p.h(str4, "content");
            kotlin.g.b.p.h(str5, IssueStorage.COLUMN_EXT_INFO);
            AppMethodBeat.i(223311);
            this.context = context2;
            this.action = i2;
            this.dVu = str;
            this.jzY = str2;
            this.jzp = str3;
            this.content = str4;
            this.extInfo = str5;
            this.jzZ = aVar;
            this.jzS = new ArrayList<>();
            com.tencent.mm.msgsubscription.api.b bVar = com.tencent.mm.msgsubscription.api.b.jza;
            this.jzW = com.tencent.mm.msgsubscription.api.b.Ru("name_biz");
            this.buffer = new byte[]{0};
            this.jzX = new a.C0469a();
            AppMethodBeat.o(223311);
        }

        public static final /* synthetic */ void a(b bVar, Context context2, int i2, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(223315);
            bVar.a(context2, i2, subscribeMsgRequestResult);
            AppMethodBeat.o(223315);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public b(Context context2, int i2, String str, ArrayList<String> arrayList, String str2, AbstractC0465a aVar) {
            this(context2, i2, "", str, "", "", str2, aVar);
            kotlin.g.b.p.h(context2, "context");
            kotlin.g.b.p.h(str, "bizAppId");
            kotlin.g.b.p.h(arrayList, "templateIdList");
            kotlin.g.b.p.h(str2, IssueStorage.COLUMN_EXT_INFO);
            AppMethodBeat.i(223312);
            this.jzS.clear();
            this.jzS.addAll(arrayList);
            Log.v("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo initSubscribeMsgRequestTask templateId size: %s", Integer.valueOf(this.jzS.size()));
            AppMethodBeat.o(223312);
        }

        public final void run() {
            boolean z;
            boolean z2;
            boolean z3;
            AppMethodBeat.i(223305);
            switch (this.action) {
                case 1:
                case 3:
                    if (this.jzp.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || !this.jzS.isEmpty()) {
                        if (this.extInfo.length() > 0) {
                            String optString = new JSONObject(this.extInfo).optString(ch.COL_USERNAME);
                            kotlin.g.b.p.g(optString, ch.COL_USERNAME);
                            if (optString.length() > 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                this.dVu = optString;
                            }
                        }
                        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgTemplateList bizUsername: %s, bizAppId: %s, url: %s, templateIdList size: %s", this.dVu, this.jzY, this.jzp, Integer.valueOf(this.jzS.size()));
                        biX();
                        k kVar = new k(this);
                        if (this.dVu.length() > 0) {
                            com.tencent.mm.msgsubscription.b.a aVar = this.jzW;
                            if (aVar != null) {
                                aVar.a(this.dVu, this.jzp, this.jzS, this.extInfo, kVar);
                                AppMethodBeat.o(223305);
                                return;
                            }
                            AppMethodBeat.o(223305);
                            return;
                        }
                        if (this.jzY.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            com.tencent.mm.msgsubscription.b.a aVar2 = this.jzW;
                            if (aVar2 != null) {
                                aVar2.b(this.jzY, this.jzp, this.jzS, this.extInfo, kVar);
                                AppMethodBeat.o(223305);
                                return;
                            }
                            AppMethodBeat.o(223305);
                            return;
                        }
                        AbstractC0465a aVar3 = this.jzZ;
                        if (aVar3 != null) {
                            aVar3.i(this.action, -1, "username or appId invalid");
                            AppMethodBeat.o(223305);
                            return;
                        }
                        AppMethodBeat.o(223305);
                        return;
                    }
                    AbstractC0465a aVar4 = this.jzZ;
                    if (aVar4 != null) {
                        aVar4.i(this.action, 10001, "templateIdList empty");
                        AppMethodBeat.o(223305);
                        return;
                    }
                    AppMethodBeat.o(223305);
                    return;
                case 2:
                    Object[] objArr = new Object[3];
                    objArr[0] = this.dVu;
                    objArr[1] = this.jzY;
                    ArrayList<SubscribeMsgTmpItem> arrayList = this.jzR;
                    if (arrayList == null) {
                        kotlin.g.b.p.hyc();
                    }
                    objArr[2] = Integer.valueOf(arrayList.size());
                    Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg bizUsername: %s, appId: %s, template size: %s", objArr);
                    com.tencent.mm.msgsubscription.api.c cVar = new com.tencent.mm.msgsubscription.api.c();
                    cVar.jzd = true;
                    cVar.setUsername(this.dVu);
                    cVar.setAppId(this.jzY);
                    List<SubscribeMsgTmpItem> list = cVar.jyV;
                    ArrayList<SubscribeMsgTmpItem> arrayList2 = this.jzR;
                    if (arrayList2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    list.addAll(arrayList2);
                    cVar.jzb = true;
                    cVar.setBuffer(this.buffer);
                    cVar.jzc = this.jzc;
                    cVar.Rv(this.extInfo);
                    cVar.jze = new j(this);
                    com.tencent.mm.msgsubscription.b.a aVar5 = this.jzW;
                    if (aVar5 != null) {
                        aVar5.a(cVar);
                        AppMethodBeat.o(223305);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(223305);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$run$opCallback$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
        public static final class k implements com.tencent.mm.msgsubscription.api.a {
            final /* synthetic */ b jAb;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            k(b bVar) {
                this.jAb = bVar;
            }

            @Override // com.tencent.mm.msgsubscription.api.a
            public final void a(String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
                AppMethodBeat.i(223297);
                kotlin.g.b.p.h(str, "bizUsername");
                kotlin.g.b.p.h(subscribeMsgRequestResult, "result");
                Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgTemplateList onSuccess bizUsername: %s, size: %d", str, Integer.valueOf(subscribeMsgRequestResult.jyk.size()));
                b.a(this.jAb, this.jAb.action, subscribeMsgRequestResult);
                AppMethodBeat.o(223297);
            }

            @Override // com.tencent.mm.msgsubscription.api.a
            public final void i(int i2, int i3, String str) {
                boolean z;
                AppMethodBeat.i(223298);
                kotlin.g.b.p.h(str, "errMsg");
                Log.e("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo getSubscribeMsgTemplateList onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                AbstractC0465a aVar = this.jAb.jzZ;
                if (aVar != null) {
                    int i4 = this.jAb.action;
                    if (str.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        str = "get subscribe msg list failed";
                    }
                    aVar.i(i4, 10002, str);
                    AppMethodBeat.o(223298);
                    return;
                }
                AppMethodBeat.o(223298);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$run$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
        public static final class j implements com.tencent.mm.msgsubscription.api.a {
            final /* synthetic */ b jAb;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            j(b bVar) {
                this.jAb = bVar;
            }

            @Override // com.tencent.mm.msgsubscription.api.a
            public final void a(String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
                AppMethodBeat.i(223295);
                kotlin.g.b.p.h(str, "bizUsername");
                kotlin.g.b.p.h(subscribeMsgRequestResult, "result");
                Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg success bizUsername: %s, template size: %d", str, Integer.valueOf(subscribeMsgRequestResult.jyk.size()));
                b.a(this.jAb, this.jAb.context, this.jAb.action, subscribeMsgRequestResult);
                AppMethodBeat.o(223295);
            }

            @Override // com.tencent.mm.msgsubscription.api.a
            public final void i(int i2, int i3, String str) {
                boolean z;
                AppMethodBeat.i(223296);
                kotlin.g.b.p.h(str, "errMsg");
                Log.e("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo doSubscribeMsg onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                AbstractC0465a aVar = this.jAb.jzZ;
                if (aVar != null) {
                    int i4 = this.jAb.action;
                    if (str.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        str = "subscribe failed";
                    }
                    aVar.i(i4, ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, str);
                    AppMethodBeat.o(223296);
                    return;
                }
                AppMethodBeat.o(223296);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        /* renamed from: com.tencent.mm.msgsubscription.b.a.a$b$b  reason: collision with other inner class name */
        public static final class DialogInterface$OnClickListenerC0467b implements DialogInterface.OnClickListener {
            final /* synthetic */ b jAb;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ int jAd;

            DialogInterface$OnClickListenerC0467b(b bVar, SubscribeMsgRequestResult subscribeMsgRequestResult, int i2) {
                this.jAb = bVar;
                this.jAc = subscribeMsgRequestResult;
                this.jAd = i2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(223287);
                if (this.jAc.jyu == 0) {
                    AbstractC0465a aVar = this.jAb.jzZ;
                    if (aVar != null) {
                        aVar.a(false, this.jAc);
                        AppMethodBeat.o(223287);
                        return;
                    }
                    AppMethodBeat.o(223287);
                    return;
                }
                AbstractC0465a aVar2 = this.jAb.jzZ;
                if (aVar2 != null) {
                    aVar2.i(this.jAd, this.jAc.jyu, this.jAc.jyv);
                    AppMethodBeat.o(223287);
                    return;
                }
                AppMethodBeat.o(223287);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        public static final class h implements DialogInterface.OnClickListener {
            final /* synthetic */ b jAb;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ int jAd;

            h(b bVar, SubscribeMsgRequestResult subscribeMsgRequestResult, int i2) {
                this.jAb = bVar;
                this.jAc = subscribeMsgRequestResult;
                this.jAd = i2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(223293);
                if (this.jAc.jyu == 0) {
                    AbstractC0465a aVar = this.jAb.jzZ;
                    if (aVar != null) {
                        aVar.b(this.jAc);
                        AppMethodBeat.o(223293);
                        return;
                    }
                    AppMethodBeat.o(223293);
                    return;
                }
                AbstractC0465a aVar2 = this.jAb.jzZ;
                if (aVar2 != null) {
                    aVar2.i(this.jAd, this.jAc.jyu, this.jAc.jyv);
                    AppMethodBeat.o(223293);
                    return;
                }
                AppMethodBeat.o(223293);
            }
        }

        private static void a(Context context2, String str, String str2, DialogInterface.OnClickListener onClickListener) {
            String string;
            AppMethodBeat.i(223307);
            if (str2.length() > 0) {
                string = str2;
            } else {
                string = context2.getString(R.string.hjh);
                kotlin.g.b.p.g(string, "context.getString(R.stri…sg_alert_default_content)");
            }
            com.tencent.mm.ui.base.h.a(context2, string, str, context2.getResources().getString(R.string.w1), false, onClickListener);
            AppMethodBeat.o(223307);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        public static final class l implements DialogInterface.OnClickListener {
            final /* synthetic */ Context $context;
            final /* synthetic */ kotlin.g.a.a ihE;
            final /* synthetic */ b jAb;
            final /* synthetic */ SubscribeMsgRequestResult jAc;

            l(b bVar, kotlin.g.a.a aVar, Context context, SubscribeMsgRequestResult subscribeMsgRequestResult) {
                this.jAb = bVar;
                this.ihE = aVar;
                this.$context = context;
                this.jAc = subscribeMsgRequestResult;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(223299);
                com.tencent.mm.ui.widget.a.d dVar = this.jAb.jzT;
                if (dVar != null) {
                    dVar.dismiss();
                }
                this.ihE.invoke();
                com.tencent.mm.msgsubscription.api.b bVar = com.tencent.mm.msgsubscription.api.b.jza;
                com.tencent.mm.msgsubscription.b.a Ru = com.tencent.mm.msgsubscription.api.b.Ru("name_biz");
                if (Ru != null) {
                    Ru.a(this.$context, 3, this.jAb.dVu, this.jAc.appName);
                    AppMethodBeat.o(223299);
                    return;
                }
                AppMethodBeat.o(223299);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
        public static final class m implements DialogInterface.OnClickListener {
            final /* synthetic */ kotlin.g.a.a ihE;

            m(kotlin.g.a.a aVar) {
                this.ihE = aVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(223300);
                this.ihE.invoke();
                AppMethodBeat.o(223300);
            }
        }

        private final void g(String str, kotlin.g.a.a<x> aVar) {
            boolean z;
            AppMethodBeat.i(223308);
            if (str.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Toast.makeText(this.context, str, 0).show();
            }
            aVar.invoke();
            AppMethodBeat.o(223308);
        }

        private final void biX() {
            AppMethodBeat.i(223309);
            this.jzX.Rx(this.dVu);
            this.jzX.Ry(this.jzY);
            try {
                if (this.extInfo.length() > 0) {
                    JSONObject jSONObject = new JSONObject(this.extInfo);
                    a.C0469a aVar = this.jzX;
                    String optString = jSONObject.optString("sessionid");
                    kotlin.g.b.p.g(optString, "data.optString(\"sessionid\")");
                    aVar.setSessionId(optString);
                    AppMethodBeat.o(223309);
                    return;
                }
            } catch (Exception e2) {
            }
            AppMethodBeat.o(223309);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$2", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "isCancelable", "", "plugin-comm_release"})
        public static final class n extends com.tencent.mm.msgsubscription.ui.b {
            final /* synthetic */ Context $context;
            final /* synthetic */ b jAb;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ List jAe;
            final /* synthetic */ boolean jAf;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            n(b bVar, Context context, List list, SubscribeMsgRequestResult subscribeMsgRequestResult, boolean z, Context context2, List list2, b.d dVar, boolean z2) {
                super(context2, list2, dVar, z2);
                this.jAb = bVar;
                this.$context = context;
                this.jAe = list;
                this.jAc = subscribeMsgRequestResult;
                this.jAf = z;
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k, com.tencent.mm.msgsubscription.ui.b
            public final boolean isCancelable() {
                return true;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$3", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "onEvent", "", "event", "", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "plugin-comm_release"})
        public static final class o implements b.d {
            final /* synthetic */ b jAb;
            final /* synthetic */ SubscribeMsgRequestResult jAc;

            o(b bVar, SubscribeMsgRequestResult subscribeMsgRequestResult) {
                this.jAb = bVar;
                this.jAc = subscribeMsgRequestResult;
            }

            @Override // com.tencent.mm.msgsubscription.ui.b.d
            public final void c(int i2, List<b.C0477b> list) {
                int i3;
                int i4 = 0;
                AppMethodBeat.i(223301);
                kotlin.g.b.p.h(list, "resultData");
                Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog onEvent: %s, result size: %s", Integer.valueOf(i2), Integer.valueOf(list.size()));
                switch (i2) {
                    case 1:
                    case 2:
                    case 3:
                        b.e(list, this.jAc.jyk);
                        this.jAb.jzR = this.jAc.jyk;
                        this.jAb.action = a.un(this.jAb.action);
                        this.jAb.buffer = this.jAc.buffer;
                        b bVar = this.jAb;
                        SubscribeMsgRequestDialogUiData.a aVar = SubscribeMsgRequestDialogUiData.jyc;
                        List v = kotlin.a.j.v((Collection) list);
                        com.tencent.mm.msgsubscription.ui.b bVar2 = this.jAb.jzU;
                        bVar.jzc = SubscribeMsgRequestDialogUiData.a.a(i2, v, bVar2 != null ? bVar2.jCa.isChecked() : false);
                        a aVar2 = a.jzQ;
                        a.b(this.jAb);
                        if (!this.jAc.jyl) {
                            a.C0469a aVar3 = this.jAb.jzX;
                            com.tencent.mm.msgsubscription.ui.b bVar3 = this.jAb.jzU;
                            if (bVar3 == null || !bVar3.jCa.isChecked()) {
                                i3 = 0;
                            } else {
                                i3 = 1;
                            }
                            aVar3.jAt = i3;
                        } else {
                            this.jAb.jzX.jAt = 2;
                        }
                        switch (i2) {
                            case 1:
                                i4 = 2;
                                break;
                            case 2:
                                i4 = 3;
                                break;
                            case 3:
                                i4 = 4;
                                break;
                        }
                        com.tencent.mm.msgsubscription.c.a aVar4 = com.tencent.mm.msgsubscription.c.a.jAr;
                        com.tencent.mm.msgsubscription.c.a.a(i4, this.jAb.jzX);
                        break;
                }
                AppMethodBeat.o(223301);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$4", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "onDismiss", "", "onShow", "plugin-comm_release"})
        public static final class p implements b.e {
            final /* synthetic */ b jAb;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            p(b bVar) {
                this.jAb = bVar;
            }

            @Override // com.tencent.mm.msgsubscription.ui.b.e
            public final void onShow() {
                AppMethodBeat.i(223302);
                AbstractC0465a aVar = this.jAb.jzZ;
                if (aVar != null) {
                    aVar.a(this.jAb.jzU, this.jAb.jzV);
                }
                com.tencent.mm.msgsubscription.c.a aVar2 = com.tencent.mm.msgsubscription.c.a.jAr;
                com.tencent.mm.msgsubscription.c.a.a(1, this.jAb.jzX);
                AppMethodBeat.o(223302);
            }

            @Override // com.tencent.mm.msgsubscription.ui.b.e
            public final void onDismiss() {
                AppMethodBeat.i(223303);
                AbstractC0465a aVar = this.jAb.jzZ;
                if (aVar != null) {
                    aVar.biV();
                    AppMethodBeat.o(223303);
                    return;
                }
                AppMethodBeat.o(223303);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$showSubscribeRequestDialog$5", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "onSampleShow", "", "templateId", "", "check", "", FirebaseAnalytics.b.INDEX, "", "plugin-comm_release"})
        public static final class q implements b.a.AbstractC0476a {
            final /* synthetic */ b jAb;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            q(b bVar) {
                this.jAb = bVar;
            }

            @Override // com.tencent.mm.msgsubscription.ui.b.a.AbstractC0476a
            public final void aC(String str, int i2) {
                AppMethodBeat.i(223304);
                kotlin.g.b.p.h(str, "templateId");
                com.tencent.mm.msgsubscription.c.a aVar = com.tencent.mm.msgsubscription.c.a.jAr;
                com.tencent.mm.msgsubscription.c.a.ur(i2);
                com.tencent.mm.msgsubscription.c.a aVar2 = com.tencent.mm.msgsubscription.c.a.jAr;
                com.tencent.mm.msgsubscription.c.a.a(5, this.jAb.jzX);
                AppMethodBeat.o(223304);
            }
        }

        private final void E(int i2, long j2) {
            AppMethodBeat.i(223310);
            if (this.gwE == 1) {
                com.tencent.mm.msgsubscription.c.a aVar = com.tencent.mm.msgsubscription.c.a.jAr;
                com.tencent.mm.msgsubscription.c.a.a(this.dVu, i2, this.content, j2);
            }
            AppMethodBeat.o(223310);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask$Companion;", "", "()V", "ACTION_ERROR", "", "ACTION_FINISHED", "ACTION_GET_AND_SUBSCRIBE", "ACTION_GET_SUBSCRIBE_MSG_LIST", "ACTION_SUBSCRIBE_MSG", "Action", "plugin-comm_release"})
        /* renamed from: com.tencent.mm.msgsubscription.b.a.a$b$a  reason: collision with other inner class name */
        public static final class C0466a {
            private C0466a() {
            }

            public /* synthetic */ C0466a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ b jAb;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ int jAd;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(b bVar, SubscribeMsgRequestResult subscribeMsgRequestResult, int i2) {
                super(0);
                this.jAb = bVar;
                this.jAc = subscribeMsgRequestResult;
                this.jAd = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(223288);
                if (this.jAc.jyu == 0) {
                    AbstractC0465a aVar = this.jAb.jzZ;
                    if (aVar != null) {
                        aVar.a(false, this.jAc);
                    }
                } else {
                    AbstractC0465a aVar2 = this.jAb.jzZ;
                    if (aVar2 != null) {
                        aVar2.i(this.jAd, this.jAc.jyu, this.jAc.jyv);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(223288);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ b jAb;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ int jAd;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(b bVar, SubscribeMsgRequestResult subscribeMsgRequestResult, int i2) {
                super(0);
                this.jAb = bVar;
                this.jAc = subscribeMsgRequestResult;
                this.jAd = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(223289);
                if (this.jAc.jyu == 0) {
                    AbstractC0465a aVar = this.jAb.jzZ;
                    if (aVar != null) {
                        aVar.a(false, this.jAc);
                    }
                } else {
                    AbstractC0465a aVar2 = this.jAb.jzZ;
                    if (aVar2 != null) {
                        aVar2.i(this.jAd, this.jAc.jyu, this.jAc.jyv);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(223289);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ b jAb;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ int jAd;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(b bVar, SubscribeMsgRequestResult subscribeMsgRequestResult, int i2) {
                super(0);
                this.jAb = bVar;
                this.jAc = subscribeMsgRequestResult;
                this.jAd = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(223290);
                if (this.jAc.jyu == 0) {
                    AbstractC0465a aVar = this.jAb.jzZ;
                    if (aVar != null) {
                        aVar.a(false, this.jAc);
                    }
                } else {
                    AbstractC0465a aVar2 = this.jAb.jzZ;
                    if (aVar2 != null) {
                        aVar2.i(this.jAd, this.jAc.jyu, this.jAc.jyv);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(223290);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ b jAb;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ int jAd;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(b bVar, SubscribeMsgRequestResult subscribeMsgRequestResult, int i2) {
                super(0);
                this.jAb = bVar;
                this.jAc = subscribeMsgRequestResult;
                this.jAd = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(223291);
                if (this.jAc.jyu == 0) {
                    AbstractC0465a aVar = this.jAb.jzZ;
                    if (aVar != null) {
                        aVar.a(false, this.jAc);
                    }
                } else {
                    AbstractC0465a aVar2 = this.jAb.jzZ;
                    if (aVar2 != null) {
                        aVar2.i(this.jAd, this.jAc.jyu, this.jAc.jyv);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(223291);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class g extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ b jAb;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ int jAd;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(b bVar, SubscribeMsgRequestResult subscribeMsgRequestResult, int i2) {
                super(0);
                this.jAb = bVar;
                this.jAc = subscribeMsgRequestResult;
                this.jAd = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(223292);
                if (this.jAc.jyu == 0) {
                    AbstractC0465a aVar = this.jAb.jzZ;
                    if (aVar != null) {
                        aVar.b(this.jAc);
                    }
                } else {
                    AbstractC0465a aVar2 = this.jAb.jzZ;
                    if (aVar2 != null) {
                        aVar2.i(this.jAd, this.jAc.jyu, this.jAc.jyv);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(223292);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class i extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ b jAb;
            final /* synthetic */ SubscribeMsgRequestResult jAc;
            final /* synthetic */ int jAd;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            i(b bVar, SubscribeMsgRequestResult subscribeMsgRequestResult, int i2) {
                super(0);
                this.jAb = bVar;
                this.jAc = subscribeMsgRequestResult;
                this.jAd = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(223294);
                if (this.jAc.jyu == 0) {
                    AbstractC0465a aVar = this.jAb.jzZ;
                    if (aVar != null) {
                        aVar.b(this.jAc);
                    }
                } else {
                    AbstractC0465a aVar2 = this.jAb.jzZ;
                    if (aVar2 != null) {
                        aVar2.i(this.jAd, this.jAc.jyu, this.jAc.jyv);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(223294);
                return xVar;
            }
        }

        private final void a(Context context2, int i2, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            int i3;
            int i4;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            int i5;
            com.tencent.mm.msgsubscription.ui.b bVar;
            Boolean bool;
            boolean z;
            boolean z2;
            int i6;
            boolean z3;
            int i7;
            boolean z4;
            AppMethodBeat.i(223306);
            ShowInfo showInfo = subscribeMsgRequestResult.jyr;
            if (showInfo != null) {
                i3 = showInfo.dDG;
            } else {
                i3 = -1;
            }
            AbstractC0465a aVar = this.jzZ;
            if (aVar != null) {
                aVar.biW();
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo dispatchSuccessResult showType: %s, action: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(subscribeMsgRequestResult.jyu), subscribeMsgRequestResult.jyv);
            if (!a.uo(i2)) {
                if (a.up(i2)) {
                    if (i3 == 4) {
                        E(5, currentTimeMillis);
                        ShowInfo showInfo2 = subscribeMsgRequestResult.jyr;
                        if (showInfo2 == null || (str7 = showInfo2.jxS) == null) {
                            str7 = "";
                        }
                        g gVar = new g(this, subscribeMsgRequestResult, i2);
                        if (str7.length() > 0) {
                            u.cG(this.context, str7);
                        }
                        gVar.invoke();
                        AppMethodBeat.o(223306);
                        return;
                    } else if (i3 == 1) {
                        E(2, currentTimeMillis);
                        ShowInfo showInfo3 = subscribeMsgRequestResult.jyr;
                        if (showInfo3 == null || (str6 = showInfo3.jxR) == null) {
                            str3 = "";
                        } else {
                            str3 = str6;
                        }
                        ShowInfo showInfo4 = subscribeMsgRequestResult.jyr;
                        if (showInfo4 == null || (str5 = showInfo4.jxS) == null) {
                            str4 = "";
                        } else {
                            str4 = str5;
                        }
                        a(context2, str3, str4, new h(this, subscribeMsgRequestResult, i2));
                        AppMethodBeat.o(223306);
                        return;
                    } else if (i3 == 2) {
                        E(3, currentTimeMillis);
                        ShowInfo showInfo5 = subscribeMsgRequestResult.jyr;
                        if (showInfo5 == null || (str2 = showInfo5.jxS) == null) {
                            str = "";
                        } else {
                            str = str2;
                        }
                        g(str, new i(this, subscribeMsgRequestResult, i2));
                        AppMethodBeat.o(223306);
                        return;
                    } else {
                        if (i3 == 0) {
                            i4 = 1;
                        } else if (i3 == 3) {
                            i4 = 4;
                        } else {
                            i4 = -1;
                        }
                        E(i4, currentTimeMillis);
                        if (subscribeMsgRequestResult.jyu == 0) {
                            AbstractC0465a aVar2 = this.jzZ;
                            if (aVar2 != null) {
                                aVar2.b(subscribeMsgRequestResult);
                                AppMethodBeat.o(223306);
                                return;
                            }
                            AppMethodBeat.o(223306);
                            return;
                        }
                        AbstractC0465a aVar3 = this.jzZ;
                        if (aVar3 != null) {
                            aVar3.i(i2, subscribeMsgRequestResult.jyu, subscribeMsgRequestResult.jyv);
                            AppMethodBeat.o(223306);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(223306);
            } else if (i3 == 0) {
                if (subscribeMsgRequestResult.jyu == 0) {
                    E(1, currentTimeMillis);
                    if (subscribeMsgRequestResult.jyk.isEmpty()) {
                        Log.w("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog list is empty and not show dialog");
                        AbstractC0465a aVar4 = this.jzZ;
                        if (aVar4 != null) {
                            aVar4.i(this.action, 10002, "template list empty");
                        }
                        z = false;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (T t : subscribeMsgRequestResult.jyk) {
                            Log.v("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog templateId: %s, chooseStatus: %d", t.ixM, Integer.valueOf(t.jyd));
                            if (t.jyd == 1) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            arrayList.add(new b.C0477b(z4, t.title, t.jyA, t.ixM));
                            this.jzX.jzS.add(t.ixM);
                            this.jzX.jAs.add(Integer.valueOf(t.jyd == 0 ? 0 : 1));
                        }
                        SubscribeMsgTmpItem subscribeMsgTmpItem = (SubscribeMsgTmpItem) kotlin.a.j.kt(subscribeMsgRequestResult.jyk);
                        if (subscribeMsgTmpItem != null) {
                            i5 = subscribeMsgTmpItem.jyz;
                        } else {
                            i5 = 2;
                        }
                        boolean z5 = arrayList.size() == 1 && subscribeMsgRequestResult.jyq == 1;
                        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeRequestDialog size: %d, showStyle: %d, singleMode: %b, templateType: %d", Integer.valueOf(arrayList.size()), Integer.valueOf(subscribeMsgRequestResult.jyq), Boolean.valueOf(z5), Integer.valueOf(i5));
                        this.jzU = new n(this, context2, arrayList, subscribeMsgRequestResult, z5, context2, arrayList, new o(this, subscribeMsgRequestResult), z5);
                        com.tencent.mm.msgsubscription.ui.b bVar2 = this.jzU;
                        if (bVar2 != null) {
                            bVar2.jCr = new p(this);
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar3 = this.jzU;
                        if (bVar3 != null) {
                            String str18 = subscribeMsgRequestResult.jys;
                            if (str18 == null) {
                                str18 = "";
                            }
                            bVar3.setDesc(str18);
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar4 = this.jzU;
                        if (bVar4 != null) {
                            String str19 = subscribeMsgRequestResult.jyt;
                            if (str19 == null) {
                                str19 = "";
                            }
                            bVar4.RK(str19);
                        }
                        if (z5) {
                            ((b.C0477b) kotlin.a.j.ks(arrayList)).jCx = true;
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar5 = this.jzU;
                        if (bVar5 != null) {
                            bVar5.RD(subscribeMsgRequestResult.appName);
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar6 = this.jzU;
                        if (bVar6 != null) {
                            bVar6.setIconUrl(subscribeMsgRequestResult.jyi);
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar7 = this.jzU;
                        if (bVar7 != null) {
                            WordingInfo wordingInfo = subscribeMsgRequestResult.jyn;
                            if (wordingInfo == null) {
                                kotlin.g.b.p.hyc();
                            }
                            bVar7.RH(wordingInfo.jyH);
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar8 = this.jzU;
                        if (bVar8 != null) {
                            WordingInfo wordingInfo2 = subscribeMsgRequestResult.jyn;
                            if (wordingInfo2 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            bVar8.RI(wordingInfo2.jyI);
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar9 = this.jzU;
                        if (bVar9 != null) {
                            WordingInfo wordingInfo3 = subscribeMsgRequestResult.jyn;
                            if (wordingInfo3 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            bVar9.RJ(wordingInfo3.jyJ);
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar10 = this.jzU;
                        if (bVar10 != null) {
                            bVar10.jCq = R.drawable.bca;
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar11 = this.jzU;
                        if (bVar11 != null) {
                            WordingInfo wordingInfo4 = subscribeMsgRequestResult.jyn;
                            if (wordingInfo4 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            String str20 = wordingInfo4.jyL;
                            if (str20 == null) {
                                str20 = "";
                            }
                            bVar11.RE(str20);
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar12 = this.jzU;
                        if (bVar12 != null) {
                            if (!subscribeMsgRequestResult.jyl) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            bVar12.jCj = z3;
                            View view = bVar12.jBZ;
                            if (bVar12.jCj) {
                                i7 = 0;
                            } else {
                                i7 = 8;
                            }
                            view.setVisibility(i7);
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar13 = this.jzU;
                        if (bVar13 != null) {
                            if (!subscribeMsgRequestResult.jym) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            bVar13.jCl = z2;
                            TextView textView = bVar13.jBY;
                            if (bVar13.jCl) {
                                i6 = 0;
                            } else {
                                i6 = 8;
                            }
                            textView.setVisibility(i6);
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar14 = this.jzU;
                        if (bVar14 == null || !bVar14.jCj) {
                            com.tencent.mm.msgsubscription.ui.b bVar15 = this.jzU;
                            if (!(bVar15 == null || !bVar15.jCl || (bVar = this.jzU) == null)) {
                                WordingInfo wordingInfo5 = subscribeMsgRequestResult.jyn;
                                if (wordingInfo5 == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                bVar.RG(wordingInfo5.jyM);
                            }
                        } else {
                            com.tencent.mm.msgsubscription.ui.b bVar16 = this.jzU;
                            if (bVar16 != null) {
                                WordingInfo wordingInfo6 = subscribeMsgRequestResult.jyn;
                                if (wordingInfo6 == null) {
                                    kotlin.g.b.p.hyc();
                                }
                                bVar16.RF(wordingInfo6.jyK);
                            }
                        }
                        Object[] objArr = new Object[2];
                        com.tencent.mm.msgsubscription.ui.b bVar17 = this.jzU;
                        objArr[0] = bVar17 != null ? Boolean.valueOf(bVar17.jCj) : null;
                        com.tencent.mm.msgsubscription.ui.b bVar18 = this.jzU;
                        if (bVar18 != null) {
                            bool = Boolean.valueOf(bVar18.jCl);
                        } else {
                            bool = null;
                        }
                        objArr[1] = bool;
                        Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo showSubscribeMsgRequestDialog showAlways: %s, showReject: %s", objArr);
                        com.tencent.mm.msgsubscription.ui.b bVar19 = this.jzU;
                        if (bVar19 != null) {
                            bVar19.jCg = new q(this);
                        }
                        if (this.jzV == null) {
                            this.jzV = new com.tencent.mm.plugin.appbrand.widget.dialog.e(context2);
                            if (context2 instanceof Activity) {
                                ((Activity) context2).addContentView(this.jzV, new ViewGroup.LayoutParams(-1, -2));
                            }
                        }
                        com.tencent.mm.msgsubscription.ui.b bVar20 = this.jzU;
                        if (bVar20 != null) {
                            bVar20.setPosition(2);
                        }
                        com.tencent.mm.plugin.appbrand.widget.dialog.e eVar = this.jzV;
                        if (eVar != null) {
                            eVar.b(this.jzU);
                        }
                        com.tencent.mm.msgsubscription.c.a aVar5 = com.tencent.mm.msgsubscription.c.a.jAr;
                        com.tencent.mm.msgsubscription.c.a.uq(arrayList.size());
                        z = true;
                    }
                    AbstractC0465a aVar6 = this.jzZ;
                    if (aVar6 != null) {
                        aVar6.a(z, subscribeMsgRequestResult);
                        AppMethodBeat.o(223306);
                        return;
                    }
                    AppMethodBeat.o(223306);
                    return;
                }
                AbstractC0465a aVar7 = this.jzZ;
                if (aVar7 != null) {
                    aVar7.i(i2, subscribeMsgRequestResult.jyu, subscribeMsgRequestResult.jyv);
                    AppMethodBeat.o(223306);
                    return;
                }
                AppMethodBeat.o(223306);
            } else if (i3 == 1) {
                E(2, currentTimeMillis);
                ShowInfo showInfo6 = subscribeMsgRequestResult.jyr;
                if (showInfo6 == null || (str17 = showInfo6.jxR) == null) {
                    str14 = "";
                } else {
                    str14 = str17;
                }
                ShowInfo showInfo7 = subscribeMsgRequestResult.jyr;
                if (showInfo7 == null || (str16 = showInfo7.jxS) == null) {
                    str15 = "";
                } else {
                    str15 = str16;
                }
                a(context2, str14, str15, new DialogInterface$OnClickListenerC0467b(this, subscribeMsgRequestResult, i2));
                AppMethodBeat.o(223306);
            } else if (i3 == 2) {
                E(3, currentTimeMillis);
                ShowInfo showInfo8 = subscribeMsgRequestResult.jyr;
                if (showInfo8 == null || (str13 = showInfo8.jxS) == null) {
                    str12 = "";
                } else {
                    str12 = str13;
                }
                g(str12, new c(this, subscribeMsgRequestResult, i2));
                AppMethodBeat.o(223306);
            } else if (i3 == 4) {
                E(5, currentTimeMillis);
                ShowInfo showInfo9 = subscribeMsgRequestResult.jyr;
                if (showInfo9 == null || (str11 = showInfo9.jxS) == null) {
                    str10 = "";
                } else {
                    str10 = str11;
                }
                g(str10, new d(this, subscribeMsgRequestResult, i2));
                AppMethodBeat.o(223306);
            } else if (i3 == 3) {
                E(4, currentTimeMillis);
                e eVar2 = new e(this, subscribeMsgRequestResult, i2);
                ShowInfo showInfo10 = subscribeMsgRequestResult.jyr;
                if (showInfo10 != null) {
                    str8 = showInfo10.jxS;
                } else {
                    str8 = null;
                }
                ShowInfo showInfo11 = subscribeMsgRequestResult.jyr;
                if (showInfo11 != null) {
                    str9 = showInfo11.jxR;
                } else {
                    str9 = null;
                }
                this.jzT = com.tencent.mm.ui.base.h.a(context2, str8, str9, context2.getString(R.string.hjg), context2.getString(R.string.sz), false, (DialogInterface.OnClickListener) new l(this, eVar2, context2, subscribeMsgRequestResult), (DialogInterface.OnClickListener) new m(eVar2));
                com.tencent.mm.ui.widget.a.d dVar = this.jzT;
                if (dVar != null) {
                    dVar.setCanceledOnTouchOutside(false);
                    AppMethodBeat.o(223306);
                    return;
                }
                AppMethodBeat.o(223306);
            } else {
                E(-1, currentTimeMillis);
                String string = context2.getString(R.string.hji);
                kotlin.g.b.p.g(string, "context.getString(R.stri…ubscribe_msg_common_fail)");
                g(string, new f(this, subscribeMsgRequestResult, i2));
                AppMethodBeat.o(223306);
            }
        }

        public static final /* synthetic */ void a(b bVar, int i2, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(223314);
            if (subscribeMsgRequestResult.jyu != 0 || !subscribeMsgRequestResult.jyk.isEmpty()) {
                bVar.a(bVar.context, i2, subscribeMsgRequestResult);
                AppMethodBeat.o(223314);
                return;
            }
            bVar.jzR = subscribeMsgRequestResult.jyk;
            bVar.buffer = subscribeMsgRequestResult.buffer;
            bVar.action = 2;
            a aVar = a.jzQ;
            a.b(bVar);
            AppMethodBeat.o(223314);
        }

        public static final /* synthetic */ boolean e(List list, List list2) {
            AppMethodBeat.i(223316);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                SubscribeMsgTmpItem subscribeMsgTmpItem = (SubscribeMsgTmpItem) list2.get(i2);
                if (((b.C0477b) obj).jCx) {
                    subscribeMsgTmpItem.jyd = 1;
                } else {
                    subscribeMsgTmpItem.jyd = 0;
                }
                arrayList.add(subscribeMsgTmpItem);
                i2 = i3;
            }
            list2.clear();
            list2.addAll(arrayList);
            AppMethodBeat.o(223316);
            return true;
        }
    }
}
