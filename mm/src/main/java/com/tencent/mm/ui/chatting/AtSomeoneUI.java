package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI extends MMActivity {
    private static boolean Pah = false;
    private a Pee;
    private ah gtd;
    private String gzN;
    private String gzO;
    private s gzP;
    private ListView krb;
    private String mTitle;
    private String talker;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34249);
        super.onCreate(bundle);
        this.gzN = getIntent().getStringExtra("Block_list");
        this.gzO = getIntent().getStringExtra("Chatroom_member_list");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        bg.aVF();
        this.gtd = c.aSX().Kd(this.talker);
        if (!(this.gtd == null || this.gtd.field_roomowner == null || !this.gtd.field_roomowner.equals(z.aTY()))) {
            Pah = false;
        }
        initView();
        AppMethodBeat.o(34249);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z = true;
        AppMethodBeat.i(34250);
        setMMTitle(this.mTitle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.chatting.AtSomeoneUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34237);
                AtSomeoneUI.this.setResult(0);
                AtSomeoneUI.this.finish();
                AppMethodBeat.o(34237);
                return true;
            }
        });
        this.gzP = new s((byte) 0);
        this.gzP.Qwi = new s.b() {
            /* class com.tencent.mm.ui.chatting.AtSomeoneUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(34239);
                AtSomeoneUI.this.Pee.DO(str);
                AppMethodBeat.o(34239);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                return false;
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bny() {
                AppMethodBeat.i(34240);
                Log.d("MicroMsg.AtSomeoneUI", "onQuitSearch()");
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.AtSomeoneUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(34238);
                        if (AtSomeoneUI.this.Pee != null) {
                            AtSomeoneUI.this.Pee.DO("");
                        }
                        AppMethodBeat.o(34238);
                    }
                });
                AppMethodBeat.o(34240);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnz() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnA() {
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bnB() {
            }
        };
        addSearchMenu(true, this.gzP);
        this.krb = (ListView) findViewById(R.id.ark);
        as asVar = new as();
        ah ahVar = this.gtd;
        String[] strArr = null;
        if (!Util.isNullOrNil(this.gzO)) {
            strArr = this.gzO.split(",");
            Log.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", Arrays.toString(strArr));
        }
        if (strArr == null && this.gtd != null) {
            Log.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
            strArr = Util.listToString(this.gtd.bax(), ",").split(",");
        }
        if (strArr == null) {
            Object[] objArr = new Object[1];
            if (this.gtd != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.e("MicroMsg.AtSomeoneUI", "WTF! member is null? %s", objArr);
        }
        List linkedList = new LinkedList();
        if (!Util.isNullOrNil(this.gzN)) {
            linkedList = Util.stringsToList(this.gzN.split(","));
        }
        bg.aVF();
        ci aEY = c.aSW().aEY("@t.qq.com");
        if (aEY != null) {
            linkedList.add(aEY.name);
        }
        this.Pee = new a(this, asVar, ahVar, strArr, linkedList);
        this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.chatting.AtSomeoneUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(34241);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Intent intent = new Intent();
                if (i2 != 0 || !AtSomeoneUI.Pah) {
                    as asVar = (as) AtSomeoneUI.this.Pee.getItem(i2 - (AtSomeoneUI.Pah ? 1 : 0));
                    String a2 = AtSomeoneUI.a(AtSomeoneUI.this.gtd, asVar.field_username);
                    if (Util.isNullOrNil(a2)) {
                        a2 = asVar.arI();
                    }
                    intent.putExtra("select_raw_user_name", asVar.field_username);
                    intent.putExtra("Select_Conv_User", a2);
                } else {
                    intent.putExtra("Select_Conv_User", AtSomeoneUI.this.getString(R.string.a4j, new Object[]{""}));
                    intent.putExtra("select_raw_user_name", "notify@all");
                }
                AtSomeoneUI.this.setResult(-1, intent);
                AtSomeoneUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(34241);
            }
        });
        this.krb.setAdapter((ListAdapter) this.Pee);
        AppMethodBeat.o(34250);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(34251);
        super.onPause();
        if (this.gzP != null) {
            this.gzP.gXP();
        }
        AppMethodBeat.o(34251);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(34252);
        this.Pee.ebf();
        super.onDestroy();
        AppMethodBeat.o(34252);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.h9;
    }

    /* access modifiers changed from: package-private */
    public static class a extends com.tencent.mm.ui.s<as> {
        private String[] Paj;
        private Bitmap Pak;
        private ah gtd;
        private List<String> gzY;
        private String gzZ;

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.ui.s
        public final /* bridge */ /* synthetic */ as dWw() {
            return null;
        }

        public a(Context context, as asVar, ah ahVar, String[] strArr, List<String> list) {
            super(context, asVar);
            AppMethodBeat.i(34242);
            this.gtd = ahVar;
            this.Paj = strArr;
            this.gzY = list;
            this.Pak = BitmapUtil.transformDrawableToBitmap(context.getResources().getDrawable(R.raw.at_all_avater));
            AppMethodBeat.o(34242);
        }

        @Override // com.tencent.mm.ui.s
        public final int dWu() {
            AppMethodBeat.i(34243);
            if (AtSomeoneUI.Pah) {
                AppMethodBeat.o(34243);
                return 1;
            }
            AppMethodBeat.o(34243);
            return 0;
        }

        @Override // com.tencent.mm.ui.s
        public final boolean Ox(int i2) {
            return false;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            View view2;
            String a2;
            String str;
            AppMethodBeat.i(34244);
            if (view == null) {
                view2 = View.inflate(this.context, R.layout.h8, null);
                b bVar2 = new b((byte) 0);
                bVar2.gAN = (MaskLayout) view2.findViewById(R.id.v7);
                bVar2.gwR = (TextView) view2.findViewById(R.id.v8);
                bVar2.Pal = (ImageView) view2.findViewById(R.id.be9);
                view2.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            if (i2 != 0 || !AtSomeoneUI.Pah) {
                as asVar = (as) getItem(i2 - (AtSomeoneUI.Pah ? 1 : 0));
                bVar.gwR.setTextColor(com.tencent.mm.cb.a.m(this.context, !ab.JE(asVar.field_username) ? R.color.a0b : R.color.a0c));
                a.b.c((ImageView) bVar.gAN.getContentView(), asVar.field_username);
                if (asVar.field_verifyFlag == 0) {
                    bVar.gAN.setMaskDrawable(null);
                } else if (ay.a.iDs != null) {
                    String rW = ay.a.iDs.rW(asVar.field_verifyFlag);
                    if (rW != null) {
                        bVar.gAN.a(o.Nw(rW), MaskLayout.a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
                    } else {
                        bVar.gAN.setMaskDrawable(null);
                    }
                } else {
                    bVar.gAN.setMaskDrawable(null);
                }
                if (!Util.isNullOrNil(asVar.field_conRemark)) {
                    a2 = asVar.field_conRemark;
                } else {
                    a2 = AtSomeoneUI.a(this.gtd, asVar.field_username);
                }
                if (Util.isNullOrNil(a2)) {
                    str = asVar.arI();
                } else {
                    str = a2;
                }
                if (as.bjp(asVar.field_username)) {
                    ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).a(bVar.gwR.getContext(), bVar.gwR, str, asVar.field_openImAppid, asVar.field_descWordingId, (int) bVar.gwR.getTextSize());
                } else {
                    bVar.gwR.setText(l.b(this.context, str, bVar.gwR.getTextSize()));
                }
                AppMethodBeat.o(34244);
                return view2;
            }
            bVar.Pal.setImageBitmap(this.Pak);
            bVar.gwR.setText(this.context.getResources().getString(R.string.a4j, "@"));
            AppMethodBeat.o(34244);
            return view2;
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            ArrayList arrayList;
            AppMethodBeat.i(34245);
            bg.aVF();
            bv aSN = c.aSN();
            String[] strArr = this.Paj;
            String str = this.gzZ;
            String str2 = this.gzZ;
            if (this.gtd == null || str2 == null || this.Paj == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                String[] strArr2 = this.Paj;
                for (String str3 : strArr2) {
                    String displayName = this.gtd.getDisplayName(str3);
                    if (displayName != null && displayName.contains(str2)) {
                        arrayList.add(str3);
                    }
                }
            }
            setCursor(aSN.a(strArr, "@all.chatroom", str, arrayList, this.gzY));
            super.notifyDataSetChanged();
            AppMethodBeat.o(34245);
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(34246);
            ebf();
            anp();
            AppMethodBeat.o(34246);
        }

        public final void DO(String str) {
            AppMethodBeat.i(34247);
            this.gzZ = str;
            onNotifyChange(null, null);
            AppMethodBeat.o(34247);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ as a(as asVar, Cursor cursor) {
            AppMethodBeat.i(34248);
            bg.aVF();
            as bjF = c.aSN().bjF(as.p(cursor));
            if (bjF == null) {
                bjF = new as();
                bjF.convertFrom(cursor);
                bg.aVF();
                c.aSN().am(bjF);
            }
            AppMethodBeat.o(34248);
            return bjF;
        }
    }

    public static String a(ah ahVar, String str) {
        AppMethodBeat.i(34253);
        if (ahVar == null) {
            AppMethodBeat.o(34253);
            return null;
        }
        String displayName = ahVar.getDisplayName(str);
        AppMethodBeat.o(34253);
        return displayName;
    }

    static class b {
        public ImageView Pal;
        public MaskLayout gAN;
        public TextView gwR;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }
}
