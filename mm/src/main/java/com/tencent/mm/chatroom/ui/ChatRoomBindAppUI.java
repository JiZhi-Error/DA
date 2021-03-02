package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import java.io.Serializable;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/chatroom/ui/ChatRoomBindAppUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "bindButton", "Landroid/widget/Button;", "openParam", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$ChatRoomOpenParam;", "getLayoutId", "", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-chatroom_release"})
public final class ChatRoomBindAppUI extends MMActivity {
    public static final a gtD = new a((byte) 0);
    private Button gtB;
    private c.b gtC;

    static {
        AppMethodBeat.i(193992);
        AppMethodBeat.o(193992);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/chatroom/ui/ChatRoomBindAppUI$Companion;", "", "()V", "KEY_BIND_PARAM", "", "TAG", "ui-chatroom_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        AppMethodBeat.i(193991);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.afz));
        Intent intent = getIntent();
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra("key_bind_param") : null;
        if (!(serializableExtra instanceof c.b)) {
            serializableExtra = null;
        }
        this.gtC = (c.b) serializableExtra;
        if (this.gtC == null) {
            Log.e("MicroMsg.ChatRoomBindAppUI", "openParam is null");
            finish();
            AppMethodBeat.o(193991);
            return;
        }
        setMMTitle("");
        setBackBtn(new b(this), R.raw.actionbar_icon_dark_close);
        View findViewById = findViewById(R.id.ael);
        p.g(findViewById, "findViewById(R.id.btn_bind)");
        this.gtB = (Button) findViewById;
        Button button = this.gtB;
        if (button == null) {
            p.btv("bindButton");
        }
        button.setOnClickListener(new c(this));
        View findViewById2 = findViewById(R.id.iwm);
        p.g(findViewById2, "findViewById(R.id.tv_bind_app_title)");
        TextView textView = (TextView) findViewById2;
        Context context = MMApplicationContext.getContext();
        Object[] objArr = new Object[1];
        c.b bVar = this.gtC;
        if (bVar == null || (str = bVar.appName) == null) {
            str = "";
        }
        objArr[0] = str;
        textView.setText(context.getString(R.string.auo, objArr));
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN();
        c.b bVar2 = this.gtC;
        if (bVar2 != null) {
            str2 = bVar2.zqa;
        } else {
            str2 = null;
        }
        as Kn = aSN.Kn(str2);
        if (Kn == null) {
            Log.e("MicroMsg.ChatRoomBindAppUI", "contact is null");
            finish();
            AppMethodBeat.o(193991);
            return;
        }
        View findViewById3 = findViewById(R.id.e47);
        p.g(findViewById3, "findViewById(R.id.iv_avatar)");
        ImageView imageView = (ImageView) findViewById3;
        c.b bVar3 = this.gtC;
        if (bVar3 != null) {
            str4 = bVar3.zqa;
        }
        a.b.c(imageView, str4);
        View findViewById4 = findViewById(R.id.ixm);
        p.g(findViewById4, "findViewById(R.id.tv_group_nickname)");
        ((TextView) findViewById4).setText(com.tencent.mm.pluginsdk.ui.span.l.e((Context) getContext(), (CharSequence) aa.getDisplayName(Kn.getUsername()), com.tencent.mm.cb.a.aG(getContext(), R.dimen.is)));
        View findViewById5 = findViewById(R.id.iwn);
        p.g(findViewById5, "findViewById(R.id.tv_bind_desc)");
        TextView textView2 = (TextView) findViewById5;
        Context context2 = MMApplicationContext.getContext();
        Object[] objArr2 = new Object[1];
        c.b bVar4 = this.gtC;
        if (bVar4 == null || (str3 = bVar4.appName) == null) {
            str3 = "";
        }
        objArr2[0] = str3;
        textView2.setText(context2.getString(R.string.aup, objArr2));
        AppMethodBeat.o(193991);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ChatRoomBindAppUI gtE;

        b(ChatRoomBindAppUI chatRoomBindAppUI) {
            this.gtE = chatRoomBindAppUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(193987);
            this.gtE.finish();
            AppMethodBeat.o(193987);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ ChatRoomBindAppUI gtE;

        c(ChatRoomBindAppUI chatRoomBindAppUI) {
            this.gtE = chatRoomBindAppUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(193990);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ChatRoomBindAppUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.messenger.foundation.a.c cVar = (com.tencent.mm.plugin.messenger.foundation.a.c) g.af(com.tencent.mm.plugin.messenger.foundation.a.c.class);
            ChatRoomBindAppUI chatRoomBindAppUI = this.gtE;
            c.b bVar2 = this.gtE.gtC;
            if (bVar2 == null) {
                p.hyc();
            }
            cVar.b(chatRoomBindAppUI, bVar2, new c.a(this) {
                /* class com.tencent.mm.chatroom.ui.ChatRoomBindAppUI.c.AnonymousClass1 */
                final /* synthetic */ c gtF;

                {
                    this.gtF = r1;
                }

                @Override // com.tencent.mm.plugin.messenger.foundation.a.c.a
                public final void a(boolean z, String str, String str2) {
                    AppMethodBeat.i(193989);
                    if (z) {
                        u.cG(this.gtF.gtE.getContext(), this.gtF.gtE.getContext().getString(R.string.aus));
                        final Intent intent = new Intent();
                        intent.putExtra("key_chat_room_open_id", str2);
                        h.RTc.n(new Runnable(this) {
                            /* class com.tencent.mm.chatroom.ui.ChatRoomBindAppUI.c.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 gtG;

                            {
                                this.gtG = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(193988);
                                this.gtG.gtF.gtE.setResult(-1, intent);
                                this.gtG.gtF.gtE.finish();
                                AppMethodBeat.o(193988);
                            }
                        }, 500);
                    }
                    AppMethodBeat.o(193989);
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatRoomBindAppUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(193990);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.pj;
    }
}
