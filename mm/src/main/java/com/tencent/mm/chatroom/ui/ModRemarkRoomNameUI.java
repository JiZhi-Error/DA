package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.g.a.a;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b;

public class ModRemarkRoomNameUI extends MMActivity implements b.a {
    private String gxA;
    private MMClearEditText gxu;
    private Button gxv;
    private TextView gxw;
    private ScrollView gxx;
    private InputPanelLinearLayout gxy;
    private String gxz;
    private String roomId;
    private int scene;
    private TextView tipView;
    private TextView titleView;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12667);
        super.onCreate(bundle);
        this.roomId = getIntent().getStringExtra("RoomInfo_Id");
        initView();
        AppMethodBeat.o(12667);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String str;
        AppMethodBeat.i(12668);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.gxx = (ScrollView) findViewById(R.id.hcs);
        this.gxy = (InputPanelLinearLayout) findViewById(R.id.dym);
        this.gxy.setExternalListener(this);
        this.gxu = (MMClearEditText) findViewById(R.id.fj3);
        this.titleView = (TextView) findViewById(R.id.fj5);
        this.tipView = (TextView) findViewById(R.id.fj4);
        this.gxv = (Button) findViewById(R.id.fz0);
        this.gxw = (TextView) findViewById(R.id.c4r);
        ImageView imageView = (ImageView) findViewById(R.id.arb);
        View findViewById = findViewById(R.id.arm);
        this.scene = getIntent().getIntExtra("Key_Scenen", 0);
        this.roomId = getIntent().getStringExtra("Key_Room_Id");
        Log.i("MicroMsg.RemarkRoomNameUI", "scene %d, roomId %s", Integer.valueOf(this.scene), this.roomId);
        if (Util.isNullOrNil(this.roomId)) {
            finish();
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.roomId);
        if (((int) Kn.gMZ) > 0) {
            a.c(imageView, Kn.field_username);
        }
        final SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(this, Util.nullAsNil(Kn.field_nickname));
        SpannableString c3 = com.tencent.mm.pluginsdk.ui.span.l.c(this, Util.nullAsNil(Kn.field_conRemark));
        Log.i("MicroMsg.RemarkRoomNameUI", "roomName %s, remarkName %s", c2, c3);
        switch (this.scene) {
            case 1:
                this.titleView.setText(R.string.g63);
                this.tipView.setText(R.string.f33);
                this.gxu.setText(c2);
                if (Util.isNullOrNil(c2)) {
                    this.gxu.setHint(getString(R.string.g7e));
                }
                this.gxA = getString(R.string.g6b);
                this.gxz = getString(R.string.g6d);
                break;
            case 2:
                this.titleView.setText(R.string.g8w);
                this.tipView.setText(R.string.f34);
                this.gxu.setText(c3);
                this.gxu.setHint(R.string.g8w);
                if (Util.isNullOrNil(c2)) {
                    str = getString(R.string.g7e);
                } else {
                    str = c2;
                }
                findViewById.setVisibility(0);
                ((TextView) findViewById(R.id.arn)).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, getString(R.string.f32, new Object[]{str})));
                final TextView textView = (TextView) findViewById(R.id.aro);
                if (!Util.isNullOrNil(c2)) {
                    textView.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(194164);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            ModRemarkRoomNameUI.this.gxu.setText(c2);
                            ModRemarkRoomNameUI.this.gxu.setSelection(ModRemarkRoomNameUI.this.gxu.getText().length());
                            textView.setVisibility(8);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(194164);
                        }
                    });
                } else {
                    textView.setVisibility(8);
                }
                this.gxA = getString(R.string.gr3);
                break;
            case 3:
                this.titleView.setText(R.string.g88);
                this.tipView.setText(R.string.f31);
                MMClearEditText mMClearEditText = this.gxu;
                ah Kd = ((c) g.af(c.class)).aSX().Kd(this.roomId);
                String str2 = "";
                if (Kd != null) {
                    str2 = Kd.field_selfDisplayName;
                }
                if (Util.isNullOrNil(str2)) {
                    str2 = z.aUa();
                }
                mMClearEditText.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, com.tencent.mm.pluginsdk.ui.span.l.c(this, str2)));
                this.gxA = getString(R.string.g6c);
                this.gxz = getString(R.string.g6a);
                break;
            default:
                Log.w("MicroMsg.RemarkRoomNameUI", "unknown scene %d, finish()", Integer.valueOf(this.scene));
                finish();
                break;
        }
        this.gxu.setSelection(this.gxu.getText().length());
        this.gxu.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.AnonymousClass2 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(194165);
                if (charSequence.length() > 0) {
                    ModRemarkRoomNameUI.this.gxu.setEllipsize(null);
                    AppMethodBeat.o(194165);
                    return;
                }
                ModRemarkRoomNameUI.this.gxu.setEllipsize(TextUtils.TruncateAt.END);
                AppMethodBeat.o(194165);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(194166);
                ModRemarkRoomNameUI.this.gxv.setEnabled(ModRemarkRoomNameUI.b(ModRemarkRoomNameUI.this));
                AppMethodBeat.o(194166);
            }
        });
        com.tencent.mm.ui.tools.b.c.f(this.gxu).aoq(32).CN(false).a((c.a) null);
        this.gxu.requestFocus();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12665);
                ModRemarkRoomNameUI.this.finish();
                AppMethodBeat.o(12665);
                return true;
            }
        });
        this.gxv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(194167);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ModRemarkRoomNameUI.d(ModRemarkRoomNameUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ModRemarkRoomNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(194167);
            }
        });
        AppMethodBeat.o(12668);
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(194173);
        Log.i("MicroMsg.RemarkRoomNameUI", "keyboard show %s, keyboardHeight %d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gxv.getLayoutParams();
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.cb);
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.cb);
            this.gxv.setLayoutParams(layoutParams);
            this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), i2);
            final int height = this.gxx.getHeight();
            this.gxy.requestLayout();
            this.gxy.post(new Runnable() {
                /* class com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(194168);
                    Log.i("MicroMsg.RemarkRoomNameUI", "inputContainer.height: %d, screenHeight: %d", Integer.valueOf(ModRemarkRoomNameUI.this.gxy.getHeight()), Integer.valueOf(height));
                    if (ModRemarkRoomNameUI.this.gxy.getHeight() > height) {
                        ModRemarkRoomNameUI.this.gxx.scrollBy(0, ModRemarkRoomNameUI.this.gxy.getHeight() - height);
                    }
                    AppMethodBeat.o(194168);
                }
            });
            AppMethodBeat.o(194173);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gxv.getLayoutParams();
        layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.bx);
        layoutParams2.topMargin = 0;
        this.gxv.setLayoutParams(layoutParams2);
        this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), 0);
        this.gxx.scrollBy(0, 0);
        AppMethodBeat.o(194173);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(12669);
        super.onPause();
        AppMethodBeat.o(12669);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12670);
        super.onDestroy();
        AppMethodBeat.o(12670);
    }

    private void DI(String str) {
        AppMethodBeat.i(194174);
        if (Util.isNullOrNil(str)) {
            this.gxw.setVisibility(8);
            AppMethodBeat.o(194174);
            return;
        }
        this.gxw.setVisibility(0);
        this.gxw.setText(str);
        AppMethodBeat.o(194174);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bbe;
    }

    static /* synthetic */ boolean b(ModRemarkRoomNameUI modRemarkRoomNameUI) {
        AppMethodBeat.i(194175);
        String trim = modRemarkRoomNameUI.gxu.getText().toString().trim();
        String aqt = com.tencent.mm.n.c.aqt();
        if (Util.isNullOrNil(aqt) || !trim.matches(".*[" + aqt + "].*")) {
            modRemarkRoomNameUI.DI("");
            AppMethodBeat.o(194175);
            return true;
        }
        modRemarkRoomNameUI.DI(modRemarkRoomNameUI.getString(R.string.e3v, new Object[]{aqt}));
        AppMethodBeat.o(194175);
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void d(ModRemarkRoomNameUI modRemarkRoomNameUI) {
        AppMethodBeat.i(194176);
        switch (modRemarkRoomNameUI.scene) {
            case 1:
                final String escapeStringForUCC = Util.escapeStringForUCC(modRemarkRoomNameUI.gxu.getText().toString().trim());
                final com.tencent.mm.roomsdk.a.c.a aa = com.tencent.mm.roomsdk.a.b.bhF(modRemarkRoomNameUI.roomId).aa(modRemarkRoomNameUI.roomId, escapeStringForUCC);
                aa.d(new e() {
                    /* class com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.AnonymousClass6 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
                    @Override // com.tencent.mm.roomsdk.a.b.a
                    public final /* synthetic */ void a(int i2, int i3, String str, e eVar) {
                        AppMethodBeat.i(194169);
                        e eVar2 = eVar;
                        if (this.ret == 0) {
                            Toast.makeText(ModRemarkRoomNameUI.this, ModRemarkRoomNameUI.this.getString(R.string.zl), 0).show();
                            as Kn = ((l) g.af(l.class)).aSN().Kn(ModRemarkRoomNameUI.this.roomId);
                            if (Kn != null && ((int) Kn.gMZ) > 0) {
                                Kn.setNickname(escapeStringForUCC);
                                ((l) g.af(l.class)).aSN().an(Kn);
                            }
                            ModRemarkRoomNameUI.this.finish();
                            AppMethodBeat.o(194169);
                            return;
                        }
                        aa.cancel();
                        if (!Util.isNullOrNil(eVar2.content) || !Util.isNullOrNil(eVar2.title)) {
                            h.c(ModRemarkRoomNameUI.this, eVar2.content, eVar2.title, true);
                        }
                        AppMethodBeat.o(194169);
                    }
                });
                aa.a(modRemarkRoomNameUI.getContext(), modRemarkRoomNameUI.getString(R.string.zb), modRemarkRoomNameUI.getString(R.string.b_z), false, false, null);
                AppMethodBeat.o(194176);
                return;
            case 2:
                final String escapeStringForUCC2 = Util.escapeStringForUCC(modRemarkRoomNameUI.gxu.getText().toString().trim());
                final as Kn = ((l) g.af(l.class)).aSN().Kn(modRemarkRoomNameUI.roomId);
                final com.tencent.mm.roomsdk.a.c.a ab = com.tencent.mm.roomsdk.a.b.bhF(modRemarkRoomNameUI.roomId).ab(modRemarkRoomNameUI.roomId, escapeStringForUCC2);
                ab.d(new e() {
                    /* class com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.AnonymousClass8 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
                    @Override // com.tencent.mm.roomsdk.a.b.a
                    public final /* synthetic */ void a(int i2, int i3, String str, e eVar) {
                        AppMethodBeat.i(194171);
                        e eVar2 = eVar;
                        if (this.ret == 0) {
                            Toast.makeText(ModRemarkRoomNameUI.this, ModRemarkRoomNameUI.this.getString(R.string.zl), 0).show();
                            if (Kn != null && ((int) Kn.gMZ) > 0) {
                                Kn.BD(escapeStringForUCC2);
                                ((l) g.af(l.class)).aSN().an(Kn);
                            }
                            ModRemarkRoomNameUI.this.finish();
                            AppMethodBeat.o(194171);
                            return;
                        }
                        ab.cancel();
                        if (!Util.isNullOrNil(eVar2.content) || !Util.isNullOrNil(eVar2.title)) {
                            h.c(ModRemarkRoomNameUI.this, eVar2.content, eVar2.title, true);
                        }
                        AppMethodBeat.o(194171);
                    }
                });
                if (Util.isNullOrNil(escapeStringForUCC2) || !escapeStringForUCC2.equals(Kn.field_nickname)) {
                    ab.a(modRemarkRoomNameUI.getContext(), modRemarkRoomNameUI.getString(R.string.zb), modRemarkRoomNameUI.getString(R.string.b_z), false, false, null);
                    break;
                } else {
                    h.a(modRemarkRoomNameUI, modRemarkRoomNameUI.getString(R.string.g6h), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.AnonymousClass9 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(194172);
                            ab.a(ModRemarkRoomNameUI.this.getContext(), ModRemarkRoomNameUI.this.getString(R.string.zb), ModRemarkRoomNameUI.this.getString(R.string.b_z), false, false, null);
                            AppMethodBeat.o(194172);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(194176);
                    return;
                }
                break;
            case 3:
                final String escapeStringForUCC3 = Util.escapeStringForUCC(modRemarkRoomNameUI.gxu.getText().toString().trim());
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 4, 1, true);
                final com.tencent.mm.roomsdk.a.c.a g2 = com.tencent.mm.roomsdk.a.b.bhF(modRemarkRoomNameUI.roomId).g(modRemarkRoomNameUI.roomId, z.aTY(), Util.nullAsNil(escapeStringForUCC3));
                g2.d(new e() {
                    /* class com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.AnonymousClass7 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.roomsdk.a.b.a] */
                    @Override // com.tencent.mm.roomsdk.a.b.a
                    public final /* synthetic */ void a(int i2, int i3, String str, e eVar) {
                        AppMethodBeat.i(194170);
                        if (i3 == 0) {
                            Toast.makeText(ModRemarkRoomNameUI.this, ModRemarkRoomNameUI.this.getString(R.string.zl), 0).show();
                            ah Kd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(ModRemarkRoomNameUI.this.roomId);
                            if (Kd != null) {
                                Kd.field_chatroomname = ModRemarkRoomNameUI.this.roomId;
                                Kd.field_selfDisplayName = escapeStringForUCC3;
                                ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().update(Kd, new String[0]);
                                ModRemarkRoomNameUI.this.finish();
                            }
                            AppMethodBeat.o(194170);
                            return;
                        }
                        g2.cancel();
                        Toast.makeText(ModRemarkRoomNameUI.this.getContext(), Util.nullAs(this.content, ModRemarkRoomNameUI.this.getString(R.string.u5)), 1).show();
                        AppMethodBeat.o(194170);
                    }
                });
                g2.a(modRemarkRoomNameUI, modRemarkRoomNameUI.getString(R.string.zb), modRemarkRoomNameUI.getString(R.string.b_z), false, false, null);
                AppMethodBeat.o(194176);
                return;
        }
        AppMethodBeat.o(194176);
    }
}
