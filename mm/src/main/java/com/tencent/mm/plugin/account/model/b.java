package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {

    public interface a {
        int dC(Context context);
    }

    /* renamed from: com.tencent.mm.plugin.account.model.b$b  reason: collision with other inner class name */
    public static final class C0522b implements a {
        private String kik;
        private int toScene;
        private Uri uri;

        public C0522b(int i2, String str, Uri uri2) {
            this.toScene = i2;
            this.kik = str;
            this.uri = uri2;
        }

        @Override // com.tencent.mm.plugin.account.model.b.a
        public final int dC(Context context) {
            AppMethodBeat.i(127812);
            g.aAf();
            if (!com.tencent.mm.kernel.a.azo() || com.tencent.mm.kernel.a.azj()) {
                Log.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not login, start bind login");
                AppMethodBeat.o(127812);
                return 3;
            } else if (Util.isNullOrNil((String) g.aAh().azQ().get(6, ""))) {
                Log.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not bind mobile, start bind mobie");
                AppMethodBeat.o(127812);
                return 2;
            } else if (!com.tencent.mm.pluginsdk.permission.b.n(context, "android.permission.READ_CONTACTS")) {
                Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contacts permission");
                AppMethodBeat.o(127812);
                return 1;
            } else if (this.uri != null) {
                Cursor query = context.getContentResolver().query(this.uri, new String[]{"contact_id", "_id", "data4"}, null, null, null);
                if (query == null) {
                    Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err");
                    AppMethodBeat.o(127812);
                    return 1;
                } else if (!query.moveToFirst()) {
                    Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err, move to first fail");
                    query.close();
                    AppMethodBeat.o(127812);
                    return 1;
                } else {
                    int columnIndex = query.getColumnIndex("data4");
                    if (columnIndex == -1) {
                        Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no data4 segment exist");
                        query.close();
                        AppMethodBeat.o(127812);
                        return 1;
                    }
                    try {
                        String string = query.getString(columnIndex);
                        int columnIndex2 = query.getColumnIndex("contact_id");
                        String string2 = columnIndex2 >= 0 ? query.getString(columnIndex2) : "";
                        int columnIndex3 = query.getColumnIndex("_id");
                        String string3 = columnIndex3 >= 0 ? query.getString(columnIndex3) : "";
                        query.close();
                        if (Util.isNullOrNil(string)) {
                            Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null friendmobile");
                            AppMethodBeat.o(127812);
                            return 1;
                        }
                        int c2 = c(context, string, string3, string2);
                        AppMethodBeat.o(127812);
                        return c2;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "match error, %s\n%s", e2.getMessage(), Util.stackTraceToString(e2));
                        Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "result friendMobileMd5 %s contact_id %s data_id %s", "", "", "");
                        query.close();
                        AppMethodBeat.o(127812);
                        return 1;
                    } catch (Throwable th) {
                        query.close();
                        AppMethodBeat.o(127812);
                        throw th;
                    }
                }
            } else if (!Util.isNullOrNil(this.kik)) {
                int c3 = c(context, com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.pluginsdk.b.Ts(this.kik).getBytes()), null, null);
                AppMethodBeat.o(127812);
                return c3;
            } else {
                Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "uri is null and the phone num is null");
                AppMethodBeat.o(127812);
                return 1;
            }
        }

        private int c(Context context, String str, String str2, String str3) {
            AppMethodBeat.i(127813);
            com.tencent.mm.plugin.account.friend.a.a SU = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(str);
            if (context == null) {
                Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null context");
                AppMethodBeat.o(127813);
                return 1;
            } else if (SU == null) {
                Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "this user is not my friend");
                AppMethodBeat.o(127813);
                return 1;
            } else {
                String username = SU.getUsername();
                if (Util.isNullOrNil(username)) {
                    Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "get username failed, phonenum md5 is ".concat(String.valueOf(str)));
                    AppMethodBeat.o(127813);
                    return 1;
                }
                if (((l) g.af(l.class)).aSN().bjG(username)) {
                    h.INSTANCE.a(11157, Integer.valueOf(this.toScene));
                    switch (this.toScene) {
                        case 1:
                            Intent intent = new Intent();
                            intent.putExtra("Chat_User", username);
                            intent.putExtra("finish_direct", true);
                            intent.addFlags(67108864);
                            com.tencent.mm.plugin.account.a.a.jRt.d(intent, context);
                            AppMethodBeat.o(127813);
                            return 0;
                        case 2:
                            Intent intent2 = new Intent();
                            intent2.putExtra("sns_userName", username);
                            intent2.addFlags(67108864);
                            intent2.putExtra("sns_adapter_type", 1);
                            c.b(context, "sns", ".ui.SnsUserUI", intent2);
                            AppMethodBeat.o(127813);
                            return 0;
                        case 3:
                            zj zjVar = new zj();
                            zjVar.efx.dKy = 5;
                            zjVar.efx.talker = username;
                            zjVar.efx.context = context;
                            zjVar.efx.eft = 3;
                            EventCenter.instance.publish(zjVar);
                            AppMethodBeat.o(127813);
                            return 0;
                        case 4:
                            zj zjVar2 = new zj();
                            zjVar2.efx.dKy = 5;
                            zjVar2.efx.talker = username;
                            zjVar2.efx.context = context;
                            zjVar2.efx.eft = 2;
                            EventCenter.instance.publish(zjVar2);
                            AppMethodBeat.o(127813);
                            return 0;
                    }
                } else if (!Util.isNullOrNil(str3) && !Util.isNullOrNil(str2)) {
                    if (!com.tencent.mm.pluginsdk.permission.b.n(context, "android.permission.READ_CONTACTS")) {
                        Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contact permission");
                        AppMethodBeat.o(127813);
                        return 1;
                    }
                    Toast.makeText(context, context.getString(R.string.bil), 1).show();
                    context.getContentResolver().delete(ContactsContract.Data.CONTENT_URI, "_id = ?", new String[]{str2});
                    context.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{str3, "com.tencent.mm.account"});
                }
                AppMethodBeat.o(127813);
                return 1;
            }
        }
    }
}
