package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ce.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.chatting.l.a;
import com.tencent.mm.ui.chatting.view.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.ui.widget.textview.b;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@a(3)
public class TextPreviewUI extends MMActivity implements i {
    private int Bj;
    private Animation Dof;
    private Animation Dog;
    private boolean KnW = false;
    private TextView PhQ = null;
    private int PkK;
    private com.tencent.mm.ui.widget.textview.a PkL;
    private CharSequence PkM;
    private View PkN;
    private View PkO;
    private View PkP;
    private CustomScrollView PkQ;
    private final int PkR = 1;
    private final int PkS = 2;
    private boolean PkT = false;
    private String PkU;
    private boolean PkV = false;
    boolean PkW = false;
    private ToolsBar PkX;
    private View PkY;
    private TextView Ws = null;
    private int bottom = 0;
    private ca dTX;
    private final int pqh = 0;
    private CharSequence text = null;
    private com.tencent.mm.ui.widget.b.a wnj;
    private com.tencent.mm.pluginsdk.ui.span.i ylW = new com.tencent.mm.pluginsdk.ui.span.i() {
        /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass1 */

        @Override // com.tencent.mm.pluginsdk.ui.span.i
        public final Object a(u uVar) {
            AppMethodBeat.i(232925);
            TextPreviewUI.this.PkV = true;
            AppMethodBeat.o(232925);
            return null;
        }

        @Override // com.tencent.mm.pluginsdk.ui.span.i
        public final Object b(u uVar) {
            return null;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public TextPreviewUI() {
        AppMethodBeat.i(232945);
        AppMethodBeat.o(232945);
    }

    static /* synthetic */ void a(TextPreviewUI textPreviewUI, ca caVar) {
        AppMethodBeat.i(232950);
        textPreviewUI.bQ(caVar);
        AppMethodBeat.o(232950);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.sa;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(34946);
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        if (d.oD(19)) {
            getWindow().setFlags(67109888, 67109888);
        }
        this.PkN = findViewById(R.id.ikk);
        this.text = getIntent().getCharSequenceExtra("key_chat_text");
        this.PkK = getIntent().getIntExtra("key_msg_type", 0);
        long longExtra = getIntent().getLongExtra("Chat_Msg_Id", 0);
        bg.aVF();
        this.dTX = c.aSQ().Hb(longExtra);
        this.Ws = (TextView) findViewById(R.id.dc3);
        this.PhQ = (TextView) findViewById(R.id.dc4);
        CharSequence charSequence = this.text;
        TextView textView = this.PhQ;
        textView.setText(l.a(textView.getContext(), new SpannableString(charSequence).toString(), (int) textView.getTextSize(), 1, t.Ao(getIntent().getBooleanExtra("is_group_chat", false)), null, 1, l.Krf));
        this.text = textView.getText();
        this.Ws.setText(g.gxZ().a(getContext(), this.text, this.Ws.getTextSize()));
        this.PkU = z.aTY();
        a.C2099a aVar = com.tencent.mm.ui.chatting.l.a.PEV;
        a.C2099a.a(this.Ws, this.dTX, bR(this.dTX), this.PkU);
        this.PkO = findViewById(R.id.e6q);
        this.PkP = this.PkO.findViewById(R.id.e5q);
        this.PkQ = (CustomScrollView) findViewById(R.id.dc2);
        this.Ws.setMovementMethod(LinkMovementMethod.getInstance());
        this.Ws.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass11 */

            public final boolean onPreDraw() {
                AppMethodBeat.i(232936);
                TextPreviewUI.this.Ws.getViewTreeObserver().removeOnPreDrawListener(this);
                if (TextPreviewUI.this.Ws.getLineCount() == 1) {
                    TextPreviewUI.this.Ws.setGravity(1);
                }
                AppMethodBeat.o(232936);
                return false;
            }
        });
        this.Dog = AnimationUtils.loadAnimation(getContext(), R.anim.dq);
        this.Dof = AnimationUtils.loadAnimation(getContext(), R.anim.f6do);
        this.wnj = new com.tencent.mm.ui.widget.b.a(getContext(), this.Ws);
        this.wnj.QSv = true;
        this.wnj.QSy = false;
        this.wnj.QSt = new o.e() {
            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.base.o.e
            public final void a(m mVar, View view) {
                AppMethodBeat.i(232937);
                TextPreviewUI.b(TextPreviewUI.this.dTX, 7, 0);
                mVar.clear();
                mVar.b(0, TextPreviewUI.this.getResources().getString(R.string.t_), R.raw.icons_filled_copy);
                int O = br.O(TextPreviewUI.this.dTX);
                if (O <= 0 || O >= b.hB(TextPreviewUI.this.Ws).length()) {
                    mVar.b(1, TextPreviewUI.this.getResources().getString(R.string.f08), R.raw.icons_filled_allselect);
                }
                mVar.b(2, TextPreviewUI.this.getResources().getString(R.string.f06), R.raw.icons_filled_share);
                AppMethodBeat.o(232937);
            }
        };
        this.wnj.QSs = new View.OnCreateContextMenuListener() {
            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass13 */

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            }
        };
        this.wnj.HLY = new o.g() {
            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass14 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(232939);
                switch (menuItem.getItemId()) {
                    case 0:
                        ClipboardHelper.setText(MMApplicationContext.getContext(), TextPreviewUI.this.PkM, TextPreviewUI.this.PkM);
                        if (TextPreviewUI.this.PkL != null) {
                            TextPreviewUI.this.PkL.hbA();
                            TextPreviewUI.this.PkL.QXW = true;
                            TextPreviewUI.this.PkL.QXX = true;
                            TextPreviewUI.this.PkL.hbz();
                        }
                        TextPreviewUI.b(TextPreviewUI.this.dTX, 8, TextPreviewUI.this.PkM == null ? 0 : TextPreviewUI.this.PkM.length());
                        Toast.makeText(TextPreviewUI.this.getContext(), (int) R.string.ta, 0).show();
                        AppMethodBeat.o(232939);
                        return;
                    case 1:
                        if (TextPreviewUI.this.PkL != null) {
                            TextPreviewUI.this.PkL.hbz();
                            TextPreviewUI.this.PkL.hcR();
                            TextPreviewUI.this.PkL.lE(0, TextPreviewUI.this.Ws.getText().length());
                            TextPreviewUI.this.PkL.QXW = false;
                            TextPreviewUI.this.PkL.QXX = false;
                            TextPreviewUI.this.PkL.hcQ();
                        }
                        TextPreviewUI.b(TextPreviewUI.this.dTX, 10, 0);
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass14.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(232938);
                                if (TextPreviewUI.this.PkL != null) {
                                    TextPreviewUI.this.PkL.hcV();
                                }
                                AppMethodBeat.o(232938);
                            }
                        }, 100);
                        AppMethodBeat.o(232939);
                        return;
                    case 2:
                        TextPreviewUI.b(TextPreviewUI.this.dTX, 9, 0);
                        TextPreviewUI.e(TextPreviewUI.this.getContext(), TextPreviewUI.this.PkM);
                        break;
                }
                AppMethodBeat.o(232939);
            }
        };
        AnonymousClass15 r11 = new View.OnTouchListener() {
            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass15 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(232941);
                if (motionEvent.getAction() == 0) {
                    TextPreviewUI.this.PkW = true;
                }
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) {
                    TextPreviewUI.this.PkW = false;
                    if (TextPreviewUI.this.Ws.getMovementMethod() == null) {
                        TextPreviewUI.this.Ws.post(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass15.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(232940);
                                TextPreviewUI.this.Ws.setMovementMethod(LinkMovementMethod.getInstance());
                                AppMethodBeat.o(232940);
                            }
                        });
                    }
                }
                AppMethodBeat.o(232941);
                return false;
            }
        };
        if (this.PkL == null && !br.B(this.dTX) && !br.J(this.dTX)) {
            a.C2147a aVar2 = new a.C2147a(this.Ws, this.wnj, null, null, r11);
            aVar2.QPi = R.color.a6q;
            aVar2.QPj = R.color.kn;
            aVar2.QYh = at.fromDPToPix(getContext(), 20);
            this.PkL = aVar2.hcW();
            this.PkL.QXO = new x() {
                /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass16 */

                @Override // com.tencent.mm.ui.widget.textview.a.d
                public final void as(CharSequence charSequence) {
                    AppMethodBeat.i(232942);
                    TextPreviewUI.this.PkM = charSequence;
                    if (TextPreviewUI.this.PkW) {
                        TextPreviewUI.this.Ws.setMovementMethod(null);
                    }
                    AppMethodBeat.o(232942);
                }
            };
        }
        this.PkN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(232943);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (TextPreviewUI.this.PkL == null || (TextPreviewUI.this.PkL.QXW && TextPreviewUI.this.PkL.QXX)) {
                    TextPreviewUI.this.finish();
                } else {
                    TextPreviewUI.this.PkL.hbA();
                    TextPreviewUI.this.PkL.QXW = true;
                    TextPreviewUI.this.PkL.QXX = true;
                    TextPreviewUI.this.PkL.hbz();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232943);
            }
        });
        this.Ws.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass18 */

            public final void onClick(View view) {
                AppMethodBeat.i(232944);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (TextPreviewUI.this.PkL != null) {
                    if (!TextPreviewUI.this.PkL.QXW || !TextPreviewUI.this.PkL.QXX) {
                        TextPreviewUI.this.PkL.hbA();
                        TextPreviewUI.this.PkL.QXW = true;
                        TextPreviewUI.this.PkL.QXX = true;
                        TextPreviewUI.this.PkL.hbz();
                    } else if (TextPreviewUI.this.PkV) {
                        TextPreviewUI.this.PkV = false;
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(232944);
                        return;
                    } else {
                        TextPreviewUI.this.finish();
                    }
                } else if (TextPreviewUI.this.PkV) {
                    TextPreviewUI.this.PkV = false;
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(232944);
                    return;
                } else {
                    TextPreviewUI.this.finish();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232944);
            }
        });
        if (!Util.isNullOrNil(br.M(this.dTX))) {
            this.PkO.setVisibility(0);
            this.PkP.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(232926);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent(TextPreviewUI.this, WebViewUI.class);
                    intent.putExtra("rawUrl", br.M(TextPreviewUI.this.dTX));
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    TextPreviewUI textPreviewUI = TextPreviewUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(textPreviewUI, bl.axQ(), "com/tencent/mm/ui/chatting/TextPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    textPreviewUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(textPreviewUI, "com/tencent/mm/ui/chatting/TextPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(232926);
                }
            });
        } else if (!br.B(this.dTX) && !br.J(this.dTX)) {
            if (this.PkK == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (!as.bjw(this.dTX.field_talker)) {
                    ViewStub viewStub = (ViewStub) findViewById(R.id.j8a);
                    if (viewStub != null) {
                        this.PkY = viewStub.inflate();
                    }
                    this.PkX = (ToolsBar) findViewById(R.id.is9);
                    this.PkX.setVisibility(0);
                }
                if (this.PkX != null) {
                    this.PkX.b(0, new View.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass8 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(232933);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            if (TextPreviewUI.this.dTX != null) {
                                TextPreviewUI.e(TextPreviewUI.this.getContext(), TextPreviewUI.this.text.toString());
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(232933);
                        }
                    });
                    this.PkX.b(1, new View.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass9 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(232934);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            TextPreviewUI.m(TextPreviewUI.this);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(232934);
                        }
                    });
                    this.PkX.b(2, new View.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass10 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(232935);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            TextPreviewUI.b(TextPreviewUI.this, TextPreviewUI.this.dTX);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(232935);
                        }
                    });
                }
            }
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(232927);
                TextPreviewUI.this.finish();
                AppMethodBeat.o(232927);
                return true;
            }
        });
        this.PkQ.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass4 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(232928);
                switch (motionEvent.getAction()) {
                    case 0:
                        TextPreviewUI.this.KnW = true;
                        break;
                    case 1:
                        TextPreviewUI.this.KnW = false;
                        TextPreviewUI.this.PkT = false;
                        break;
                    case 2:
                        if (!TextPreviewUI.this.PkT) {
                            TextPreviewUI.this.PkT = true;
                            TextPreviewUI.this.KnW = true;
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(232928);
                return false;
            }
        });
        this.PkQ.setOnScrollChangeListener(new CustomScrollView.a() {
            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.CustomScrollView.a
            public final void a(ScrollView scrollView, int i2, int i3) {
                AppMethodBeat.i(232929);
                int i4 = i2 - i3;
                int unused = TextPreviewUI.this.Bj;
                if (scrollView.getChildAt(0).getMeasuredHeight() == scrollView.getHeight() + scrollView.getScrollY()) {
                    TextPreviewUI.this.bottom = scrollView.getScrollY();
                }
                if (scrollView.getScrollY() <= 0 || (scrollView.getScrollY() >= TextPreviewUI.this.bottom - 10 && TextPreviewUI.this.bottom > 0)) {
                    TextPreviewUI.i(TextPreviewUI.this);
                } else if (TextPreviewUI.this.KnW) {
                    if (i3 > i2) {
                        TextPreviewUI.i(TextPreviewUI.this);
                    } else if (i3 < i2) {
                        TextPreviewUI.k(TextPreviewUI.this);
                    }
                    TextPreviewUI.this.KnW = false;
                }
                TextPreviewUI.this.Bj = i4;
                AppMethodBeat.o(232929);
            }
        });
        bg.azz().a(525, this);
        AppMethodBeat.o(34946);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(34947);
        super.onResume();
        f.e(true, true, true);
        if (this.PkL != null) {
            if (!this.PkL.QXW) {
                this.PkL.hcV();
            }
            if (!this.PkL.QXX) {
                this.PkL.hcQ();
            }
        }
        l.a(this.ylW);
        AppMethodBeat.o(34947);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(34948);
        super.onPause();
        f.e(false, true, true);
        l.b(this.ylW);
        AppMethodBeat.o(34948);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(34949);
        finish();
        AppMethodBeat.o(34949);
    }

    private void bQ(final ca caVar) {
        AppMethodBeat.i(34950);
        final com.tencent.mm.ui.chatting.view.c cVar = new com.tencent.mm.ui.chatting.view.c(getContext());
        cVar.PGz = new c.a() {
            /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.chatting.view.c.a
            public final void Nt(long j2) {
                String str;
                k.b aD;
                AppMethodBeat.i(232931);
                cVar.hide();
                h.INSTANCE.idkeyStat(795, 1, 1, false);
                if (!NetUtil.isConnected(TextPreviewUI.this.getContext())) {
                    com.tencent.mm.ui.base.h.c(TextPreviewUI.this.getContext(), TextPreviewUI.this.getString(R.string.fbd), TextPreviewUI.this.getString(R.string.g1a), true);
                    AppMethodBeat.o(232931);
                    return;
                }
                dmn dmn = new dmn();
                dmn.rBX = (int) (j2 / 1000);
                dmn.oUv = 1;
                dmn.MJT = 1;
                try {
                    crk crk = new crk();
                    crk.UserName = caVar.field_talker;
                    crk.Brn = caVar.field_msgSvrId;
                    TextPreviewUI textPreviewUI = TextPreviewUI.this;
                    ca caVar = caVar;
                    if (caVar.isText() || caVar.gDq()) {
                        str = caVar.field_content;
                        int Kp = bp.Kp(str);
                        if (Kp != -1) {
                            str = str.substring(Kp + 1).trim();
                        }
                    } else {
                        if (caVar.gDx() || caVar.gDy()) {
                            String str2 = caVar.field_content;
                            int indexOf = caVar.field_content.indexOf(58);
                            if (indexOf != -1) {
                                str2 = caVar.field_content.substring(indexOf + 1);
                            }
                            if (!(str2 == null || (aD = k.b.aD(str2, caVar.field_reserved)) == null || (aD.type != 53 && aD.type != 57))) {
                                str = aD.title;
                            }
                        }
                        str = AllRemindMsgUI.a(textPreviewUI.getContext(), caVar.getType(), caVar.field_content, caVar.field_isSend);
                        Log.i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", Long.valueOf(caVar.field_msgId), Integer.valueOf(caVar.getType()), str);
                    }
                    crk.Title = str;
                    dmn.Lqr = new com.tencent.mm.bw.b(crk.toByteArray());
                } catch (IOException e2) {
                    Log.e("MicroMsg.TextPreviewUI", "[onOk] %s", e2.toString());
                }
                bg.azz().a(new com.tencent.mm.modelsimple.z(1, dmn), 0);
                AppMethodBeat.o(232931);
            }

            @Override // com.tencent.mm.ui.chatting.view.c.a
            public final void onCancel() {
                AppMethodBeat.i(232932);
                cVar.hide();
                AppMethodBeat.o(232932);
            }
        };
        cVar.show();
        AppMethodBeat.o(34950);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(34951);
        super.onDestroy();
        bg.azz().b(525, this);
        AppMethodBeat.o(34951);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(34952);
        if (i2 == 0 && i3 == 0) {
            switch (qVar.getType()) {
                case 525:
                    Log.i("MicroMsg.TextPreviewUI", "set msg remind!");
                    com.tencent.mm.ui.widget.snackbar.b.a(getContext(), getContext().getResources().getString(R.string.dzm), "", (a.b) null);
                    AppMethodBeat.o(34952);
                    return;
                default:
                    AppMethodBeat.o(34952);
                    return;
            }
        } else {
            if (qVar.getType() == 525) {
                Log.e("MicroMsg.TextPreviewUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", 525, Integer.valueOf(i3), Integer.valueOf(i2), Util.nullAsNil(str));
                AppCompatActivity context = getContext();
                if (Util.isNullOrNil(str)) {
                    str = getResources().getString(R.string.g1_);
                }
                com.tencent.mm.ui.base.h.c(context, str, getContext().getResources().getString(R.string.g1a), true);
                h.INSTANCE.idkeyStat(795, 4, 1, false);
            }
            AppMethodBeat.o(34952);
        }
    }

    private static boolean bR(ca caVar) {
        AppMethodBeat.i(232946);
        if (ab.Eq(caVar.field_talker) || ab.Iy(caVar.field_talker)) {
            AppMethodBeat.o(232946);
            return true;
        }
        AppMethodBeat.o(232946);
        return false;
    }

    static /* synthetic */ void b(ca caVar, int i2, int i3) {
        int P;
        int i4 = 1;
        AppMethodBeat.i(232947);
        if (caVar != null && (P = br.P(caVar)) > 0) {
            ga gaVar = new ga();
            int i5 = bR(caVar) ? 2 : 1;
            if (caVar.field_isSend != 1) {
                i4 = 0;
            }
            gaVar.eHz = caVar.field_msgSvrId;
            gaVar.erW = (long) i5;
            gaVar.eIq = (long) i4;
            gaVar.erY = (long) P;
            gaVar.ejA = (long) i2;
            gaVar.eIr = (long) i3;
            gaVar.bfK();
        }
        AppMethodBeat.o(232947);
    }

    static /* synthetic */ void e(Context context, CharSequence charSequence) {
        AppMethodBeat.i(232948);
        Intent intent = new Intent(context, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", charSequence);
        intent.putExtra("Retr_Msg_Type", 4);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/TextPreviewUI", "sendMsg", "(Landroid/content/Context;Ljava/lang/CharSequence;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/TextPreviewUI", "sendMsg", "(Landroid/content/Context;Ljava/lang/CharSequence;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(232948);
    }

    static /* synthetic */ void i(TextPreviewUI textPreviewUI) {
        AppMethodBeat.i(34956);
        if (textPreviewUI.PkY != null && Util.isNullOrNil(br.M(textPreviewUI.dTX))) {
            textPreviewUI.PkY.setAnimation(textPreviewUI.Dog);
            textPreviewUI.PkY.setVisibility(0);
        }
        AppMethodBeat.o(34956);
    }

    static /* synthetic */ void k(TextPreviewUI textPreviewUI) {
        AppMethodBeat.i(232949);
        if (textPreviewUI.PkY != null) {
            textPreviewUI.PkY.setAnimation(textPreviewUI.Dof);
            textPreviewUI.PkY.setVisibility(8);
        }
        AppMethodBeat.o(232949);
    }

    static /* synthetic */ void m(TextPreviewUI textPreviewUI) {
        AppMethodBeat.i(232951);
        cz czVar = new cz();
        com.tencent.mm.pluginsdk.model.h.d(czVar, textPreviewUI.dTX);
        czVar.dFZ.activity = textPreviewUI;
        czVar.dFZ.dGf = 43;
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(232951);
    }

    static /* synthetic */ void b(TextPreviewUI textPreviewUI, final ca caVar) {
        AppMethodBeat.i(232952);
        bg.aVF();
        if (((Boolean) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            com.tencent.mm.ui.base.h.d(textPreviewUI.getContext(), textPreviewUI.getResources().getString(R.string.g1d), textPreviewUI.getResources().getString(R.string.g1e), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.TextPreviewUI.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(232930);
                    TextPreviewUI.a(TextPreviewUI.this, caVar);
                    AppMethodBeat.o(232930);
                }
            });
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN, Boolean.FALSE);
            AppMethodBeat.o(232952);
            return;
        }
        textPreviewUI.bQ(caVar);
        AppMethodBeat.o(232952);
    }
}
