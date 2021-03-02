package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.v;
import java.util.HashMap;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI extends MMActivity {
    private List<String> Qhr;
    private a Qhs;
    private ListView krb;
    private int[] utT = new int[2];

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingCheckUnProcessWalletConvUI() {
        AppMethodBeat.i(38753);
        AppMethodBeat.o(38753);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38754);
        super.onCreate(bundle);
        setMMTitle(R.string.ibf);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38737);
                SettingCheckUnProcessWalletConvUI.this.finish();
                AppMethodBeat.o(38737);
                return false;
            }
        });
        this.krb = (ListView) findViewById(R.id.bfv);
        this.Qhr = getIntent().getStringArrayListExtra("key_conversation_list");
        if (this.Qhr != null && this.Qhr.size() > 0) {
            this.Qhs = new a();
            this.krb.setAdapter((ListAdapter) this.Qhs);
            this.krb.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.AnonymousClass2 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(38738);
                    switch (motionEvent.getAction()) {
                        case 0:
                            SettingCheckUnProcessWalletConvUI.this.hideVKB();
                            SettingCheckUnProcessWalletConvUI.this.utT[0] = (int) motionEvent.getRawX();
                            SettingCheckUnProcessWalletConvUI.this.utT[1] = (int) motionEvent.getRawY();
                            break;
                    }
                    AppMethodBeat.o(38738);
                    return false;
                }
            });
            this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.AnonymousClass3 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(38739);
                    b bVar = new b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    az anZ = SettingCheckUnProcessWalletConvUI.this.Qhs.anZ(i2);
                    if (anZ == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(38739);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", anZ.field_username);
                    intent.putExtra("chat_from_scene", 4);
                    c.f(SettingCheckUnProcessWalletConvUI.this, ".ui.chatting.ChattingUI", intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/SettingCheckUnProcessWalletConvUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(38739);
                }
            });
            this.krb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                /* class com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.AnonymousClass4 */

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(38743);
                    final az anZ = SettingCheckUnProcessWalletConvUI.this.Qhs.anZ(i2 - SettingCheckUnProcessWalletConvUI.this.krb.getHeaderViewsCount());
                    if (anZ == null) {
                        AppMethodBeat.o(38743);
                        return true;
                    }
                    final String str = anZ.field_username;
                    com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(SettingCheckUnProcessWalletConvUI.this);
                    aVar.QSs = new View.OnCreateContextMenuListener() {
                        /* class com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.AnonymousClass4.AnonymousClass1 */

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(38740);
                            contextMenu.add(0, 1, 0, R.string.euz);
                            AppMethodBeat.o(38740);
                        }
                    };
                    aVar.a(view, i2, j2, SettingCheckUnProcessWalletConvUI.this, new o.g() {
                        /* class com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.AnonymousClass4.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(38742);
                            if (menuItem.getItemId() == 1) {
                                c.a(str, SettingCheckUnProcessWalletConvUI.this, anZ, new Runnable() {
                                    /* class com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI.AnonymousClass4.AnonymousClass2.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(38741);
                                        SettingCheckUnProcessWalletConvUI.this.Qhr.remove(str);
                                        SettingCheckUnProcessWalletConvUI.this.Qhs.notifyDataSetChanged();
                                        AppMethodBeat.o(38741);
                                    }
                                }, false, true);
                            }
                            AppMethodBeat.o(38742);
                        }
                    }, SettingCheckUnProcessWalletConvUI.this.utT[0], SettingCheckUnProcessWalletConvUI.this.utT[1]);
                    AppMethodBeat.o(38743);
                    return true;
                }
            });
        }
        AppMethodBeat.o(38754);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bqf;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private float Paq = -1.0f;
        protected float Pat = -1.0f;
        private float Pau = -1.0f;
        private ColorStateList[] Pav = new ColorStateList[5];
        private HashMap<String, C2111a> Pax;
        private final int QbV;
        private final int QbW;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(38752);
            az anZ = anZ(i2);
            AppMethodBeat.o(38752);
            return anZ;
        }

        public a() {
            AppMethodBeat.i(38744);
            this.Pav[0] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, R.color.uj);
            this.Pav[1] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, R.color.a0g);
            this.Pav[3] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, R.color.a2x);
            this.Pav[2] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, R.color.a0d);
            this.Pav[2] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, R.color.a0d);
            this.Pav[4] = com.tencent.mm.cb.a.m(SettingCheckUnProcessWalletConvUI.this, R.color.ww);
            if (com.tencent.mm.cb.a.jk(SettingCheckUnProcessWalletConvUI.this)) {
                this.QbW = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.dimen.b2);
                this.QbV = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.dimen.b4);
            } else {
                this.QbW = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.dimen.b1);
                this.QbV = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.dimen.b5);
            }
            this.Paq = (float) com.tencent.mm.cb.a.aG(SettingCheckUnProcessWalletConvUI.this, R.dimen.is);
            this.Pat = (float) com.tencent.mm.cb.a.aG(SettingCheckUnProcessWalletConvUI.this, R.dimen.hc);
            this.Pau = (float) com.tencent.mm.cb.a.aG(SettingCheckUnProcessWalletConvUI.this, R.dimen.kc);
            this.Pax = new HashMap<>();
            AppMethodBeat.o(38744);
        }

        public final int getCount() {
            AppMethodBeat.i(38745);
            int size = SettingCheckUnProcessWalletConvUI.this.Qhr.size();
            AppMethodBeat.o(38745);
            return size;
        }

        public final az anZ(int i2) {
            AppMethodBeat.i(38746);
            bg.aVF();
            az bjY = com.tencent.mm.model.c.aST().bjY((String) SettingCheckUnProcessWalletConvUI.this.Qhr.get(i2));
            AppMethodBeat.o(38746);
            return bjY;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            View view2;
            int i3;
            String[] split;
            AppMethodBeat.i(38747);
            if (view == null) {
                bVar = new b(this, (byte) 0);
                if (com.tencent.mm.cb.a.jk(SettingCheckUnProcessWalletConvUI.this)) {
                    view2 = View.inflate(SettingCheckUnProcessWalletConvUI.this, R.layout.ye, null);
                } else {
                    view2 = View.inflate(SettingCheckUnProcessWalletConvUI.this, R.layout.yd, null);
                }
                bVar.gvv = (ImageView) view2.findViewById(R.id.x1);
                bVar.PaE = (NoMeasuredTextView) view2.findViewById(R.id.fzg);
                bVar.Qcr = (NoMeasuredTextView) view2.findViewById(R.id.i34);
                bVar.PaF = (NoMeasuredTextView) view2.findViewById(R.id.j0l);
                bVar.PaG = (NoMeasuredTextView) view2.findViewById(R.id.e7t);
                bVar.plf = (TextView) view2.findViewById(R.id.iot);
                bVar.plf.setBackgroundResource(v.kH(SettingCheckUnProcessWalletConvUI.this));
                bVar.PaH = (ImageView) view2.findViewById(R.id.dwf);
                bVar.PaJ = view2.findViewById(R.id.x9);
                bVar.PaI = (ImageView) view2.findViewById(R.id.iif);
                bVar.Qcs = (ImageView) view2.findViewById(R.id.eqt);
                view2.setTag(bVar);
                bVar.PaG.setTextSize(0, this.Pat);
                bVar.PaF.setTextSize(0, this.Pau);
                bVar.PaE.setTextSize(0, this.Paq);
                bVar.Qcr.setTextSize(0, this.Pat);
                bVar.PaG.setTextColor(this.Pav[0]);
                bVar.PaF.setTextColor(this.Pav[4]);
                bVar.PaE.setTextColor(this.Pav[3]);
                bVar.Qcr.setTextColor(this.Pav[0]);
                bVar.PaG.setShouldEllipsize(true);
                bVar.PaF.setShouldEllipsize(false);
                bVar.PaE.setShouldEllipsize(true);
                bVar.Qcr.setShouldEllipsize(true);
                bVar.PaF.setGravity(5);
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            az anZ = anZ(i2);
            if (anZ == null) {
                AppMethodBeat.o(38747);
            } else {
                a.b.c(bVar.gvv, anZ.field_username);
                bVar.gvv.getDrawable();
                String str = anZ.field_username;
                C2111a aVar = this.Pax.get(str);
                if (aVar == null) {
                    C2111a aVar2 = new C2111a(this, (byte) 0);
                    aVar2.Qch = -1;
                    aVar2.Qcg = -1;
                    aVar2.Qcm = false;
                    aVar2.Qco = false;
                    aVar2.Qcn = false;
                    aVar2.tcb = ab.Eq(anZ.field_username);
                    aVar2.Qcl = aVar2.tcb && aVar2.Qcn && anZ.field_unReadCount > 0;
                    aVar2.qcr = 0;
                    if (ahn(anZ.field_msgType) == 34 && anZ.field_isSend == 0 && !Util.isNullOrNil(anZ.field_content)) {
                        String str2 = anZ.field_content;
                        if ((str.equals("qmessage") || str.equals("floatbottle")) && (split = str2.split(":")) != null && split.length > 3) {
                            str2 = split[1] + ":" + split[2] + ":" + split[3];
                        }
                        if (!new p(str2).jsi) {
                            aVar2.qcr = 1;
                        }
                    }
                    String displayName = aa.getDisplayName(str);
                    if (!aVar2.tcb || displayName != null) {
                        aVar2.nickName = l.b(SettingCheckUnProcessWalletConvUI.this, aa.getDisplayName(str), bVar.PaE.getTextSize());
                    } else {
                        aVar2.nickName = SettingCheckUnProcessWalletConvUI.this.getString(R.string.b25);
                    }
                    aVar2.Qcd = i(anZ);
                    aVar2.Qce = c(anZ, (int) bVar.PaG.getTextSize(), aVar2.Qcl);
                    aVar2.Qcp = anZ.field_attrflag;
                    switch (anZ.field_status) {
                        case 0:
                            i3 = -1;
                            break;
                        case 1:
                            i3 = R.raw.msg_state_sending;
                            break;
                        case 2:
                            i3 = -1;
                            break;
                        case 3:
                        case 4:
                        default:
                            i3 = -1;
                            break;
                        case 5:
                            i3 = R.raw.msg_state_failed;
                            break;
                    }
                    aVar2.Qcf = i3;
                    aVar2.Qci = ab.a(anZ);
                    bg.aVF();
                    aVar2.PaB = com.tencent.mm.model.c.aST().h(anZ);
                    aVar2.Qcj = false;
                    aVar2.Qck = LocaleUtil.isChineseAppLang();
                    this.Pax.put(str, aVar2);
                    aVar = aVar2;
                }
                if (aVar.Qcd == null) {
                    aVar.Qcd = i(anZ);
                }
                if (aVar.Qcl || ab.Js(anZ.field_parentRef)) {
                    bVar.PaG.setTextColor(this.Pav[0]);
                } else {
                    bVar.PaG.setTextColor(this.Pav[aVar.qcr]);
                }
                if (str.toLowerCase().endsWith("@t.qq.com")) {
                    bVar.PaE.setCompoundRightDrawablesWithIntrinsicBounds(R.drawable.icon_tencent_weibo);
                    bVar.PaE.setDrawRightDrawable(true);
                } else {
                    bVar.PaE.setDrawRightDrawable(false);
                }
                int i4 = aVar.Qcf;
                if (i4 != -1) {
                    bVar.PaG.setCompoundLeftDrawablesWithIntrinsicBounds(i4);
                    bVar.PaG.setDrawLeftDrawable(true);
                } else {
                    bVar.PaG.setDrawLeftDrawable(false);
                }
                bVar.PaE.setText(aVar.nickName);
                bVar.Qcr.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = bVar.PaF.getLayoutParams();
                if (aVar.Qcd.length() > 9) {
                    if (layoutParams.width != this.QbW) {
                        layoutParams.width = this.QbW;
                        bVar.PaF.setLayoutParams(layoutParams);
                    }
                } else if (layoutParams.width != this.QbV) {
                    layoutParams.width = this.QbV;
                    bVar.PaF.setLayoutParams(layoutParams);
                }
                Log.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", Integer.valueOf(layoutParams.width));
                bVar.PaF.setText(aVar.Qcd);
                bVar.PaG.setText(aVar.Qce);
                if (aVar.tcb && aVar.Qcn) {
                    bVar.PaH.setVisibility(0);
                } else if (aVar.Qcj) {
                    bVar.PaH.setVisibility(0);
                } else {
                    bVar.PaH.setVisibility(8);
                }
                a.b.c(bVar.gvv, str);
                if (!aVar.Qci && aVar.PaB && bg.aAc()) {
                    bg.aVF();
                    com.tencent.mm.model.c.aST().g(anZ);
                }
                if (!aVar.PaB || anZ.field_conversationTime == -1) {
                    view2.findViewById(R.id.bg1).setBackgroundResource(R.drawable.qa);
                } else {
                    view2.findViewById(R.id.bg1).setBackgroundResource(R.drawable.q_);
                }
                bVar.PaI.setVisibility(8);
                AppMethodBeat.o(38747);
            }
            return view2;
        }

        private static int ahn(String str) {
            int i2 = 1;
            AppMethodBeat.i(38748);
            if (str != null && str.length() > 0) {
                try {
                    i2 = Integer.valueOf(str).intValue();
                } catch (NumberFormatException e2) {
                }
            }
            AppMethodBeat.o(38748);
            return i2;
        }

        private static String bmp(String str) {
            AppMethodBeat.i(38751);
            if (str == null || str.length() != 32) {
                AppMethodBeat.o(38751);
                return null;
            }
            String amp = ((d) g.ah(d.class)).getEmojiMgr().amp(str);
            AppMethodBeat.o(38751);
            return amp;
        }

        class b {
            public NoMeasuredTextView PaE;
            public NoMeasuredTextView PaF;
            public NoMeasuredTextView PaG;
            public ImageView PaH;
            public ImageView PaI;
            public View PaJ;
            public NoMeasuredTextView Qcr;
            public ImageView Qcs;
            public ImageView gvv;
            public TextView plf;

            private b() {
            }

            /* synthetic */ b(a aVar, byte b2) {
                this();
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI$a$a  reason: collision with other inner class name */
        class C2111a {
            public boolean PaB;
            public CharSequence Qcd;
            public CharSequence Qce;
            public int Qcf;
            public int Qcg;
            public int Qch;
            public boolean Qci;
            public boolean Qcj;
            public boolean Qck;
            public boolean Qcl;
            public boolean Qcm;
            public boolean Qcn;
            public boolean Qco;
            public int Qcp;
            public CharSequence nickName;
            public int qcr;
            public boolean tcb;

            private C2111a() {
            }

            /* synthetic */ C2111a(a aVar, byte b2) {
                this();
            }
        }

        private CharSequence i(az azVar) {
            AppMethodBeat.i(38749);
            if (azVar.field_status == 1) {
                String string = SettingCheckUnProcessWalletConvUI.this.getString(R.string.evg);
                AppMethodBeat.o(38749);
                return string;
            } else if (azVar.field_conversationTime == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                AppMethodBeat.o(38749);
                return "";
            } else {
                CharSequence c2 = f.c(SettingCheckUnProcessWalletConvUI.this, azVar.field_conversationTime, true);
                AppMethodBeat.o(38749);
                return c2;
            }
        }

        private CharSequence c(az azVar, int i2, boolean z) {
            String a2;
            String replace;
            String displayName;
            String str;
            boolean z2;
            boolean z3;
            AppMethodBeat.i(38750);
            if (Util.isNullOrNil(azVar.field_editingMsg) || (azVar.field_atCount > 0 && azVar.field_unReadCount > 0)) {
                String str2 = azVar.field_digest;
                if (str2 == null || !str2.startsWith("<img src=\"original_label.png\"/>  ")) {
                    String str3 = azVar.field_username;
                    if (str3.equals("qqmail")) {
                        bg.aVF();
                        if (Util.nullAsNil((Integer) com.tencent.mm.model.c.azQ().get(17, (Object) null)) == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            String string = SettingCheckUnProcessWalletConvUI.this.getString(R.string.gso);
                            AppMethodBeat.o(38750);
                            return string;
                        }
                    }
                    if (str3.equals("tmessage")) {
                        bg.aVF();
                        ci aEY = com.tencent.mm.model.c.aSW().aEY("@t.qq.com");
                        if (aEY == null || !aEY.isEnable()) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            String string2 = SettingCheckUnProcessWalletConvUI.this.getString(R.string.gso);
                            AppMethodBeat.o(38750);
                            return string2;
                        }
                    }
                    if (azVar.field_msgType != null && (azVar.field_msgType.equals("47") || azVar.field_msgType.equals("1048625"))) {
                        String bmp = bmp(azVar.field_digest);
                        String str4 = "";
                        if (bmp != null) {
                            String str5 = "[" + bmp + "]";
                            AppMethodBeat.o(38750);
                            return str5;
                        }
                        if (azVar.field_digest != null && azVar.field_digest.contains(":")) {
                            str4 = azVar.field_digest.substring(0, azVar.field_digest.indexOf(":"));
                            String bmp2 = bmp(azVar.field_digest.substring(azVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                            if (bmp2 != null) {
                                String str6 = "[" + bmp2 + "]";
                                if (Util.isNullOrNil(str4)) {
                                    AppMethodBeat.o(38750);
                                    return str6;
                                }
                                String str7 = str4 + ": " + str6;
                                AppMethodBeat.o(38750);
                                return str7;
                            }
                        }
                        String string3 = SettingCheckUnProcessWalletConvUI.this.getString(R.string.tu);
                        if (Util.isNullOrNil(str4)) {
                            str = string3;
                        } else {
                            str = str4 + ": " + string3;
                        }
                        azVar.Cm(str);
                    }
                    if (!Util.isNullOrNil(azVar.field_digest)) {
                        if (!Util.isNullOrNil(azVar.field_digestUser)) {
                            if (azVar.field_isSend != 0 || !ab.Eq(azVar.field_username)) {
                                displayName = aa.getDisplayName(azVar.field_digestUser);
                            } else {
                                displayName = aa.getDisplayName(azVar.field_digestUser, azVar.field_username);
                            }
                            try {
                                a2 = String.format(azVar.field_digest, displayName);
                            } catch (Exception e2) {
                            }
                        } else {
                            a2 = azVar.field_digest;
                        }
                        replace = a2.replace('\n', ' ');
                        if (azVar.field_atCount > 0 || azVar.field_unReadCount <= 0) {
                            if (!z && azVar.field_unReadCount > 1) {
                                replace = SettingCheckUnProcessWalletConvUI.this.getString(R.string.euk, new Object[]{Integer.valueOf(azVar.field_unReadCount), replace});
                            } else if (azVar.field_unReadCount > 1 && ab.Js(azVar.field_parentRef)) {
                                replace = SettingCheckUnProcessWalletConvUI.this.getString(R.string.euk, new Object[]{Integer.valueOf(azVar.field_unReadCount), replace});
                            }
                            SpannableString e3 = l.e((Context) SettingCheckUnProcessWalletConvUI.this, (CharSequence) replace, i2);
                            AppMethodBeat.o(38750);
                            return e3;
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(R.string.euh));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                        spannableStringBuilder.append((CharSequence) " ").append((CharSequence) l.e((Context) SettingCheckUnProcessWalletConvUI.this, (CharSequence) replace, i2));
                        AppMethodBeat.o(38750);
                        return spannableStringBuilder;
                    }
                    a2 = h.a(azVar.field_isSend, azVar.field_username, azVar.field_content, ahn(azVar.field_msgType), SettingCheckUnProcessWalletConvUI.this);
                    replace = a2.replace('\n', ' ');
                    if (azVar.field_atCount > 0) {
                    }
                    if (!z) {
                    }
                    replace = SettingCheckUnProcessWalletConvUI.this.getString(R.string.euk, new Object[]{Integer.valueOf(azVar.field_unReadCount), replace});
                    SpannableString e32 = l.e((Context) SettingCheckUnProcessWalletConvUI.this, (CharSequence) replace, i2);
                    AppMethodBeat.o(38750);
                    return e32;
                }
                SpannableString spannableString = new SpannableString(l.e(SettingCheckUnProcessWalletConvUI.this, str2, (float) i2));
                AppMethodBeat.o(38750);
                return spannableString;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(R.string.euq));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder2.append((CharSequence) " ").append((CharSequence) l.e((Context) SettingCheckUnProcessWalletConvUI.this, (CharSequence) azVar.field_editingMsg, i2));
            AppMethodBeat.o(38750);
            return spannableStringBuilder2;
        }
    }
}
