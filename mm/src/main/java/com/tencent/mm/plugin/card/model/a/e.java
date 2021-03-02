package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "()V", "Companion", "plugin-card_release"})
public final class e extends j<bkg> {
    private static final String TAG = TAG;
    public static final a pVr = new a((byte) 0);

    public e() {
        AppMethodBeat.i(112391);
        a(new bkf(), new bkg(), 2793, "/cgi-bin/mmpay-bin/mktgetcardentrancestyle");
        Log.i(TAG, "do get card entrance style");
        AppMethodBeat.o(112391);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "triggerGetCardEntrance", "", "force", "", "plugin-card_release"})
    public static final class a {

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "kotlin.jvm.PlatformType", "call"})
        /* renamed from: com.tencent.mm.plugin.card.model.a.e$a$a  reason: collision with other inner class name */
        public static final class C0904a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            public static final C0904a pVs = new C0904a();

            static {
                AppMethodBeat.i(112390);
                AppMethodBeat.o(112390);
            }

            C0904a() {
            }

            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(112389);
                c.a aVar = (c.a) obj;
                a aVar2 = e.pVr;
                Log.i(e.TAG, "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    bkg bkg = (bkg) aVar.iLC;
                    a aVar3 = e.pVr;
                    Log.i(e.TAG, "retCode: %s", Integer.valueOf(bkg.pTZ));
                    if (bkg.pTZ == 0) {
                        int i2 = bkg.LTt ? 1 : 0;
                        a aVar4 = e.pVr;
                        Log.i(e.TAG, "new version: %s, new version style: %s, trade area: %s, is_card_home_page_v2: %s", Boolean.valueOf(bkg.LTt), Integer.valueOf(bkg.LTu), Integer.valueOf(bkg.LTv), Boolean.valueOf(bkg.LTx));
                        com.tencent.mm.kernel.e aAh = g.aAh();
                        p.g(aAh, "MMKernel.storage()");
                        aAh.azQ().set(ar.a.USERINFO_CARD_ENTRANCE_SWITCH_INT_SYNC, Integer.valueOf(i2));
                        com.tencent.mm.kernel.e aAh2 = g.aAh();
                        p.g(aAh2, "MMKernel.storage()");
                        aAh2.azQ().set(ar.a.USERINFO_CARD_ENTRANCE_SHOW_SORT_INT_SYNC, Integer.valueOf(bkg.LTu));
                        com.tencent.mm.kernel.e aAh3 = g.aAh();
                        p.g(aAh3, "MMKernel.storage()");
                        aAh3.azQ().set(ar.a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INT_SYNC, Integer.valueOf(bkg.LTv));
                        com.tencent.mm.kernel.e aAh4 = g.aAh();
                        p.g(aAh4, "MMKernel.storage()");
                        aAh4.azQ().set(ar.a.USERINFO_CARD_ENTRANCE_SWITCH_V2_BOOLEAN_SYNC, Boolean.valueOf(bkg.LTx));
                        if (bkg.LTw != null) {
                            byte[] byteArray = bkg.LTw.toByteArray();
                            p.g(byteArray, "trade_area_version_mini_app_info.toByteArray()");
                            String str = new String(byteArray, d.ISO_8859_1);
                            com.tencent.mm.kernel.e aAh5 = g.aAh();
                            p.g(aAh5, "MMKernel.storage()");
                            aAh5.azQ().set(ar.a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INFO_STRING_SYNC, str);
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(112389);
                return xVar;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void cup() {
            AppMethodBeat.i(201370);
            Log.i(e.TAG, "trigger get card entrance: %s", Boolean.TRUE);
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(ar.a.USERINFO_CARD_ENTRANCE_LAST_TIMESTAMP_LONG_SYNC, (Object) 0L);
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Long");
                AppMethodBeat.o(201370);
                throw tVar;
            }
            ((Long) obj).longValue();
            System.currentTimeMillis();
            com.tencent.mm.kernel.e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_CARD_ENTRANCE_LAST_TIMESTAMP_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
            new e().aYI().h(C0904a.pVs);
            AppMethodBeat.o(201370);
        }
    }

    static {
        AppMethodBeat.i(112392);
        AppMethodBeat.o(112392);
    }
}
