package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.d;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.ui.base.h;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"3\u0010\u0002\u001a$\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, hxF = {"MENU_ID_ADD_BLACK_LIST", "", "addBlackListener", "Lkotlin/Function3;", "", "Landroid/content/Context;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "", "getAddBlackListener", "()Lkotlin/jvm/functions/Function3;", "clickFansItem", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "fansContact", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "context", "Lkotlin/Function1;", "plugin-finder_release"})
public final class b {
    private static final q<String, Context, ai<ayt>, x> vJT = a.vJU;

    public static final d a(aqr aqr, Context context, kotlin.g.a.b<? super String, x> bVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        aps aps;
        app app;
        app app2;
        app app3;
        app app4;
        FinderContact finderContact;
        aps aps2;
        AppMethodBeat.i(252327);
        p.h(aqr, "fansContact");
        p.h(context, "context");
        Intent intent = new Intent();
        FinderContact finderContact2 = aqr.contact;
        if ((finderContact2 == null || (str = finderContact2.username) == null) && ((finderContact = aqr.contact) == null || (aps2 = finderContact.msgInfo) == null || (str = aps2.LBC) == null)) {
            str = "";
        }
        intent.putExtra("Username", str);
        FinderContact finderContact3 = aqr.contact;
        if (finderContact3 == null || (str2 = finderContact3.nickname) == null) {
            str2 = "";
        }
        intent.putExtra("Nickname", str2);
        FinderContact finderContact4 = aqr.contact;
        if (finderContact4 == null || (str3 = finderContact4.headUrl) == null) {
            str3 = "";
        }
        intent.putExtra("Avatar", str3);
        FinderContact finderContact5 = aqr.contact;
        if (finderContact5 == null || (str4 = finderContact5.signature) == null) {
            str4 = "";
        }
        intent.putExtra("Signature", str4);
        FinderContact finderContact6 = aqr.contact;
        intent.putExtra("Sex", (finderContact6 == null || (app4 = finderContact6.extInfo) == null) ? 0 : app4.fuA);
        FinderContact finderContact7 = aqr.contact;
        if (finderContact7 == null || (app3 = finderContact7.extInfo) == null || (str5 = app3.fuJ) == null) {
            str5 = "";
        }
        intent.putExtra("Province", str5);
        FinderContact finderContact8 = aqr.contact;
        if (finderContact8 == null || (app2 = finderContact8.extInfo) == null || (str6 = app2.fuK) == null) {
            str6 = "";
        }
        intent.putExtra("City", str6);
        FinderContact finderContact9 = aqr.contact;
        if (finderContact9 == null || (app = finderContact9.extInfo) == null || (str7 = app.country) == null) {
            str7 = "";
        }
        intent.putExtra("Country", str7);
        if (aqr.displayFlag == 0) {
            intent.putExtra("Action", 1);
        }
        intent.putExtra("FansId", aqr.dMj);
        FinderContact finderContact10 = aqr.contact;
        if (finderContact10 == null || (str8 = finderContact10.wx_username_v5) == null) {
            str8 = "";
        }
        intent.putExtra("V5UserName", str8);
        FinderContact finderContact11 = aqr.contact;
        intent.putExtra("ContactMsgInfo", (finderContact11 == null || (aps = finderContact11.msgInfo) == null) ? null : aps.toByteArray());
        intent.putExtra("IsPoster", true);
        y yVar = y.vXH;
        d a2 = y.a(context, aqr.username, intent, bVar);
        AppMethodBeat.o(252327);
        return a2;
    }

    public static final q<String, Context, ai<ayt>, x> dzu() {
        return vJT;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "fansId", "", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "invoke"})
    static final class a extends kotlin.g.b.q implements q<String, Context, ai<ayt>, x> {
        public static final a vJU = new a();

        static {
            AppMethodBeat.i(252326);
            AppMethodBeat.o(252326);
        }

        a() {
            super(3);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(String str, Context context, ai<ayt> aiVar) {
            AppMethodBeat.i(252325);
            final String str2 = str;
            Context context2 = context;
            final ai<ayt> aiVar2 = aiVar;
            p.h(context2, "context");
            h.c(context2, context2.getString(R.string.cho), "", context2.getString(R.string.bd6), context2.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.finder.ui.b.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(252324);
                    t tVar = (t) g.af(t.class);
                    String str = str2;
                    if (str == null) {
                        str = "";
                    }
                    tVar.b(str, true, aiVar2);
                    AppMethodBeat.o(252324);
                }
            }, null);
            x xVar = x.SXb;
            AppMethodBeat.o(252325);
            return xVar;
        }
    }
}
