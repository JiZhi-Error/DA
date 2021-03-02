package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

public class RoomCardUI extends MMActivity implements i {
    private String gwx;
    private String gxP;
    private int gxQ;
    private String gxR;
    private boolean gxS;
    private boolean gxT;
    private String gxU;
    private String gxV;
    private long gxW;
    private q gxX;
    private TextView gxY;
    private MMEditText gxZ;
    private TextView gya;
    private TextView gyb;
    private ImageView gyc;
    private LinearLayout gyd;
    private LinearLayout gye;
    private LinearLayout gyf;
    private LinearLayout gyg;
    private h gyh;
    private k.b gyi;
    private IListener gyj = new IListener<pd>() {
        /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass4 */

        {
            AppMethodBeat.i(160779);
            this.__eventId = pd.class.getName().hashCode();
            AppMethodBeat.o(160779);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pd pdVar) {
            AppMethodBeat.i(12694);
            pd pdVar2 = pdVar;
            String str = pdVar2.dVh.dVi;
            String str2 = pdVar2.dVh.dVj;
            int i2 = pdVar2.dVh.ret;
            if (i2 != 0 && str2 != null) {
                com.tencent.mm.ui.base.h.c(RoomCardUI.this, str2, str, true);
                if (RoomCardUI.this.gyi != null) {
                    ((l) g.af(l.class)).aSM().e(RoomCardUI.this.gyi);
                }
            } else if (i2 == 0) {
                if (!RoomCardUI.this.gyk) {
                    RoomCardUI.j(RoomCardUI.this);
                } else {
                    RoomCardUI.a(RoomCardUI.this, RoomCardUI.this.gxZ.getText().toString());
                }
            }
            if (!RoomCardUI.this.gyk && RoomCardUI.this.gxX != null && RoomCardUI.this.gxX.isShowing()) {
                RoomCardUI.this.gxX.dismiss();
            }
            AppMethodBeat.o(12694);
            return false;
        }
    };
    private boolean gyk = false;

    public RoomCardUI() {
        AppMethodBeat.i(12704);
        AppMethodBeat.o(12704);
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI, int i2, int i3, String str) {
        AppMethodBeat.i(194177);
        roomCardUI.e(i2, i3, str);
        AppMethodBeat.o(194177);
    }

    static /* synthetic */ void c(RoomCardUI roomCardUI) {
        AppMethodBeat.i(12722);
        roomCardUI.goBack();
        AppMethodBeat.o(12722);
    }

    static /* synthetic */ void d(RoomCardUI roomCardUI) {
        AppMethodBeat.i(12723);
        roomCardUI.amS();
        AppMethodBeat.o(12723);
    }

    static /* synthetic */ boolean e(RoomCardUI roomCardUI) {
        AppMethodBeat.i(12724);
        boolean amR = roomCardUI.amR();
        AppMethodBeat.o(12724);
        return amR;
    }

