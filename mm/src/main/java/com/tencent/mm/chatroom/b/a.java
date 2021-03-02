package com.tencent.mm.chatroom.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.el;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.gl;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.protocal.protobuf.lu;
import com.tencent.mm.protocal.protobuf.xn;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J,\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/chatroom/api/ChatRoomOpenService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "doAppBindChatRoom", "", "context", "Landroid/content/Context;", "param", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$ChatRoomOpenParam;", "callback", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$AppBindCallback;", "doAppCreateChatRoom", "usernameListStr", "", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$HandleCallback;", "doAppUnbindChatRoom", "doCheckAppBindChatRoom", "doCheckAppJoinChatRoom", "handleGroupContactSelected", "mmOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "mockTest", "registerAppBindCallback", "sessionId", "Companion", "ui-chatroom_release"})
public final class a implements com.tencent.mm.plugin.messenger.foundation.a.c, MMActivity.a {
    public static final C0289a grw = new C0289a((byte) 0);

    static {
        AppMethodBeat.i(193961);
        AppMethodBeat.o(193961);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/chatroom/api/ChatRoomOpenService$Companion;", "", "()V", "KEY_BIND_PARAM", "", "KEY_ERROR_CONTENT", "KEY_ERROR_TITLE", "TAG", "ui-chatroom_release"})
    /* renamed from: com.tencent.mm.chatroom.b.a$a  reason: collision with other inner class name */
    public static final class C0289a {
        private C0289a() {
        }

        public /* synthetic */ C0289a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.c
    public final void a(Context context, c.b bVar, String str, c.AbstractC1475c cVar) {
        AppMethodBeat.i(193956);
        p.h(context, "context");
        p.h(bVar, "param");
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            if (str.length() > 0) {
                ArrayList<String> arrayList2 = new ArrayList();
                for (Object obj : n.b(str, new String[]{","})) {
                    if (((String) obj).length() > 0) {
                        arrayList2.add(obj);
                    }
                }
                for (String str2 : arrayList2) {
                    arrayList.add(str2);
                }
            }
        }
        z.f fVar = new z.f();
        fVar.SYG = null;
        com.tencent.mm.ac.d.h(new d(fVar, context));
        com.tencent.mm.roomsdk.a.b.bhF("@chatroom").a("", (List<String>) arrayList, bVar.appId, bVar.zpZ).d(new e(fVar, cVar, context)).aJu();
        AppMethodBeat.o(193956);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/chatroom/api/ChatRoomOpenService$doAppCreateChatRoom$4", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "onResult", "", "errType", "", "errCode", "errMsg", "", "detailResult", "ui-chatroom_release"})
    public static final class e extends com.tencent.mm.roomsdk.a.b.c {
        final /* synthetic */ Context $context;
        final /* synthetic */ c.AbstractC1475c grC;
        final /* synthetic */ z.f grx;

        e(z.f fVar, c.AbstractC1475c cVar, Context context) {
            this.grx = fVar;
            this.grC = cVar;
            this.$context = context;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.chatroom.b.a$e$a  reason: collision with other inner class name */
        static final class C0290a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ int $errCode;
            final /* synthetic */ int $errType;
            final /* synthetic */ e grD;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0290a(e eVar, int i2, int i3) {
                super(0);
                this.grD = eVar;
                this.$errType = i2;
                this.$errCode = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(193942);
                T t = this.grD.grx.SYG;
                if (t != null) {
                    t.dismiss();
                }
                if (this.$errType == 0 && this.$errCode == 0 && !Util.isNullOrNil(this.grD.chatroomName)) {
                    Log.i("MicroMsg.ChatRoomOpenService", "doAppCreateChatRoom success");
                    c.AbstractC1475c cVar = this.grD.grC;
                    if (cVar != null) {
                        cVar.f(true, this.grD.chatroomName);
                    }
                } else {
                    c.AbstractC1475c cVar2 = this.grD.grC;
                    if (cVar2 != null) {
                        cVar2.f(false, null);
                    }
                    String string = this.grD.$context.getString(R.string.edt);
                    p.g(string, "context.getString(R.stri…ing_create_chatroom_fail)");
                    u.cH(MMApplicationContext.getContext(), string);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(193942);
                return xVar;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
        @Override // com.tencent.mm.roomsdk.a.b.a
        public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.c cVar) {
            AppMethodBeat.i(193943);
            com.tencent.mm.ac.d.h(new C0290a(this, i2, i3));
            AppMethodBeat.o(193943);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.c
    public final void a(Context context, c.b bVar, c.a aVar) {
        Context context2;
        AppMethodBeat.i(193957);
        p.h(context, "context");
        p.h(bVar, "param");
        if (!(context instanceof MMFragmentActivity)) {
            context2 = null;
        } else {
            context2 = context;
        }
        MMFragmentActivity mMFragmentActivity = (MMFragmentActivity) context2;
        if (mMFragmentActivity == null) {
            Log.e("MicroMsg.ChatRoomOpenService", "context is not MMActivity");
            AppMethodBeat.o(193957);
            return;
        }
        xn xnVar = new xn();
        xnVar.dNI = bVar.appId;
        xnVar.signature = bVar.signature;
        xnVar.KBt = bVar.zpX;
        xnVar.qcM = bVar.zpY;
        d.a aVar2 = new d.a();
        aVar2.sG(TXLiteAVCode.EVT_CAMERA_REMOVED);
        aVar2.MB("/cgi-bin/mmbiz-bin/wxabusiness/checkappbindchatroom");
        aVar2.c(xnVar);
        aVar2.d(new xo());
        z.f fVar = new z.f();
        fVar.SYG = null;
        com.tencent.mm.ac.d.h(new h(fVar, context));
        IPCRunCgi.a(aVar2.aXF(), new i(this, fVar, bVar, mMFragmentActivity, context, aVar));
        AppMethodBeat.o(193957);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class i implements IPCRunCgi.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ a grF;
        final /* synthetic */ MMFragmentActivity grG;
        final /* synthetic */ z.f grx;
        final /* synthetic */ c.b gry;
        final /* synthetic */ c.a grz;

        i(a aVar, z.f fVar, c.b bVar, MMFragmentActivity mMFragmentActivity, Context context, c.a aVar2) {
            this.grF = aVar;
            this.grx = fVar;
            this.gry = bVar;
            this.grG = mMFragmentActivity;
            this.$context = context;
            this.grz = aVar2;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
            en enVar;
            String str2;
            BaseResponse baseResponse;
            dqi dqi;
            en enVar2;
            String str3;
            en enVar3;
            String str4;
            AppMethodBeat.i(193951);
            Log.i("MicroMsg.ChatRoomOpenService", "GetCheckAppBindResp: errType:" + i2 + ", errCode:" + i3 + ", errMsg:" + str);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.chatroom.b.a.i.AnonymousClass1 */
                final /* synthetic */ i grH;

                {
                    this.grH = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(193948);
                    T t = this.grH.grx.SYG;
                    if (t != null) {
                        t.dismiss();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(193948);
                    return xVar;
                }
            });
            com.tencent.mm.bw.a aYK = dVar != null ? dVar.aYK() : null;
            if (!(aYK instanceof xo)) {
                aYK = null;
            }
            xo xoVar = (xo) aYK;
            if (i2 == 0 && i3 == 0 && xoVar != null) {
                Log.i("MicroMsg.ChatRoomOpenService", "GetCheckAppBindResp Success");
                this.gry.zpZ = xoVar.KIf;
                c.b bVar = this.gry;
                lu luVar = xoVar.LiM;
                if (luVar == null || (str4 = luVar.nickname) == null) {
                    str4 = "";
                }
                bVar.appName = str4;
                Intent intent = new Intent();
                intent.setClassName(this.grG, "com.tencent.mm.ui.contact.GroupCardSelectUI");
                intent.putExtra("group_select_type", true);
                intent.putExtra("group_select_only_need_self_owner", true);
                intent.putExtra("group_select_need_result", true);
                intent.putExtra("group_select_show_create_new_group", true);
                intent.putExtra("group_select_should_intercept", true);
                intent.putExtra("key_bind_param", this.gry);
                this.grG.setMMOnFragmentActivityResult(new MMFragmentActivity.b(this) {
                    /* class com.tencent.mm.chatroom.b.a.i.AnonymousClass2 */
                    final /* synthetic */ i grH;

                    {
                        this.grH = r1;
                    }

                    @Override // com.tencent.mm.ui.MMFragmentActivity.b
                    public final void d(int i2, int i3, Intent intent) {
                        int i4;
                        AppMethodBeat.i(193949);
                        if (i2 == 15001 && i3 == -1) {
                            String stringExtra = intent != null ? intent.getStringExtra("Select_Conv_User") : null;
                            Log.i("MicroMsg.ChatRoomOpenService", "on select contact return:".concat(String.valueOf(stringExtra)));
                            this.grH.gry.zqa = stringExtra;
                            c.b bVar = this.grH.gry;
                            if (intent != null) {
                                i4 = intent.getIntExtra("key_has_create_new_group", 0);
                            } else {
                                i4 = 0;
                            }
                            bVar.zqb = i4;
                            a.c(this.grH.$context, this.grH.gry, this.grH.grz);
                            AppMethodBeat.o(193949);
                            return;
                        }
                        AppMethodBeat.o(193949);
                    }
                });
                this.grG.startActivityForResult(intent, 15001);
                AppMethodBeat.o(193951);
                return;
            }
            String str5 = (xoVar == null || (enVar3 = xoVar.LiN) == null) ? null : enVar3.title;
            final String string = str5 == null || str5.length() == 0 ? this.$context.getString(R.string.aur) : (xoVar == null || (enVar = xoVar.LiN) == null) ? null : enVar.title;
            if (xoVar != null && (enVar2 = xoVar.LiN) != null && (str3 = enVar2.desc) != null) {
                str2 = str3;
            } else if (xoVar == null || (baseResponse = xoVar.getBaseResponse()) == null || (dqi = baseResponse.ErrMsg) == null) {
                str2 = null;
            } else {
                str2 = dqi.MTo;
            }
            final String str6 = str2 == null ? string : str2;
            c.a aVar = this.grz;
            if (aVar != null) {
                aVar.a(false, str6, null);
            }
            com.tencent.f.h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.chatroom.b.a.i.AnonymousClass3 */
                final /* synthetic */ i grH;

                {
                    this.grH = r1;
                }

                public final void run() {
                    AppMethodBeat.i(193950);
                    Intent intent = new Intent();
                    intent.setClassName(this.grH.grG, "com.tencent.mm.chatroom.ui.ChatRoomOpenErrorInfoUI");
                    intent.putExtra("key_error_title", string);
                    intent.putExtra("key_error_content", str6);
                    MMFragmentActivity mMFragmentActivity = this.grH.grG;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, bl.axQ(), "com/tencent/mm/chatroom/api/ChatRoomOpenService$doCheckAppBindChatRoom$2$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    mMFragmentActivity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(mMFragmentActivity, "com/tencent/mm/chatroom/api/ChatRoomOpenService$doCheckAppBindChatRoom$2$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(193950);
                }
            });
            AppMethodBeat.o(193951);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "requestBindCode", "", "bindResultCode", "bindData", "Landroid/content/Intent;", "mmOnActivityResult"})
    public static final class l implements MMFragmentActivity.b {
        final /* synthetic */ c.a grz;

        l(c.a aVar) {
            this.grz = aVar;
        }

        @Override // com.tencent.mm.ui.MMFragmentActivity.b
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(193955);
            p.h(intent, "bindData");
            if (i2 == 15002 && i3 == -1) {
                String stringExtra = intent.getStringExtra("key_chat_room_open_id");
                c.a aVar = this.grz;
                if (aVar != null) {
                    aVar.a(true, null, stringExtra);
                    AppMethodBeat.o(193955);
                    return;
                }
            }
            AppMethodBeat.o(193955);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.c
    public final void b(Context context, c.b bVar, c.a aVar) {
        AppMethodBeat.i(193958);
        p.h(context, "context");
        p.h(bVar, "param");
        el elVar = new el();
        elVar.dNI = bVar.appId;
        elVar.signature = bVar.signature;
        elVar.KBt = bVar.zpX;
        elVar.qcM = bVar.zpY;
        elVar.dOe = bVar.zqa;
        elVar.KIf = bVar.zpZ;
        elVar.KIg = bVar.zqb;
        d.a aVar2 = new d.a();
        aVar2.sG(5285);
        aVar2.MB("/cgi-bin/micromsg-bin/appbindchatroom");
        aVar2.c(elVar);
        aVar2.d(new em());
        z.f fVar = new z.f();
        fVar.SYG = null;
        com.tencent.mm.ac.d.h(new b(fVar, context));
        IPCRunCgi.a(aVar2.aXF(), new c(fVar, bVar, aVar, context));
        AppMethodBeat.o(193958);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class c implements IPCRunCgi.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f grx;
        final /* synthetic */ c.b gry;
        final /* synthetic */ c.a grz;

        c(z.f fVar, c.b bVar, c.a aVar, Context context) {
            this.grx = fVar;
            this.gry = bVar;
            this.grz = aVar;
            this.$context = context;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(final int i2, final int i3, String str, final com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(193940);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.chatroom.b.a.c.AnonymousClass1 */
                final /* synthetic */ c grA;

                {
                    this.grA = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    String str;
                    BaseResponse baseResponse;
                    dqi dqi;
                    AppMethodBeat.i(193939);
                    T t = this.grA.grx.SYG;
                    if (t != null) {
                        t.dismiss();
                    }
                    com.tencent.mm.ak.d dVar = dVar;
                    com.tencent.mm.bw.a aYK = dVar != null ? dVar.aYK() : null;
                    if (!(aYK instanceof em)) {
                        aYK = null;
                    }
                    em emVar = (em) aYK;
                    if (i2 == 0 && i3 == 0 && emVar != null) {
                        com.tencent.mm.roomsdk.a.b.bhF(this.grA.gry.zqa).Dt(this.grA.gry.zqa).aJu();
                        c.a aVar = this.grA.grz;
                        if (aVar != null) {
                            aVar.a(true, "", emVar.KIh);
                        }
                    } else {
                        if (emVar == null || (baseResponse = emVar.getBaseResponse()) == null || (dqi = baseResponse.ErrMsg) == null || (str = dqi.MTo) == null) {
                            str = this.grA.$context.getString(R.string.auq);
                            p.g(str, "context.getString(R.stri…chat_room_open_bind_fail)");
                        }
                        u.cH(MMApplicationContext.getContext(), str);
                        c.a aVar2 = this.grA.grz;
                        if (aVar2 != null) {
                            aVar2.a(false, str, null);
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(193939);
                    return xVar;
                }
            });
            AppMethodBeat.o(193940);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.c
    public final void a(Context context, c.b bVar) {
        AppMethodBeat.i(193959);
        p.h(context, "context");
        p.h(bVar, "param");
        xp xpVar = new xp();
        xpVar.dNI = bVar.appId;
        xpVar.signature = bVar.signature;
        xpVar.KBt = bVar.zpX;
        xpVar.qcM = bVar.zpY;
        d.a aVar = new d.a();
        aVar.sG(1969);
        aVar.MB("/cgi-bin/mmbiz-bin/wxabusiness/checkappjoinchatroom");
        aVar.c(xpVar);
        aVar.d(new xq());
        z.f fVar = new z.f();
        fVar.SYG = null;
        com.tencent.mm.ac.d.h(new j(fVar, context));
        IPCRunCgi.a(aVar.aXF(), new k(fVar, context));
        AppMethodBeat.o(193959);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class k implements IPCRunCgi.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f grx;

        k(z.f fVar, Context context) {
            this.grx = fVar;
            this.$context = context;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(final int i2, final int i3, String str, final com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(193954);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.chatroom.b.a.k.AnonymousClass1 */
                final /* synthetic */ k grK;

                {
                    this.grK = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    en enVar;
                    String str;
                    en enVar2;
                    en enVar3;
                    en enVar4;
                    boolean z;
                    String str2 = null;
                    AppMethodBeat.i(193953);
                    T t = this.grK.grx.SYG;
                    if (t != null) {
                        t.dismiss();
                    }
                    com.tencent.mm.ak.d dVar = dVar;
                    com.tencent.mm.bw.a aYK = dVar != null ? dVar.aYK() : null;
                    if (!(aYK instanceof xq)) {
                        aYK = null;
                    }
                    xq xqVar = (xq) aYK;
                    if (i2 == 0 && i3 == 0 && xqVar != null) {
                        String str3 = xqVar.LiO;
                        if (str3 == null || str3.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            String str4 = xqVar.LiO;
                            p.g(str4, "joinChatRoomUrl");
                            if (!com.tencent.luggage.h.c.a(str4, "http", true)) {
                                Log.i("MicroMsg.ChatRoomOpenService", "join chat room url is not http:".concat(String.valueOf(str4)));
                                str4 = HttpWrapperBase.PROTOCAL_HTTP.concat(String.valueOf(str4));
                            }
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str4);
                            intent.putExtra(e.p.OzK, true);
                            Log.i("MicroMsg.ChatRoomOpenService", "join room url:".concat(String.valueOf(str4)));
                            com.tencent.mm.br.c.b(this.grK.$context, "webview", ".ui.tools.WebViewUI", intent);
                            x xVar = x.SXb;
                            AppMethodBeat.o(193953);
                            return xVar;
                        }
                    }
                    Intent intent2 = new Intent();
                    intent2.setClassName(this.grK.$context, "com.tencent.mm.chatroom.ui.ChatRoomOpenErrorInfoUI");
                    String str5 = (xqVar == null || (enVar4 = xqVar.LiN) == null) ? null : enVar4.title;
                    String string = str5 == null || str5.length() == 0 ? this.grK.$context.getString(R.string.auv) : (xqVar == null || (enVar = xqVar.LiN) == null) ? null : enVar.title;
                    if (xqVar == null || (enVar3 = xqVar.LiN) == null) {
                        str = null;
                    } else {
                        str = enVar3.desc;
                    }
                    String str6 = str;
                    if (str6 == null || str6.length() == 0) {
                        str2 = string;
                    } else if (!(xqVar == null || (enVar2 = xqVar.LiN) == null)) {
                        str2 = enVar2.desc;
                    }
                    intent2.putExtra("key_error_title", string);
                    intent2.putExtra("key_error_content", str2);
                    Context context = this.grK.$context;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/chatroom/api/ChatRoomOpenService$doCheckAppJoinChatRoom$2$1", "invoke", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/chatroom/api/ChatRoomOpenService$doCheckAppJoinChatRoom$2$1", "invoke", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    x xVar2 = x.SXb;
                    AppMethodBeat.o(193953);
                    return xVar2;
                }
            });
            AppMethodBeat.o(193954);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.c
    public final void a(Context context, c.b bVar, c.AbstractC1475c cVar) {
        AppMethodBeat.i(193960);
        p.h(context, "context");
        p.h(bVar, "param");
        gl glVar = new gl();
        glVar.dNI = bVar.appId;
        glVar.dOe = bVar.zqa;
        glVar.scene = bVar.zqc;
        d.a aVar = new d.a();
        aVar.sG(6892);
        aVar.MB("/cgi-bin/micromsg-bin/appunbindchatroom");
        aVar.c(glVar);
        aVar.d(new gm());
        z.f fVar = new z.f();
        fVar.SYG = null;
        com.tencent.mm.ac.d.h(new f(fVar, context));
        IPCRunCgi.a(aVar.aXF(), new g(fVar, bVar, context, cVar));
        AppMethodBeat.o(193960);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class g implements IPCRunCgi.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ c.AbstractC1475c grC;
        final /* synthetic */ z.f grx;
        final /* synthetic */ c.b gry;

        g(z.f fVar, c.b bVar, Context context, c.AbstractC1475c cVar) {
            this.grx = fVar;
            this.gry = bVar;
            this.$context = context;
            this.grC = cVar;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(final int i2, final int i3, String str, final com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(193946);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.chatroom.b.a.g.AnonymousClass1 */
                final /* synthetic */ g grE;

                {
                    this.grE = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    String str;
                    BaseResponse baseResponse;
                    dqi dqi;
                    AppMethodBeat.i(193945);
                    T t = this.grE.grx.SYG;
                    if (t != null) {
                        t.dismiss();
                    }
                    com.tencent.mm.ak.d dVar = dVar;
                    com.tencent.mm.bw.a aYK = dVar != null ? dVar.aYK() : null;
                    if (!(aYK instanceof gm)) {
                        aYK = null;
                    }
                    gm gmVar = (gm) aYK;
                    if (i2 == 0 && i3 == 0 && gmVar != null) {
                        com.tencent.mm.roomsdk.a.b.bhF(this.grE.gry.zqa).Dt(this.grE.gry.zqa).aJu();
                        u.cG(MMApplicationContext.getContext(), this.grE.$context.getString(R.string.av6));
                        c.AbstractC1475c cVar = this.grE.grC;
                        if (cVar != null) {
                            cVar.f(true, null);
                        }
                    } else {
                        if (gmVar == null || (baseResponse = gmVar.getBaseResponse()) == null || (dqi = baseResponse.ErrMsg) == null || (str = dqi.MTo) == null) {
                            str = this.grE.$context.getString(R.string.av5);
                            p.g(str, "context.getString(R.stri…at_room_open_unbind_fail)");
                        }
                        u.cH(MMApplicationContext.getContext(), str);
                        c.AbstractC1475c cVar2 = this.grE.grC;
                        if (cVar2 != null) {
                            cVar2.f(false, null);
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(193945);
                    return xVar;
                }
            });
            AppMethodBeat.o(193946);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity.a
    public final void d(int i2, int i3, Intent intent) {
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f grx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(z.f fVar, Context context) {
            super(0);
            this.grx = fVar;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(193941);
            this.grx.SYG = (T) com.tencent.mm.ui.base.q.a(this.$context, this.$context.getString(R.string.edv), true, 3, null);
            x xVar = x.SXb;
            AppMethodBeat.o(193941);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f grx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(z.f fVar, Context context) {
            super(0);
            this.grx = fVar;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(193947);
            this.grx.SYG = (T) com.tencent.mm.ui.base.q.a(this.$context, this.$context.getString(R.string.a06), true, 3, null);
            x xVar = x.SXb;
            AppMethodBeat.o(193947);
            return xVar;
        }
    }

    public static final /* synthetic */ void c(Context context, c.b bVar, c.a aVar) {
        Context context2;
        AppMethodBeat.i(193962);
        if (!(context instanceof MMFragmentActivity)) {
            context2 = null;
        } else {
            context2 = context;
        }
        MMFragmentActivity mMFragmentActivity = (MMFragmentActivity) context2;
        if (mMFragmentActivity == null) {
            Log.e("MicroMsg.ChatRoomOpenService", "context is not MMActivity");
            AppMethodBeat.o(193962);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(mMFragmentActivity, "com.tencent.mm.chatroom.ui.ChatRoomBindAppUI");
        intent.putExtra("key_bind_param", bVar);
        mMFragmentActivity.setMMOnFragmentActivityResult(new l(aVar));
        mMFragmentActivity.startActivityForResult(intent, 15002);
        AppMethodBeat.o(193962);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f grx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(z.f fVar, Context context) {
            super(0);
            this.grx = fVar;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(193938);
            this.grx.SYG = (T) com.tencent.mm.ui.base.q.a(this.$context, this.$context.getString(R.string.a06), true, 3, null);
            x xVar = x.SXb;
            AppMethodBeat.o(193938);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f grx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(z.f fVar, Context context) {
            super(0);
            this.grx = fVar;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(193952);
            this.grx.SYG = (T) com.tencent.mm.ui.base.q.a(this.$context, this.$context.getString(R.string.a06), true, 3, null);
            x xVar = x.SXb;
            AppMethodBeat.o(193952);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f grx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(z.f fVar, Context context) {
            super(0);
            this.grx = fVar;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(193944);
            this.grx.SYG = (T) com.tencent.mm.ui.base.q.a(this.$context, this.$context.getString(R.string.a06), true, 3, null);
            x xVar = x.SXb;
            AppMethodBeat.o(193944);
            return xVar;
        }
    }
}
