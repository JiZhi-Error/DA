package com.tencent.mm.chatroom.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "contentTextView", "Landroid/widget/TextView;", "titleTextView", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupView", "Companion", "ui-chatroom_release"})
public final class ChatRoomOpenErrorInfoUI extends MMActivity {
    public static final a gtK = new a((byte) 0);
    private TextView gtI;
    private TextView gtJ;

    static {
        AppMethodBeat.i(193996);
        AppMethodBeat.o(193996);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$Companion;", "", "()V", "KEY_ERROR_CONTENT", "", "KEY_ERROR_TITLE", "TAG", "ui-chatroom_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(193995);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.afz));
        setMMTitle("");
        setBackBtn(new b(this));
        View findViewById = findViewById(R.id.ixc);
        p.g(findViewById, "findViewById(R.id.tv_error_title)");
        this.gtI = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.ixb);
        p.g(findViewById2, "findViewById(R.id.tv_error_content)");
        this.gtJ = (TextView) findViewById2;
        findViewById(R.id.af2).setOnClickListener(new c(this));
        String stringExtra = getIntent().getStringExtra("key_error_title");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra("key_error_content");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        TextView textView = this.gtI;
        if (textView == null) {
            p.btv("titleTextView");
        }
        textView.setText(stringExtra);
        TextView textView2 = this.gtJ;
        if (textView2 == null) {
            p.btv("contentTextView");
        }
        textView2.setText(stringExtra2);
        AppMethodBeat.o(193995);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ChatRoomOpenErrorInfoUI gtL;

        b(ChatRoomOpenErrorInfoUI chatRoomOpenErrorInfoUI) {
            this.gtL = chatRoomOpenErrorInfoUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(193993);
            this.gtL.finish();
            AppMethodBeat.o(193993);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ ChatRoomOpenErrorInfoUI gtL;

        c(ChatRoomOpenErrorInfoUI chatRoomOpenErrorInfoUI) {
            this.gtL = chatRoomOpenErrorInfoUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(193994);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$setupView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.gtL.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$setupView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(193994);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.pp;
    }
}
