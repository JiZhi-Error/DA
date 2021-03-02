package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import java.util.ArrayList;

public final class k {
    public static final String JUW = ("content://" + WeChatAuthorities.AUTHORITIES_PLUGIN_GWALLET_QUERYPROVIDER());

    public interface a {
        void Y(ArrayList<q> arrayList);
    }

    static {
        AppMethodBeat.i(223742);
        AppMethodBeat.o(223742);
    }

    public static void a(final Context context, final String[] strArr, final a aVar) {
        AppMethodBeat.i(151634);
        if (aVar == null || strArr == null || strArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(151634);
            throw illegalArgumentException;
        }
        new AsyncTask<Void, Void, Cursor>() {
            /* class com.tencent.mm.pluginsdk.model.k.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public final /* synthetic */ void onPostExecute(Cursor cursor) {
                AppMethodBeat.i(151632);
                Cursor cursor2 = cursor;
                if (cursor2 == null || cursor2.getCount() <= 0) {
                    ArrayList<q> arrayList = new ArrayList<>();
                    for (String str : strArr) {
                        arrayList.add(new q(-1, str, "", "", "", 10237));
                    }
                    aVar.Y(arrayList);
                } else {
                    cursor2.moveToFirst();
                    ArrayList<q> n = k.n(cursor2);
                    cursor2.close();
                    aVar.Y(n);
                }
                super.onPostExecute(cursor2);
                AppMethodBeat.o(151632);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
            /* access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public final /* synthetic */ Cursor doInBackground(Void[] voidArr) {
                AppMethodBeat.i(151633);
                Cursor query = context.getContentResolver().query(Uri.parse(k.JUW), null, null, strArr, null);
                AppMethodBeat.o(151633);
                return query;
            }
        }.execute(new Void[0]);
        AppMethodBeat.o(151634);
    }

    static /* synthetic */ ArrayList n(Cursor cursor) {
        AppMethodBeat.i(151635);
        if (cursor == null) {
            AppMethodBeat.o(151635);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(new q(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("product_id")), cursor.getString(cursor.getColumnIndex("full_price")), cursor.getString(cursor.getColumnIndex("price_currency")), cursor.getString(cursor.getColumnIndex("price_amount")), cursor.getInt(cursor.getColumnIndex("product_state"))));
            cursor.moveToNext();
        }
        AppMethodBeat.o(151635);
        return arrayList;
    }
}
