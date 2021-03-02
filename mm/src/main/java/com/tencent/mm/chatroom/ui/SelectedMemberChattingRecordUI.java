package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.mm.plugin.i.a.d;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.s;
import java.util.Map;

public class SelectedMemberChattingRecordUI extends MMActivity {
    private static final f<Integer, c> gAU = new com.tencent.mm.memory.a.c(32);
    private int cSs = 0;
    private MMLoadMoreListView gAR;
    private a gAS;
    private String gAT;
    private View gAx;
    private View gAy;
    private String gwx;
    private String mTitle;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12986);
        super.onCreate(bundle);
        Log.i("MicroMsg.SelectedMemberChattingRecordUI", "[onCreate]");
        this.gwx = getIntent().getStringExtra("RoomInfo_Id");
        this.gAT = getIntent().getStringExtra("room_member");
        Log.i("MicroMsg.SelectedMemberChattingRecordUI", "roomId:%s", this.gwx);
        this.mTitle = getIntent().getStringExtra("title");
        setMMTitle(Util.nullAsNil(this.mTitle));
        this.gAy = findViewById(R.id.hi9);
        h.RTc.aY(new Runnable() {
            /* class com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(194195);
                if (!Util.isNullOrNil(SelectedMemberChattingRecordUI.this.gAT) && z.Im(SelectedMemberChattingRecordUI.this.gAT)) {
                    SelectedMemberChattingRecordUI.this.cSs = ((l) g.af(l.class)).eiy().aET(SelectedMemberChattingRecordUI.this.gwx);
                } else if (!z.Im(SelectedMemberChattingRecordUI.this.gAT)) {
                    SelectedMemberChattingRecordUI.this.cSs = ((l) g.af(l.class)).eiy().iI(SelectedMemberChattingRecordUI.this.gwx, SelectedMemberChattingRecordUI.this.gAT);
                }
                if (SelectedMemberChattingRecordUI.this.isFinishing() || SelectedMemberChattingRecordUI.this.isDestroyed()) {
                    AppMethodBeat.o(194195);
                    return;
                }
                SelectedMemberChattingRecordUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(194194);
                        try {
                            SelectedMemberChattingRecordUI.this.initView();
                            AppMethodBeat.o(194194);
                        } catch (Throwable th) {
                            Log.e("MicroMsg.SelectedMemberChattingRecordUI", "initView failed, exception : " + th.getMessage());
                            AppMethodBeat.o(194194);
                        }
                    }
                });
                AppMethodBeat.o(194195);
            }
        });
        AppMethodBeat.o(12986);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(12987);
        super.initView();
        this.gAy.setVisibility(8);
        this.gAR = (MMLoadMoreListView) findViewById(R.id.fcl);
        this.gAR.gKM();
        this.gAS = new a(this, this.gwx, this.gAT, this.cSs);
        this.gAR.setAdapter((ListAdapter) this.gAS);
        this.gAx = findViewById(R.id.hi8);
        if (this.cSs == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.gAx.setVisibility(0);
            this.gAR.setVisibility(8);
        }
        this.gAR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(194196);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SelectedMemberChattingRecordUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                ca caVar = (ca) SelectedMemberChattingRecordUI.this.gAS.getItem(i2);
                if (caVar != null) {
                    SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, caVar.field_msgId);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectedMemberChattingRecordUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(194196);
            }
        });
        this.gAR.setOnLoadMoreListener(new MMLoadMoreListView.a() {
            /* class com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.MMLoadMoreListView.a
            public final void onLoadMore() {
                AppMethodBeat.i(194197);
                if (SelectedMemberChattingRecordUI.this.gAS != null) {
                    a aVar = SelectedMemberChattingRecordUI.this.gAS;
                    aVar.gAY -= 16;
                    if (!Util.isNullOrNil(SelectedMemberChattingRecordUI.this.gAT) && z.Im(SelectedMemberChattingRecordUI.this.gAT)) {
                        aVar.setCursor(((l) g.af(l.class)).eiy().eG(aVar.gAn, aVar.gAZ - aVar.gAY));
                    } else if (!z.Im(SelectedMemberChattingRecordUI.this.gAT)) {
                        aVar.setCursor(((l) g.af(l.class)).eiy().ae(aVar.gAn, aVar.gAX, aVar.gAZ - aVar.gAY));
                    }
                    SelectedMemberChattingRecordUI.this.gAS.notifyDataSetChanged();
                }
                AppMethodBeat.o(194197);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(194198);
                SelectedMemberChattingRecordUI.this.setResult(0);
                SelectedMemberChattingRecordUI.this.finish();
                AppMethodBeat.o(194198);
                return true;
            }
        });
        AppMethodBeat.o(12987);
    }

    public class a extends s<ca> {
        String gAX;
        int gAY = -1;
        int gAZ = -1;
        String gAn;
        private ah gBa;
        Context mContext;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ ca a(ca caVar, Cursor cursor) {
            AppMethodBeat.i(12985);
            ca caVar2 = caVar;
            if (caVar2 == null) {
                caVar2 = new ca();
            }
            caVar2.convertFrom(cursor);
            AppMethodBeat.o(12985);
            return caVar2;
        }

        public a(Context context, String str, String str2, int i2) {
            super(context, new ca());
            AppMethodBeat.i(12980);
            this.mContext = context;
            this.gAZ = i2;
            this.gAn = str;
            this.gAX = str2;
            this.gBa = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(SelectedMemberChattingRecordUI.this.gwx);
            AppMethodBeat.o(12980);
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            AppMethodBeat.i(12981);
            if (this.gAY < 0 || this.gAY > this.gAZ) {
                this.gAY = this.gAZ - 16;
            }
            if (Util.isNullOrNil(SelectedMemberChattingRecordUI.this.gAT) || !z.Im(SelectedMemberChattingRecordUI.this.gAT)) {
                if (!z.Im(SelectedMemberChattingRecordUI.this.gAT)) {
                    setCursor(((l) g.af(l.class)).eiy().ae(this.gAn, this.gAX, this.gAZ - this.gAY));
                }
                AppMethodBeat.o(12981);
                return;
            }
            setCursor(((l) g.af(l.class)).eiy().eG(this.gAn, this.gAZ - this.gAY));
            AppMethodBeat.o(12981);
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(12982);
            anp();
            AppMethodBeat.o(12982);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            String a2;
            String str;
            cn aEZ;
            AppMethodBeat.i(12983);
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.layout.b72, (ViewGroup) null, false);
                b bVar = new b((byte) 0);
                bVar.gvv = (ImageView) view.findViewById(R.id.x1);
                bVar.gvw = (TextView) view.findViewById(R.id.fzg);
                bVar.gBb = (TextView) view.findViewById(R.id.fn8);
                bVar.timeTV = (TextView) view.findViewById(R.id.j0l);
                view.setTag(bVar);
            }
            ca caVar = (ca) getItem(i2);
            b bVar2 = (b) view.getTag();
            a.b.c(bVar2.gvv, this.gAX);
            as Kn = ((l) g.af(l.class)).aSN().Kn(this.gAX);
            if (!Util.isNullOrNil(Kn.field_conRemark)) {
                a2 = Kn.field_conRemark;
            } else {
                a2 = SelectedMemberChattingRecordUI.a(this.gBa, Kn.field_username);
            }
            if (Util.isNullOrNil(a2)) {
                str = Kn.arI();
            } else {
                str = a2;
            }
            if (!com.tencent.mm.contact.c.oR(Kn.field_type) && (aEZ = ((l) g.af(l.class)).aSO().aEZ(Kn.field_username)) != null && !Util.isNullOrNil(aEZ.field_conRemark)) {
                str = aEZ.field_conRemark;
            }
            a(str, bVar2.gvw);
            a(SelectedMemberChattingRecordUI.a(MMApplicationContext.getContext(), caVar.getType(), caVar.field_content, this.gAX, caVar.field_isSend).trim(), bVar2.gBb);
            a(com.tencent.mm.pluginsdk.i.f.c(SelectedMemberChattingRecordUI.this, caVar.field_createTime, true), bVar2.timeTV);
            AppMethodBeat.o(12983);
            return view;
        }

        private static boolean a(CharSequence charSequence, TextView textView) {
            AppMethodBeat.i(12984);
            if (charSequence == null || charSequence.length() == 0) {
                textView.setVisibility(8);
                AppMethodBeat.o(12984);
                return false;
            }
            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(textView.getContext(), charSequence));
            textView.setVisibility(0);
            AppMethodBeat.o(12984);
            return true;
        }
    }

    static class b {
        public TextView gBb;
        public ImageView gvv;
        public TextView gvw;
        public TextView timeTV;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    protected static String a(ah ahVar, String str) {
        AppMethodBeat.i(12988);
        if (ahVar == null) {
            AppMethodBeat.o(12988);
            return null;
        }
        String displayName = ahVar.getDisplayName(str);
        AppMethodBeat.o(12988);
        return displayName;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bpq;
    }

    public static String a(Context context, int i2, String str, String str2, int i3) {
        String str3;
        String str4;
        String str5;
        c cVar;
        Map<String, String> parseXml;
        AppMethodBeat.i(12989);
        String str6 = "";
        k.b HD = k.b.HD(str);
        switch (i2) {
            case -1879048186:
                str6 = context.getString(R.string.fwp, HD.title);
                break;
            case -1879048185:
            case -1879048183:
            case -1879048176:
                str6 = context.getString(R.string.fvh, HD.title);
                break;
            case 1:
                str6 = str.substring(str.indexOf(":\n") + 1);
                break;
            case 3:
            case 23:
            case 33:
                str6 = context.getString(R.string.xr);
                break;
            case 34:
                str6 = context.getString(R.string.fx7, Integer.valueOf((int) com.tencent.mm.modelvoice.s.AO(new p(str).time)));
                break;
            case 37:
                if (str != null && str.length() > 0) {
                    ca.d bkD = ca.d.bkD(str);
                    if (bkD.dkU != null && bkD.dkU.length() > 0) {
                        switch (bkD.scene) {
                            case 18:
                                str6 = context.getString(R.string.dg2, bkD.getDisplayName());
                                break;
                            case 19:
                            case 20:
                            case 21:
                            default:
                                str6 = context.getString(R.string.dgk, bkD.getDisplayName());
                                break;
                            case 22:
                            case 23:
                            case 24:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                                str6 = context.getString(R.string.dgb, bkD.getDisplayName());
                                break;
                            case 25:
                                str6 = context.getString(R.string.de6, bkD.getDisplayName());
                                break;
                        }
                    }
                }
            case 42:
            case 66:
                if (Util.nullAsNil(str).length() > 0) {
                    String Ks = bp.Ks(str);
                    if (!TextUtils.isEmpty(Ks)) {
                        str2 = Ks;
                    }
                    ca.a aEK = ((l) g.af(l.class)).eiy().aEK(str);
                    String arJ = ((l) g.af(l.class)).aSN().Kn(str2).arJ();
                    if (ab.Eq(arJ)) {
                        arJ = v.an(v.If(arJ));
                    }
                    if (i3 != 1) {
                        str6 = context.getString(R.string.de8, arJ, aEK.getDisplayName());
                        break;
                    } else {
                        str6 = context.getString(R.string.de7, arJ, aEK.getDisplayName());
                        break;
                    }
                }
                break;
            case 43:
            case 62:
            case 486539313:
                str6 = context.getString(62 == i2 ? R.string.z1 : R.string.zv);
                break;
            case 47:
                str6 = context.getString(R.string.tu);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                str6 = context.getString(R.string.fwb, ((l) g.af(l.class)).eiy().aEL(str).label);
                break;
            case 49:
            case 805306417:
            case 822083633:
                if (HD != null) {
                    switch (HD.type) {
                        case 1:
                        case 53:
                        case n.CTRL_INDEX /*{ENCODED_INT: 57}*/:
                            str6 = HD.title;
                            break;
                        case 2:
                            str6 = context.getString(R.string.xr);
                            break;
                        case 3:
                            str6 = context.getString(R.string.fwh, HD.title);
                            break;
                        case 4:
                            str6 = context.getString(R.string.fx3, HD.title);
                            break;
                        case 5:
                            str6 = context.getString(R.string.fx2, HD.getTitle());
                            break;
                        case 6:
                            str6 = context.getString(R.string.fvu, HD.title);
                            break;
                        case 7:
                            break;
                        case 8:
                            str6 = context.getString(R.string.tv);
                            break;
                        case 15:
                        case 26:
                        case 27:
                            str6 = context.getString(R.string.tu);
                            break;
                        case 17:
                            str6 = context.getString(R.string.fwb, HD.title);
                            break;
                        case 19:
                            str6 = context.getString(R.string.fwj, HD.title);
                            break;
                        case 24:
                            String str7 = HD.ixl;
                            if (Util.isNullOrNil(str7)) {
                                Log.e("MicroMsg.SelectedMemberChattingRecordUI", "xml is null");
                                cVar = null;
                            } else {
                                int hashCode = str7.hashCode();
                                cVar = gAU.get(Integer.valueOf(hashCode));
                                if (cVar != null) {
                                    Log.d("MicroMsg.SelectedMemberChattingRecordUI", "get record msg data from cache");
                                } else {
                                    if (str7.trim().startsWith("<recordinfo>")) {
                                        parseXml = XmlParser.parseXml(str7, "recordinfo", null);
                                    } else {
                                        parseXml = XmlParser.parseXml("<recordinfo>" + str7 + "</recordinfo>", "recordinfo", null);
                                    }
                                    if (parseXml == null) {
                                        Log.e("MicroMsg.SelectedMemberChattingRecordUI", "values is null: %s", str7);
                                        cVar = null;
                                    } else {
                                        c cVar2 = new c();
                                        cVar2.title = parseXml.get(".recordinfo.title");
                                        cVar2.desc = parseXml.get(".recordinfo.desc");
                                        cVar2.BGs = parseXml.get(".recordinfo.favusername");
                                        gAU.put(Integer.valueOf(hashCode), cVar2);
                                        cVar = cVar2;
                                    }
                                }
                            }
                            str6 = context.getString(R.string.fwi, Util.nullAs(cVar == null ? "" : cVar.desc, ""));
                            break;
                        case 25:
                            str6 = context.getString(R.string.ti);
                            break;
                        case 33:
                        case 36:
                        case 44:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            if (!Util.isNullOrNil(HD.title)) {
                                str6 = context.getString(R.string.fvi, HD.title);
                                break;
                            } else {
                                str6 = context.getString(R.string.fvi, "");
                                break;
                            }
                        default:
                            str6 = "";
                            break;
                    }
                } else {
                    Log.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
                    AppMethodBeat.o(12989);
                    return "";
                }
            case 369098801:
            case 452984881:
                str6 = context.getString(R.string.fvp, HD.title);
                break;
            case 419430449:
                str6 = context.getString(R.string.fwk);
                if (HD != null) {
                    boolean z = i3 == 1;
                    switch (HD.ixN) {
                        case 1:
                            if (!z) {
                                str6 = context.getString(R.string.a4e);
                                break;
                            } else {
                                str6 = context.getString(R.string.a49);
                                break;
                            }
                        case 2:
                        default:
                            str6 = Util.nullAsNil(HD.title);
                            break;
                        case 3:
                            if (!z) {
                                str6 = context.getString(R.string.a47);
                                break;
                            } else {
                                str6 = context.getString(R.string.a4_);
                                break;
                            }
                        case 4:
                            if (!z) {
                                str6 = context.getString(R.string.a48);
                                break;
                            } else {
                                str6 = context.getString(R.string.a4c);
                                break;
                            }
                    }
                }
                break;
            case 436207665:
            case 469762097:
                if (HD != null) {
                    if (i3 != 1) {
                        str6 = context.getString(R.string.fvo, HD.iyo, HD.iyk);
                        break;
                    } else {
                        str6 = context.getString(R.string.fvo, HD.iyo, HD.iyl);
                        break;
                    }
                } else {
                    Log.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
                    AppMethodBeat.o(12989);
                    return "";
                }
            case 503316529:
                if (HD != null) {
                    if (i3 != 1) {
                        str6 = context.getString(R.string.fvo, HD.iyo, HD.iyB);
                        break;
                    } else {
                        str6 = context.getString(R.string.fvo, HD.iyo, HD.iyC);
                        break;
                    }
                } else {
                    Log.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
                    AppMethodBeat.o(12989);
                    return "";
                }
            case 520093745:
                str6 = context.getString(R.string.fvp, "");
                break;
            case 754974769:
                str3 = context.getString(R.string.vg);
                com.tencent.mm.plugin.i.a.f fVar = (com.tencent.mm.plugin.i.a.f) HD.as(com.tencent.mm.plugin.i.a.f.class);
                if (!(fVar == null || fVar.jlg == null || Util.isNullOrNil(fVar.jlg.nickname))) {
                    if (Util.isNullOrNil(fVar.jlg.desc)) {
                        str5 = context.getString(R.string.fwn, fVar.jlg.nickname);
                    } else {
                        str5 = fVar.jlg.desc;
                    }
                    str6 = str3 + str5;
                    break;
                }
                str6 = str3;
                break;
            case 838860849:
            case 1006633009:
                str3 = context.getString(R.string.vg);
                com.tencent.mm.plugin.i.a.h hVar = (com.tencent.mm.plugin.i.a.h) HD.as(com.tencent.mm.plugin.i.a.h.class);
                if (!(hVar == null || hVar.jld == null || Util.isNullOrNil(hVar.jld.dST))) {
                    if (hVar.jld.tvC != 1) {
                        str6 = str3 + hVar.jld.dST;
                        break;
                    } else {
                        str6 = str3 + MMApplicationContext.getContext().getString(R.string.fw5, hVar.jld.dST);
                        break;
                    }
                }
                str6 = str3;
                break;
            case 855638065:
                str6 = context.getString(R.string.fwo, HD.title);
                break;
            case 956301361:
                String string = context.getString(R.string.vg);
                d dVar = (d) HD.as(d.class);
                if (dVar != null && !Util.isNullOrNil(dVar.jle.title)) {
                    str6 = string + dVar.jle.title;
                    break;
                } else {
                    str6 = string;
                    break;
                }
                break;
            case 1023410225:
                str3 = context.getString(R.string.vg);
                i iVar = (i) HD.as(i.class);
                if (!(iVar == null || iVar.jlh == null || Util.isNullOrNil(iVar.jlh.nickname))) {
                    if (Util.isNullOrNil(iVar.jlh.desc)) {
                        str4 = context.getString(R.string.fwn, iVar.jlh.nickname);
                    } else {
                        str4 = iVar.jlh.desc;
                    }
                    str6 = str3 + str4;
                    break;
                }
                str6 = str3;
                break;
            case 1040187441:
                str6 = context.getString(R.string.fwh, HD.title);
                break;
        }
        AppMethodBeat.o(12989);
        return str6;
    }

    static {
        AppMethodBeat.i(12991);
        AppMethodBeat.o(12991);
    }

    static /* synthetic */ void a(SelectedMemberChattingRecordUI selectedMemberChattingRecordUI, long j2) {
        AppMethodBeat.i(194199);
        Log.i("MicroMsg.SelectedMemberChattingRecordUI", "[goToChattingUI] msgLocalId:%s", Long.valueOf(j2));
        com.tencent.mm.br.c.f(selectedMemberChattingRecordUI, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", selectedMemberChattingRecordUI.gwx).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", j2));
        AppMethodBeat.o(194199);
    }
}
