package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ah;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public final class h implements i {
    private Context context;
    private ProgressDialog iLh;
    a khL;

    public interface a {
        void gn(boolean z);
    }

    public h(Context context2, a aVar) {
        this.context = context2;
        this.khL = aVar;
    }

    /* access modifiers changed from: package-private */
    public final void c(Cursor cursor) {
        AppMethodBeat.i(131315);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                n nVar = new n();
                nVar.convertFrom(cursor);
                arrayList.add(nVar.field_googlegmail);
                arrayList2.add(Integer.valueOf(i2));
                arrayList3.add(nVar);
                cursor.moveToNext();
            }
            arrayList2.add(-1);
        }
        Context context2 = this.context;
        String string = this.context.getResources().getString(R.string.du6);
        this.context.getResources().getString(R.string.sz);
        com.tencent.mm.ui.base.h.a(context2, string, arrayList, arrayList2, new h.e() {
            /* class com.tencent.mm.plugin.account.friend.ui.h.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.h.e
            public final void cy(int i2, int i3) {
                AppMethodBeat.i(131312);
                if (i3 != -1) {
                    h.this.Tl(((n) arrayList3.get(i3)).field_googlegmail);
                }
                AppMethodBeat.o(131312);
            }
        });
        AppMethodBeat.o(131315);
    }

    /* access modifiers changed from: package-private */
    public final void Tl(String str) {
        AppMethodBeat.i(131316);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        final ah ahVar = new ah(arrayList);
        g.azz().a(ahVar, 0);
        Context context2 = this.context;
        this.context.getString(R.string.e4m);
        this.iLh = com.tencent.mm.ui.base.h.a(context2, this.context.getString(R.string.e4k), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.h.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(131313);
                g.azz().a(ahVar);
                h.this.khL.gn(false);
                AppMethodBeat.o(131313);
            }
        });
        AppMethodBeat.o(131316);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(131317);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        Log.i("MicroMsg.SendInviteGoogleContact", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", objArr);
        if (qVar.getType() != 489) {
            AppMethodBeat.o(131317);
            return;
        }
        if (this.iLh != null) {
            this.iLh.dismiss();
            this.iLh = null;
        }
        g.azz().b(489, this);
        if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
            com.tencent.mm.ui.base.h.a(this.context, (int) R.string.e4j, (int) R.string.zb, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.friend.ui.h.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(131314);
                    h.this.khL.gn(true);
                    AppMethodBeat.o(131314);
                }
            });
            AppMethodBeat.o(131317);
            return;
        }
        Log.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
        this.khL.gn(false);
        AppMethodBeat.o(131317);
    }
}
