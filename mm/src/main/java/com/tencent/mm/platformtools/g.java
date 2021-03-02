package com.tencent.mm.platformtools;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.provider.ContactsContract;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class g implements Runnable {
    private String dRe;
    private Account jMD;
    private a jME;
    private Context mContext;
    private String username;

    public g(Context context, Account account) {
        this(context, account, null, null);
    }

    public g(Context context, Account account, String str) {
        this(context, account, str, null);
    }

    public g(Context context, Account account, String str, String str2) {
        AppMethodBeat.i(127679);
        this.mContext = context;
        this.jMD = account;
        this.username = str;
        this.dRe = str2;
        Log.i("MicroMsg.ContactsOperations", "username = " + str + ", " + str2);
        AppMethodBeat.o(127679);
    }

    public final void run() {
        com.tencent.mm.plugin.account.friend.a.a aVar;
        AppMethodBeat.i(127680);
        Log.i("MicroMsg.ContactsOperations", "start time:".concat(String.valueOf(System.currentTimeMillis())));
        if (!com.tencent.mm.kernel.g.aAf().azp()) {
            Log.w("MicroMsg.ContactsOperations", "account not ready, quit this operation");
            Log.w("MicroMsg.ContactsOperations", "quit...");
            AppMethodBeat.o(127680);
            return;
        }
        if (Util.isNullOrNil(this.username) && Util.isNullOrNil(this.dRe)) {
            bls();
        } else if (Util.isNullOrNil(this.dRe)) {
            com.tencent.mm.plugin.account.friend.a.a SR = ((b) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SR(this.username);
            if (SR != null && !Util.isNullOrNil(SR.kdX)) {
                Sj(SR.kdX);
            }
            Log.w("MicroMsg.ContactsOperations", "quit...");
        } else {
            com.tencent.mm.plugin.account.friend.a.a SR2 = ((b) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SR(this.username);
            if (SR2 == null || Util.isNullOrNil(SR2.kdX)) {
                aVar = ((b) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SR(this.dRe);
            } else {
                aVar = SR2;
            }
            if (aVar == null || Util.isNullOrNil(aVar.kdX)) {
                Log.d("MicroMsg.ContactsOperations", "query addrupload is null " + this.username);
            } else {
                try {
                    if (!com.tencent.mm.pluginsdk.permission.b.n(this.mContext, "android.permission.READ_CONTACTS")) {
                        Log.e("MicroMsg.ContactsOperations", "no contact permission");
                    } else {
                        Cursor query = this.mContext.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter(Constants.KEY_ACCOUNT_NAME, this.jMD.name).appendQueryParameter("account_type", this.jMD.type).build(), new String[]{"sync1", "_id"}, "deleted=\"0\" AND sync1=\"" + aVar.kdX + "\"", null, null);
                        if (query == null || query.getCount() == 0) {
                            String nickName = Util.isNullOrNil(aVar.bnK()) ? aVar.getNickName() : aVar.bnK();
                            this.jME = new a(this.mContext.getContentResolver());
                            e(nickName, aVar.bnP(), aVar.kdX, this.username);
                            this.jME.execute();
                        }
                        if (query != null) {
                            query.close();
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ContactsOperations", e2, "", "");
                }
            }
            Log.w("MicroMsg.ContactsOperations", "quit...");
        }
        Log.i("MicroMsg.ContactsOperations", "end time:" + System.currentTimeMillis());
        AppMethodBeat.o(127680);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void bls() {
        /*
        // Method dump skipped, instructions count: 453
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.g.bls():void");
    }

    private void e(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(127683);
        Log.d("MicroMsg.ContactsOperations", "add wechat contact: displayname:" + str + ", phoneNum:" + str2 + ", " + str3 + ", username:" + str4);
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
        newInsert.withValue(Constants.KEY_ACCOUNT_NAME, this.jMD.name);
        newInsert.withValue("account_type", this.jMD.type);
        newInsert.withValue("sync1", str3);
        this.jME.a(newInsert.build());
        ContentProviderOperation.Builder newInsert2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        newInsert2.withValueBackReference("raw_contact_id", 0);
        newInsert2.withValue("mimetype", "vnd.android.cursor.item/name");
        newInsert2.withValue("data1", str);
        this.jME.a(newInsert2.build());
        ContentProviderOperation.Builder newInsert3 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        newInsert3.withValueBackReference("raw_contact_id", 0);
        newInsert3.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
        newInsert3.withValue("data1", str2);
        newInsert3.withValue("data2", this.mContext.getString(R.string.wx));
        newInsert3.withValue("data3", this.mContext.getString(R.string.bie));
        newInsert3.withValue("data4", str3);
        this.jME.a(newInsert3.build());
        if ("1".equals(h.aqJ().getValue("VOIPCallType"))) {
            ContentProviderOperation.Builder newInsert4 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert4.withValueBackReference("raw_contact_id", 0);
            newInsert4.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video");
            newInsert4.withValue("data1", str2);
            newInsert4.withValue("data2", this.mContext.getString(R.string.wx));
            newInsert4.withValue("data3", this.mContext.getString(R.string.big));
            newInsert4.withValue("data4", str3);
            this.jME.a(newInsert4.build());
        } else {
            ContentProviderOperation.Builder newInsert5 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert5.withValueBackReference("raw_contact_id", 0);
            newInsert5.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip");
            newInsert5.withValue("data1", str2);
            newInsert5.withValue("data2", this.mContext.getString(R.string.wx));
            newInsert5.withValue("data3", this.mContext.getString(R.string.bif));
            newInsert5.withValue("data4", str3);
            this.jME.a(newInsert5.build());
        }
        ContentProviderOperation.Builder newInsert6 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        newInsert6.withValueBackReference("raw_contact_id", 0);
        newInsert6.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline");
        newInsert6.withValue("data1", str2);
        newInsert6.withValue("data2", this.mContext.getString(R.string.wx));
        newInsert6.withValue("data3", this.mContext.getString(R.string.bih));
        newInsert6.withValue("data4", str3);
        this.jME.a(newInsert6.build());
        ContentProviderOperation.Builder newInsert7 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        newInsert7.withValueBackReference("raw_contact_id", 0);
        newInsert7.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction");
        newInsert7.withValue("data1", str2);
        newInsert7.withValue("data2", this.mContext.getString(R.string.wx));
        newInsert7.withValue("data3", "");
        newInsert7.withValue("data4", str3);
        this.jME.a(newInsert7.build());
        AppMethodBeat.o(127683);
    }

    private void Sj(String str) {
        Cursor cursor;
        AppMethodBeat.i(127684);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ContactsOperations", "delete wechat contact fail, phoneNum5 is null");
            AppMethodBeat.o(127684);
        } else if (!com.tencent.mm.pluginsdk.permission.b.n(this.mContext, "android.permission.READ_CONTACTS")) {
            Log.e("MicroMsg.ContactsOperations", "no contact permission");
            AppMethodBeat.o(127684);
        } else {
            try {
                cursor = this.mContext.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id", "_id"}, "(mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ?) AND data4 = ?", new String[]{"vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction", str}, null);
            } catch (Exception e2) {
                Log.e("MicroMsg.ContactsOperations", "query fail, match error %s \n %s", e2.getMessage(), Util.stackTraceToString(e2));
                cursor = null;
            }
            if (cursor == null) {
                Log.e("MicroMsg.ContactsOperations", "get null cursor");
                AppMethodBeat.o(127684);
                return;
            }
            try {
                if (cursor.moveToFirst()) {
                    do {
                        int columnIndex = cursor.getColumnIndex("contact_id");
                        String string = columnIndex >= 0 ? cursor.getString(columnIndex) : "";
                        int columnIndex2 = cursor.getColumnIndex("_id");
                        String string2 = columnIndex2 >= 0 ? cursor.getString(columnIndex2) : "";
                        if (!Util.isNullOrNil(string) && !Util.isNullOrNil(string2)) {
                            this.mContext.getContentResolver().delete(ContactsContract.Data.CONTENT_URI, "_id = ?", new String[]{string2});
                            this.mContext.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{string, "com.tencent.mm.account"});
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Exception e3) {
                Log.e("MicroMsg.ContactsOperations", "delete wechat contact failed : " + e3.getMessage());
            }
            cursor.close();
            AppMethodBeat.o(127684);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean Sk(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 134
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.g.Sk(java.lang.String):boolean");
    }

    public class a {
        private final String TAG = "MicroMsg.BatchOperation";
        private final ContentResolver hwt;
        ArrayList<ContentProviderOperation> jMF;

        public a(ContentResolver contentResolver) {
            AppMethodBeat.i(127676);
            this.hwt = contentResolver;
            this.jMF = new ArrayList<>();
            AppMethodBeat.o(127676);
        }

        public final void a(ContentProviderOperation contentProviderOperation) {
            AppMethodBeat.i(127677);
            this.jMF.add(contentProviderOperation);
            AppMethodBeat.o(127677);
        }

        public final void execute() {
            AppMethodBeat.i(127678);
            if (this.jMF.size() == 0) {
                Log.d("MicroMsg.BatchOperation", "no batch operation");
                AppMethodBeat.o(127678);
            } else if (!com.tencent.mm.pluginsdk.permission.b.n(g.this.mContext, "android.permission.READ_CONTACTS")) {
                Log.e("MicroMsg.BatchOperation", "no contact permission");
                AppMethodBeat.o(127678);
            } else {
                try {
                    this.hwt.applyBatch("com.android.contacts", this.jMF);
                } catch (OperationApplicationException e2) {
                    Log.e("MicroMsg.BatchOperation", "apply batch operation failed", e2.toString());
                } catch (RemoteException e3) {
                    Log.e("MicroMsg.BatchOperation", "apply batch operation failed", e3.toString());
                } catch (Exception e4) {
                    Log.e("MicroMsg.BatchOperation", "apply batch operation failed", e4.toString());
                }
                this.jMF.clear();
                AppMethodBeat.o(127678);
            }
        }
    }
}