    static /* synthetic */ void j(RoomCardUI roomCardUI) {
        AppMethodBeat.i(194178);
        roomCardUI.amT();
        AppMethodBeat.o(194178);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bnb;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(12705);
        setMMTitle(R.string.g8h);
        getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.afz)));
        this.gyh = new h(this);
        getWindow().setSoftInputMode(48);
        this.gyh.Quk = new com.tencent.mm.ui.tools.g() {
            /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.tools.g
            public final void y(int i2, boolean z) {
                AppMethodBeat.i(12691);
                if (i2 > 0) {
                    ViewGroup viewGroup = (ViewGroup) RoomCardUI.this.findViewById(R.id.hcs);
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (-1 == layoutParams.height) {
                        layoutParams.width = -1;
                        layoutParams.height = viewGroup.getHeight() - i2;
                        viewGroup.requestLayout();
                    }
                    AppMethodBeat.o(12691);
                    return;
                }
                ViewGroup viewGroup2 = (ViewGroup) RoomCardUI.this.findViewById(R.id.hcs);
                ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                viewGroup2.requestLayout();
                AppMethodBeat.o(12691);
            }
        };
        addTextOptionMenu(0, getString(R.string.tt), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12696);
                if (menuItem.getTitle().equals(RoomCardUI.this.getString(R.string.vl))) {
                    RoomCardUI.a(RoomCardUI.this);
                }
                RoomCardUI.this.gxZ.setEnabled(true);
                RoomCardUI.this.gxZ.setFocusableInTouchMode(true);
                RoomCardUI.this.gxZ.setFocusable(true);
                RoomCardUI.this.gxZ.setCursorVisible(true);
                RoomCardUI.this.updateOptionMenuText(0, RoomCardUI.this.getString(R.string.vl));
                RoomCardUI.this.enableOptionMenu(false);
                RoomCardUI.this.showVKB();
                RoomCardUI.this.gxZ.setSelection(RoomCardUI.this.gxZ.getText().toString().length());
                AppMethodBeat.o(12696);
                return true;
            }
        }, null, t.b.GREEN);
        enableOptionMenu(true);
        this.gyf = (LinearLayout) findViewById(R.id.dok);
        this.gyg = (LinearLayout) findViewById(R.id.h8c);
        this.gxZ = (MMEditText) findViewById(R.id.g25);
        this.gya = (TextView) findViewById(R.id.g28);
        this.gyb = (TextView) findViewById(R.id.g27);
        this.gyd = (LinearLayout) findViewById(R.id.h8f);
        this.gyc = (ImageView) findViewById(R.id.g26);
        this.gye = (LinearLayout) findViewById(R.id.h8m);
        this.gxZ.setText(this.gxU);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.gxZ.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) - 100);
        Bundle Ao = com.tencent.mm.pluginsdk.ui.span.t.Ao(true);
        Ao.putInt("geta8key_scene", 31);
        com.tencent.mm.pluginsdk.ui.span.l.a(this.gxZ, Ao, com.tencent.mm.pluginsdk.ui.span.l.Krf);
        this.gxY = (TextView) findViewById(R.id.eaj);
        this.gxY.setText(Integer.toString(f.dp(280, this.gxU)));
        this.gye.setVisibility(8);
        this.gxZ.setCursorVisible(false);
        this.gxZ.setFocusable(false);
        if (this.gxS || this.gxT) {
            this.gyg.setVisibility(8);
        } else {
            removeOptionMenu(0);
            this.gyg.setVisibility(0);
            this.gxZ.setFocusable(false);
            this.gxZ.setCursorVisible(false);
            this.gxZ.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass7 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(12697);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomCardUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    RoomCardUI.a(RoomCardUI.this, RoomCardUI.this.gxZ);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/chatroom/ui/RoomCardUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(12697);
                    return true;
                }
            });
        }
        if (this.gxW != 0) {
            this.gya.setVisibility(0);
            this.gya.setText(com.tencent.mm.pluginsdk.i.f.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, this.gxW));
        } else {
            this.gya.setVisibility(8);
        }
        if (Util.isNullOrNil(this.gxU)) {
            this.gxZ.setEnabled(true);
            this.gxZ.setFocusableInTouchMode(true);
            this.gxZ.setFocusable(true);
            this.gyf.setVisibility(8);
            this.gxZ.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) + 100);
            this.gxZ.requestFocus();
            this.gxZ.setCursorVisible(true);
            updateOptionMenuText(0, getContext().getString(R.string.vl));
            amS();
            this.gxZ.performClick();
            showVKB();
        } else {
            this.gyf.setVisibility(0);
        }
        this.gyb.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, aa.getDisplayName(this.gxV), this.gyb.getTextSize()));
        ImageView imageView = this.gyc;
        String str = this.gxV;
        if (Util.isNullOrNil(str)) {
            imageView.setImageResource(R.drawable.bca);
        } else {
            a.b.c(imageView, str);
        }
        this.gxZ.addTextChangedListener(new a(this, (byte) 0));
        AppMethodBeat.o(12705);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12706);
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 0, 1, true);
        g.aAg().hqi.a(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, this);
        this.gwx = getIntent().getStringExtra("RoomInfo_Id");
        this.gxU = getIntent().getStringExtra("room_notice");
        this.gxV = getIntent().getStringExtra("room_notice_editor");
        this.gxW = getIntent().getLongExtra("room_notice_publish_time", 0);
        this.gxP = getIntent().getStringExtra("room_name");
        this.gxQ = getIntent().getIntExtra("room_member_count", 0);
        this.gxR = getIntent().getStringExtra("room_owner_name");
        this.gxS = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.gxT = getIntent().getBooleanExtra("Is_RoomManager", false);
        initView();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12700);
                RoomCardUI.c(RoomCardUI.this);
                AppMethodBeat.o(12700);
                return true;
            }
        });
        AppMethodBeat.o(12706);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(12707);
        super.onResume();
        this.gyh.start();
        AppMethodBeat.o(12707);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(12708);
        AppMethodBeat.at(this, z);
        super.onWindowFocusChanged(z);
        if (z) {
            this.gyh.start();
        }
        AppMethodBeat.o(12708);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(12709);
        super.onPause();
        this.gyh.close();
        AppMethodBeat.o(12709);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12710);
        super.onDestroy();
        g.aAg().hqi.b(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, this);
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
        }
        AppMethodBeat.o(12710);
    }

    private void goBack() {
        AppMethodBeat.i(12711);
        if (!this.gxS && !this.gxT) {
            setResult(0);
            finish();
            AppMethodBeat.o(12711);
        } else if (amR()) {
            com.tencent.mm.ui.base.h.c(this, getString(R.string.g64), null, getString(R.string.g66), getString(R.string.g65), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass12 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(12701);
                    RoomCardUI.this.setResult(0);
                    RoomCardUI.this.finish();
                    AppMethodBeat.o(12701);
                }
            });
            AppMethodBeat.o(12711);
        } else {
            setResult(0);
            finish();
            AppMethodBeat.o(12711);
        }
    }

    private boolean amR() {
        AppMethodBeat.i(12712);
        String obj = this.gxZ.getText().toString();
        if (Util.isNullOrNil(obj)) {
            if (Util.isNullOrNil(this.gxU)) {
                AppMethodBeat.o(12712);
                return false;
            }
            AppMethodBeat.o(12712);
            return true;
        } else if (this.gxU == null || !this.gxU.equals(obj)) {
            AppMethodBeat.o(12712);
            return true;
        } else {
            AppMethodBeat.o(12712);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements TextWatcher {
        private int gyn;
        private String gyo;
        private boolean gyp;

        private a() {
            this.gyn = 280;
            this.gyo = "";
            this.gyp = false;
        }

        /* synthetic */ a(RoomCardUI roomCardUI, byte b2) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(12703);
            RoomCardUI.d(RoomCardUI.this);
            AppMethodBeat.o(12703);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    private void amS() {
        AppMethodBeat.i(12713);
        if (amR()) {
            enableOptionMenu(true);
            AppMethodBeat.o(12713);
            return;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(12713);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(12714);
        super.onKeyDown(i2, keyEvent);
        if (keyEvent.getKeyCode() == 4) {
            goBack();
            AppMethodBeat.o(12714);
            return true;
        }
        AppMethodBeat.o(12714);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(12715);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            AppMethodBeat.o(12715);
        } else {
            AppMethodBeat.o(12715);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(12716);
        if (qVar.getType() == 993) {
            e(i2, i3, str);
            AppMethodBeat.o(12716);
            return;
        }
        Log.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", Integer.valueOf(qVar.getType()));
        AppMethodBeat.o(12716);
    }

    private void e(int i2, int i3, String str) {
        AppMethodBeat.i(12717);
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
        }
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
            this.gxU = this.gxZ.getText().toString();
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(219, 15, 1, true);
            amT();
            AppMethodBeat.o(12717);
            return;
        }
        DJ(str);
        Log.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        AppMethodBeat.o(12717);
    }

    private void amT() {
        AppMethodBeat.i(12718);
        Intent intent = new Intent();
        intent.putExtra("room_name", this.gxP);
        intent.putExtra("room_notice", this.gxU);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(12718);
    }

    private void DJ(String str) {
        AppMethodBeat.i(12719);
        Log.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", str);
        com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
        if (Dk != null) {
            Dk.a(this, new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass5 */

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(12695);
                    RoomCardUI.this.finish();
                    AppMethodBeat.o(12695);
                }
            });
        }
        AppMethodBeat.o(12719);
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI) {
        int i2;
        int i3;
        final int i4;
        AppMethodBeat.i(12720);
        if (!roomCardUI.amR()) {
            roomCardUI.amT();
            AppMethodBeat.o(12720);
            return;
        }
        String str = roomCardUI.gxZ.getText().toString();
        String aqt = c.aqt();
        if (Util.isNullOrNil(aqt) || !str.matches(".*[" + aqt + "].*")) {
            roomCardUI.showVKB();
            if (Util.isNullOrNil(roomCardUI.gxZ.getText().toString())) {
                i2 = R.string.hjr;
                i3 = R.string.hjq;
                i4 = 5;
            } else {
                i2 = R.string.fem;
                i3 = R.string.feo;
                i4 = 6;
            }
            com.tencent.mm.ui.base.h.a(roomCardUI, i2, 0, i3, (int) R.string.fen, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass13 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(12702);
                    RoomCardUI roomCardUI = RoomCardUI.this;
                    AppCompatActivity context = RoomCardUI.this.getContext();
                    RoomCardUI.this.getString(R.string.zb);
                    roomCardUI.gxX = com.tencent.mm.ui.base.h.a((Context) context, RoomCardUI.this.getString(R.string.g9e), false, (DialogInterface.OnCancelListener) null);
                    if (RoomCardUI.e(RoomCardUI.this)) {
                        RoomCardUI.this.gyk = false;
                        RoomCardUI.a(RoomCardUI.this, RoomCardUI.this.gxZ.getText().toString());
                        g.aAi();
                        long j2 = ((l) g.af(l.class)).aSN().Kn(RoomCardUI.this.gwx).fve;
                        if (j2 != 0) {
                            ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
                            if (!Util.isNullOrNil(Hb.fRe)) {
                                z.a(RoomCardUI.this.gwx, 1, i4, 2, Hb.fRe, "roomannouncement@app.origin");
                            }
                        }
                    }
                    AppMethodBeat.o(12702);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(12692);
                    RoomCardUI.d(RoomCardUI.this);
                    AppMethodBeat.o(12692);
                }
            });
            AppMethodBeat.o(12720);
            return;
        }
        com.tencent.mm.ui.base.h.c(roomCardUI.getContext(), roomCardUI.getString(R.string.e3v, new Object[]{aqt}), roomCardUI.getString(R.string.zb), true);
        AppMethodBeat.o(12720);
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI, final TextView textView) {
        AppMethodBeat.i(12721);
        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(roomCardUI);
        lVar.HLX = new o.f() {
            /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(12698);
                mVar.add(R.string.t_);
                AppMethodBeat.o(12698);
            }
        };
        lVar.HLY = new o.g() {
            /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(12699);
                if (i2 == 0) {
                    ClipboardHelper.setText(MMApplicationContext.getContext(), null, textView.getText().toString());
                }
                AppMethodBeat.o(12699);
            }
        };
        lVar.gXI();
        AppMethodBeat.o(12721);
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI, String str) {
        AppMethodBeat.i(12725);
        if (roomCardUI.amR()) {
            com.tencent.mm.roomsdk.a.c.a ac = com.tencent.mm.roomsdk.a.b.bhF(roomCardUI.gwx).ac(roomCardUI.gwx, str);
            ac.d(new com.tencent.mm.roomsdk.a.b.a() {
                /* class com.tencent.mm.chatroom.ui.RoomCardUI.AnonymousClass3 */

                @Override // com.tencent.mm.roomsdk.a.b.a
                public final void a(int i2, int i3, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                    AppMethodBeat.i(12693);
                    RoomCardUI.a(RoomCardUI.this, i2, i3, str);
                    AppMethodBeat.o(12693);
                }
            });
            ac.aJu();
        }
        AppMethodBeat.o(12725);
    }
}
