package com.tencent.mm.chatroom.g;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.xwalk.core.Log;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 B2\u00020\u0001:\u0002BCB;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ,\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u001f\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010(\u001a\u00020\"H\u0002J(\u0010)\u001a\u00020 2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010+2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010+H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020\u0005H\u0002J\n\u0010/\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\"J+\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\"2\u0016\u00102\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000103\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u00104J\u001c\u00105\u001a\u00020 2\b\u0010\u0002\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0002J \u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\u00052\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010+H\u0002J\u0016\u0010:\u001a\u00020 2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050+H\u0002J\u0012\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010?\u001a\u00020=H\u0002J \u0010@\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010+2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010+H\u0002R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000f¨\u0006D"}, hxF = {"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "chatRoomName", "", "userNameByAdd", "localHistoryInfo", "Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;", "fakeMsgId", "", "iChatRoomAddContactCallback", "Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "(Lcom/tencent/mm/ui/MMActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;JLcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;)V", "getChatRoomName", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFakeMsgId", "()J", "getIChatRoomAddContactCallback", "()Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "getLocalHistoryInfo", "()Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;", "member", "Lcom/tencent/mm/storage/ChatRoomMember;", "getMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "setMember", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "getUserNameByAdd", "dealAddChatRoomMember", "", "errType", "", "errCode", "scene", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "sysErrMsg", "desc", "tipResId", "dealNeedVerify", "verifyUserList", "", "memberBlackList", "getDisplayNameInRoom", ch.COL_USERNAME, "getOwnerName", "getString", "resId", "formatArgs", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "goChatroomUpgrade", "Landroid/content/Context;", "roomname", "hardcodeVerifySysMsg", "chatroomName", "inviteChatRoomMember", "list", "isContactExit", "", "userName", "isSupportChatroomUpgradeEntry", "usernameToDisplayName", "memberList", "Companion", "IChatRoomAddContactCallback", "ui-chatroom_release"})
public final class a {
    private static final String TAG = TAG;
    public static final C0291a gtj = new C0291a((byte) 0);
    final String dSW;
    private ah gtd;
    final MMActivity gte;
    private final String gtf;
    private final ChatroomInfoUI.LocalHistoryInfo gtg;
    final long gth;
    final b gti;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "", "onMemberListChanged", "", "updateUI", "ui-chatroom_release"})
    public interface b {
        void ami();

        void amj();
    }

    public a(MMActivity mMActivity, String str, String str2, ChatroomInfoUI.LocalHistoryInfo localHistoryInfo, long j2, b bVar) {
        p.h(mMActivity, "context");
        p.h(bVar, "iChatRoomAddContactCallback");
        AppMethodBeat.i(193980);
        this.gte = mMActivity;
        this.dSW = str;
        this.gtf = str2;
        this.gtg = localHistoryInfo;
        this.gth = j2;
        this.gti = bVar;
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class);
        p.g(af, "service(IChatroomService::class.java)");
        this.gtd = ((com.tencent.mm.plugin.chatroom.a.c) af).aSX().Kd(this.dSW);
        if (this.gtd != null) {
            ah ahVar = this.gtd;
            if (ahVar == null) {
                p.hyc();
            }
            int gBv = ahVar.gBv();
            boolean z = false;
            ah ahVar2 = this.gtd;
            if (ahVar2 == null) {
                p.hyc();
            }
            if (!ahVar2.amD()) {
                if (ab.Iy(this.dSW)) {
                    if ((gBv & 1) == 1) {
                        z = true;
                    }
                } else if (gBv == 2) {
                    z = true;
                }
            }
            if (z) {
                new f.a(this.gte).bow(getString(R.string.g56)).boA(getString(R.string.yq)).Dq(true).u(Boolean.TRUE).boB(getString(R.string.sz)).boy(getString(R.string.fur)).c(new f.c(this) {
                    /* class com.tencent.mm.chatroom.g.a.AnonymousClass1 */
                    final /* synthetic */ a gtk;

                    {
                        this.gtk = r1;
                    }

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        AppMethodBeat.i(193963);
                        if (z) {
                            a.a(this.gtk, str);
                        }
                        AppMethodBeat.o(193963);
                    }
                }).show();
                AppMethodBeat.o(193980);
                return;
            }
            J(null, R.string.dw);
            AppMethodBeat.o(193980);
            return;
        }
        Log.e(TAG, "member is null!!!");
        AppMethodBeat.o(193980);
    }

    public static final /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(193986);
        aVar.J(str, R.string.e4n);
        AppMethodBeat.o(193986);
    }

    public static final /* synthetic */ void a(a aVar, String str, List list) {
        AppMethodBeat.i(193983);
        aVar.b(str, list);
        AppMethodBeat.o(193983);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ui-chatroom_release"})
    /* renamed from: com.tencent.mm.chatroom.g.a$a  reason: collision with other inner class name */
    public static final class C0291a {
        private C0291a() {
        }

        public /* synthetic */ C0291a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(193981);
        AppMethodBeat.o(193981);
    }

    private final void J(String str, int i2) {
        boolean z;
        AppMethodBeat.i(193974);
        if (!ab.Ix(this.dSW) || ab.IB(this.dSW) || u.HQ(this.gtf)) {
            String str2 = this.gtf;
            if (p.j(Util.nullAsNil(z.aTY()), str2)) {
                z = true;
            } else {
                List<String> Ic = v.Ic(this.dSW);
                if (Ic == null) {
                    z = false;
                } else {
                    z = false;
                    for (String str3 : Ic) {
                        z = p.j(str3, str2) ? true : z;
                    }
                }
            }
            if (z) {
                com.tencent.mm.ui.base.h.X(this.gte, getString(R.string.di), getString(R.string.zb));
                AppMethodBeat.o(193974);
            } else if (this.gtf == null) {
                AppMethodBeat.o(193974);
            } else {
                Object[] array = new kotlin.n.k(",").q(this.gtf, 0).toArray(new String[0]);
                if (array == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                    AppMethodBeat.o(193974);
                    throw tVar;
                }
                ArrayList<String> stringsToList = Util.stringsToList((String[]) array);
                if (stringsToList == null) {
                    AppMethodBeat.o(193974);
                    return;
                }
                com.tencent.mm.roomsdk.a.c.a a2 = com.tencent.mm.roomsdk.a.b.bhF(this.dSW).a(this.dSW, stringsToList, str, this.gtg);
                a2.d(new c(this));
                a2.a(this.gte, getString(R.string.zb), getString(i2), true, true, new d(a2));
                AppMethodBeat.o(193974);
            }
        } else {
            com.tencent.mm.ui.base.h.X(this.gte, getString(R.string.g81), getString(R.string.zb));
            AppMethodBeat.o(193974);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/chatroom/process/ChatRoomAddContactProcess$dealAddChatRoomMember$1", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "onResult", "", "errType", "", "errCode", "errMsg", "", "detailResult", "ui-chatroom_release"})
    public static final class c extends com.tencent.mm.roomsdk.a.b.c {
        final /* synthetic */ a gtk;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(a aVar) {
            this.gtk = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
        @Override // com.tencent.mm.roomsdk.a.b.a
        public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.c cVar) {
            AppMethodBeat.i(193964);
            com.tencent.mm.roomsdk.a.b.c cVar2 = cVar;
            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
            if (Dk != null) {
                Dk.a(this.gtk.gte, null, null);
                AppMethodBeat.o(193964);
            } else if (i2 == 0 && i3 == 0) {
                a.a(this.gtk, i2, i3, cVar2, str);
                this.gtk.gti.ami();
                this.gtk.gti.amj();
                AppMethodBeat.o(193964);
            } else {
                a.a(this.gtk, i2, i3, cVar2, str);
                this.gtk.gti.ami();
                AppMethodBeat.o(193964);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class d implements DialogInterface.OnCancelListener {
        final /* synthetic */ com.tencent.mm.roomsdk.a.c.a gtl;

        d(com.tencent.mm.roomsdk.a.c.a aVar) {
            this.gtl = aVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(193965);
            this.gtl.cancel();
            AppMethodBeat.o(193965);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
    public static final class e implements DialogInterface.OnClickListener {
        final /* synthetic */ a gtk;
        final /* synthetic */ com.tencent.mm.roomsdk.a.b.c gtm;
        final /* synthetic */ List gtn;
        final /* synthetic */ List gto;
        final /* synthetic */ List gtp;

        e(a aVar, com.tencent.mm.roomsdk.a.b.c cVar, List list, List list2, List list3) {
            this.gtk = aVar;
            this.gtm = cVar;
            this.gtn = list;
            this.gto = list2;
            this.gtp = list3;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(193966);
            if (ab.Ix(this.gtk.dSW)) {
                a aVar = this.gtk;
                String gvN = this.gtm.gvN();
                p.g(gvN, "scene.getChatroomName()");
                a.a(aVar, gvN, this.gtn);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.gto);
            arrayList.addAll(this.gtp);
            a.a(this.gtk, arrayList);
            ((com.tencent.mm.plugin.messenger.foundation.a.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.v.class)).Qm(1);
            ((com.tencent.mm.plugin.record.a.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.f.class)).D(this.gtk.gth, this.gtk.dSW);
            AppMethodBeat.o(193966);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
    public static final class f implements DialogInterface.OnClickListener {
        public static final f gtq = new f();

        static {
            AppMethodBeat.i(193968);
            AppMethodBeat.o(193968);
        }

        f() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(193967);
            ((com.tencent.mm.plugin.messenger.foundation.a.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.v.class)).Qm(4);
            AppMethodBeat.o(193967);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class g implements DialogInterface.OnClickListener {
        final /* synthetic */ a gtk;

        g(a aVar) {
            this.gtk = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(193969);
            a.a(this.gtk, this.gtk.gte);
            AppMethodBeat.o(193969);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class h implements DialogInterface.OnClickListener {
        final /* synthetic */ a gtk;

        h(a aVar) {
            this.gtk = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(193970);
            this.gtk.gti.ami();
            AppMethodBeat.o(193970);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0016\u0010\b\u001a\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "detailResult", "Lcom/tencent/mm/roomsdk/model/callback/RoomCallbackBaseFunc;", "onResult"})
    public static final class i<T extends com.tencent.mm.roomsdk.a.b.a<com.tencent.mm.roomsdk.a.b.a<?>>> implements com.tencent.mm.roomsdk.a.b.a<com.tencent.mm.roomsdk.a.b.a<?>> {
        final /* synthetic */ a gtk;

        i(a aVar) {
            this.gtk = aVar;
        }

        @Override // com.tencent.mm.roomsdk.a.b.a
        public final void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a<?> aVar) {
            AppMethodBeat.i(193971);
            this.gtk.gti.ami();
            this.gtk.gti.amj();
            ((com.tencent.mm.plugin.record.a.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.f.class)).D(this.gtk.gth, this.gtk.dSW);
            AppMethodBeat.o(193971);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    public static final class k implements DialogInterface.OnCancelListener {
        final /* synthetic */ com.tencent.mm.roomsdk.a.c.a gtr;

        k(com.tencent.mm.roomsdk.a.c.a aVar) {
            this.gtr = aVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(193973);
            this.gtr.cancel();
            AppMethodBeat.o(193973);
        }
    }

    private static List<String> V(List<String> list) {
        AppMethodBeat.i(193975);
        LinkedList linkedList = new LinkedList();
        if (!com.tencent.mm.kernel.g.aAc()) {
            AppMethodBeat.o(193975);
        } else if (list == null) {
            AppMethodBeat.o(193975);
        } else {
            for (String str : list) {
                com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
                if (!(Kn == null || Kn.arH() == 0)) {
                    str = Kn.arJ();
                    p.g(str, "ct.displayRemark");
                }
                linkedList.add(str);
            }
            AppMethodBeat.o(193975);
        }
        return linkedList;
    }

    private final void b(String str, List<String> list) {
        AppMethodBeat.i(193976);
        if (list != null && list.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                linkedList.add(list.get(i2));
            }
            u.a(str, linkedList, getString(R.string.aws), true, "weixin://findfriend/verifycontact/" + str + FilePathGenerator.ANDROID_DIR_SEP);
        }
        AppMethodBeat.o(193976);
    }

    private static boolean amh() {
        AppMethodBeat.i(193977);
        if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("ChatroomGlobalSwitch"), 1) == 1) {
            AppMethodBeat.o(193977);
            return true;
        }
        AppMethodBeat.o(193977);
        return false;
    }

    public final String getString(int i2) {
        AppMethodBeat.i(193978);
        String string = this.gte.getString(i2);
        p.g(string, "context.getString(resId)");
        AppMethodBeat.o(193978);
        return string;
    }

    private String getString(int i2, Object... objArr) {
        AppMethodBeat.i(193979);
        p.h(objArr, "formatArgs");
        String string = this.gte.getString(i2, Arrays.copyOf(objArr, objArr.length));
        p.g(string, "context.getString(resId, *formatArgs)");
        AppMethodBeat.o(193979);
        return string;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "detailResult", "Lcom/tencent/mm/roomsdk/model/callback/RoomCallbackFunc;", "onResult"})
    public static final class j implements com.tencent.mm.roomsdk.a.b.b {
        final /* synthetic */ a gtk;

        j(a aVar) {
            this.gtk = aVar;
        }

        @Override // com.tencent.mm.roomsdk.a.b.a
        public final /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
            AppMethodBeat.i(193972);
            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
            if (Dk != null) {
                Dk.a(this.gtk.gte, null, null);
                AppMethodBeat.o(193972);
                return;
            }
            com.tencent.mm.ui.base.h.X(this.gtk.gte, this.gtk.getString(R.string.e4e), this.gtk.getString(R.string.zb));
            this.gtk.gti.amj();
            AppMethodBeat.o(193972);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:133:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x047c  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0492  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.chatroom.g.a r14, int r15, int r16, com.tencent.mm.roomsdk.a.b.c r17, java.lang.String r18) {
        /*
        // Method dump skipped, instructions count: 1226
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.chatroom.g.a.a(com.tencent.mm.chatroom.g.a, int, int, com.tencent.mm.roomsdk.a.b.c, java.lang.String):void");
    }

    public static final /* synthetic */ void a(a aVar, List list) {
        AppMethodBeat.i(193984);
        com.tencent.mm.roomsdk.a.c.a a2 = com.tencent.mm.roomsdk.a.b.bhF(aVar.dSW).a(aVar.dSW, list, aVar.gtg);
        a2.b(new i(aVar)).c(new j(aVar));
        a2.a(aVar.gte, aVar.getString(R.string.zb), aVar.getString(R.string.g7h), true, true, new k(a2));
        AppMethodBeat.o(193984);
    }

    public static final /* synthetic */ void a(a aVar, Context context) {
        AppMethodBeat.i(193985);
        if (context != null && amh()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aVar.getString(R.string.awk, LocaleUtil.getApplicationLanguage()));
            intent.putExtra("geta8key_username", z.aTY());
            intent.putExtra("showShare", false);
            com.tencent.mm.br.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(193985);
    }
}
