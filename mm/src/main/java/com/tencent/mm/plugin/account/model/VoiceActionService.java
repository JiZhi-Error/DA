package com.tencent.mm.plugin.account.model;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class VoiceActionService extends SearchActionVerificationClientService {
    @Override // com.google.android.search.verification.client.SearchActionVerificationClientService
    public final boolean a(Intent intent, boolean z) {
        String str;
        AppMethodBeat.i(127863);
        if (!z) {
            Log.i("MicroMsg.VoiceActionService", "Action is not verified");
            AppMethodBeat.o(127863);
            return false;
        }
        String stringExtra = intent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_CHAT_ID");
        String stringExtra2 = intent.getStringExtra("android.intent.extra.TEXT");
        String username = a.getAddrUploadStg().SU(g.getMessageDigest(b.Ts(stringExtra).getBytes())).getUsername();
        com.tencent.mm.plugin.messenger.a.g.eir().ad(username, stringExtra2, ab.JG(username));
        try {
            String stringExtra3 = intent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_URI");
            String[] split = stringExtra3.split(FilePathGenerator.ANDROID_DIR_SEP);
            if (split == null || split.length <= 0) {
                str = "";
            } else {
                str = split[split.length - 1];
            }
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.VoiceActionService", "extract contact Id error, %s %s", stringExtra3, stringExtra);
            } else if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.READ_CONTACTS")) {
                Log.e("MicroMsg.VoiceActionService", "no contacts permission");
            } else {
                Cursor query = getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"_id"}, "contact_id=? AND data1=? AND account_type=? AND mimetype=?", new String[]{str, stringExtra, "com.tencent.mm.account", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction"}, null);
                if (query == null || query.getCount() <= 0) {
                    Log.i("MicroMsg.VoiceActionService", "updateContactMarked: false");
                } else {
                    query.moveToNext();
                    Log.i("MicroMsg.VoiceActionService", "updateContactMarked: %b", Boolean.valueOf(getContentResolver().update(ContactsContract.DataUsageFeedback.FEEDBACK_URI.buildUpon().appendPath(String.valueOf(query.getLong(0))).appendQueryParameter("type", "short_text").build(), new ContentValues(), null, null) > 0));
                }
                if (query != null) {
                    query.close();
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VoiceActionService", e2, "updateContactMarked error", new Object[0]);
        }
        AppMethodBeat.o(127863);
        return true;
    }
}
