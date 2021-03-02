package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.IntentUtil;

public final class ReportUtil {

    public static class ReportArgs implements Parcelable {
        public static final Parcelable.Creator<ReportArgs> CREATOR = new Parcelable.Creator<ReportArgs>() {
            /* class com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ReportArgs[] newArray(int i2) {
                return new ReportArgs[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ReportArgs createFromParcel(Parcel parcel) {
                AppMethodBeat.i(31084);
                ReportArgs reportArgs = new ReportArgs(parcel, (byte) 0);
                AppMethodBeat.o(31084);
                return reportArgs;
            }
        };
        public int EX;
        public String LG;
        public int errCode;
        public String openId;
        public String transaction;

        /* synthetic */ ReportArgs(Parcel parcel, byte b2) {
            this(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(31085);
            parcel.writeString(this.LG);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.transaction);
            parcel.writeString(this.openId);
            AppMethodBeat.o(31085);
        }

        static {
            AppMethodBeat.i(31087);
            AppMethodBeat.o(31087);
        }

        public ReportArgs() {
        }

        private ReportArgs(Parcel parcel) {
            AppMethodBeat.i(31086);
            this.LG = parcel.readString();
            this.errCode = parcel.readInt();
            this.transaction = parcel.readString();
            this.openId = parcel.readString();
            AppMethodBeat.o(31086);
        }
    }

    public static void ab(boolean z, int i2) {
        AppMethodBeat.i(31088);
        ad.b G = ad.aVe().G("kWXEntryActivity_data_center_session_id", true);
        if (G != null) {
            String string = G.getString("kWXEntryActivity_data_center_app_id", "");
            boolean z2 = G.getBoolean("kWXEntryActivity_data_center_can_return_cancel", false);
            int i3 = G.getInt("kWXEntryActivity_data_center_msg_type", 0);
            int i4 = G.getInt("kWXEntryActivity_data_center_scene", 0);
            if (z) {
                i2 = -2;
            }
            h.INSTANCE.a(15632, string, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(z2 ? 0 : -1));
        }
        AppMethodBeat.o(31088);
    }

    public static void a(Context context, ReportArgs reportArgs, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(31089);
        ad.b G = ad.aVe().G("kWXEntryActivity_data_center_session_id", true);
        if (G != null) {
            z2 = G.getBoolean("kWXEntryActivity_data_center_can_return_cancel", false);
        }
        ab(z, reportArgs.errCode);
        if (z2 && z) {
            reportArgs.errCode = -2;
        }
        a(context, reportArgs);
        AppMethodBeat.o(31089);
    }

    public static void a(Context context, ReportArgs reportArgs) {
        AppMethodBeat.i(31090);
        if (reportArgs.EX == 1) {
            b(context, reportArgs);
            AppMethodBeat.o(31090);
            return;
        }
        SendMessageToWX.Resp resp = new SendMessageToWX.Resp();
        resp.errCode = reportArgs.errCode;
        resp.transaction = reportArgs.transaction;
        resp.openId = reportArgs.openId;
        Bundle bundle = new Bundle();
        resp.toBundle(bundle);
        q.bo(bundle);
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.targetPkgName = reportArgs.LG;
        args.bundle = bundle;
        MMessageActV2.send(context, args);
        AppMethodBeat.o(31090);
    }

    private static void b(Context context, ReportArgs reportArgs) {
        AppMethodBeat.i(31091);
        SendAuth.Resp resp = new SendAuth.Resp();
        resp.transaction = reportArgs.transaction;
        resp.errCode = reportArgs.errCode;
        resp.openId = reportArgs.openId;
        Bundle bundle = new Bundle();
        resp.toBundle(bundle);
        q.bo(bundle);
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.targetPkgName = reportArgs.LG;
        args.bundle = bundle;
        MMessageActV2.send(context, args);
        AppMethodBeat.o(31091);
    }

    public static ReportArgs d(Bundle bundle, int i2) {
        String string;
        AppMethodBeat.i(31092);
        String string2 = bundle.getString("SendAppMessageWrapper_AppId");
        if (string2 == null && (string = bundle.getString(ConstantsAPI.CONTENT)) != null) {
            string2 = Uri.parse(string).getQueryParameter("appid");
        }
        if (string2 == null && (string2 = IntentUtil.getString(bundle, "_wxapi_payreq_appid")) == null) {
            AppMethodBeat.o(31092);
            return null;
        }
        g gVar = new g();
        gVar.field_appId = string2;
        if (!bg.aVG() || !bg.aAc()) {
            gVar.field_packageName = bundle.getString(ConstantsAPI.APP_PACKAGE);
        } else {
            ao.eAS().get(gVar, new String[0]);
        }
        ReportArgs reportArgs = new ReportArgs();
        reportArgs.LG = gVar.field_packageName;
        reportArgs.errCode = i2;
        reportArgs.transaction = bq(bundle);
        reportArgs.openId = gVar.field_openId;
        reportArgs.EX = bundle.getInt("_wxapi_command_type");
        AppMethodBeat.o(31092);
        return reportArgs;
    }

    private static String bq(Bundle bundle) {
        AppMethodBeat.i(31093);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.fromBundle(bundle);
        String str = req.transaction;
        AppMethodBeat.o(31093);
        return str;
    }
}
