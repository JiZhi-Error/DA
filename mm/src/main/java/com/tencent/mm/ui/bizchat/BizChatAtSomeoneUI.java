package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.s;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI extends MMActivity {
    private static boolean Pah = false;
    private a Paf;
    private c Pag;
    private String gzN;
    private String gzO;
    private s gzP;
    private ListView krb;
    private String mTitle;
    private long ppv;
    private String talker;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33897);
        super.onCreate(bundle);
        this.gzN = getIntent().getStringExtra("Block_list");
        this.gzO = getIntent().getStringExtra("Chatroom_member_list");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        this.ppv = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.Pag = ag.baj().bs(this.ppv);
        if (this.Pag == null) {
            Log.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
            finish();
            AppMethodBeat.o(33897);
            return;
        }
        if (this.Pag != null && this.Pag.field_ownerUserId.equals(z.aTY())) {
            Pah = true;
        }
        initView();
        AppMethodBeat.o(33897);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(33898);
        setMMTitle(this.mTitle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(33887);
                BizChatAtSomeoneUI.this.setResult(0);
                BizChatAtSomeoneUI.this.finish();
                AppMethodBeat.o(33887);
                return true;
            }
        });
        this.gzP = new s((byte) 0);
        this.gzP.Qwi = new s.b() {
            /* class com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.tools.s.b
            public final void SO(String str) {
                AppMethodBeat.i(33888);
                a aVar = BizChatAtSomeoneUI.this.Paf;
                aVar.gzZ = str;
                aVar.onNotifyChange(null, null);
                AppMethodBeat.o(33888);
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final boolean SN(String str) {
                return false;
            }

            @Override // com.tencent.mm.ui.tools.s.b
            public final void bny() {
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
        k kVar = new k();
        c cVar = this.Pag;
        String[] strArr = null;
        if (!Util.isNullOrNil(this.gzO)) {
            strArr = this.gzO.split(";");
            Log.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", Arrays.toString(strArr));
        }
        List linkedList = new LinkedList();
        if (!Util.isNullOrNil(this.gzN)) {
            linkedList = Util.stringsToList(this.gzN.split(";"));
        }
        this.Paf = new a(this, kVar, cVar, strArr, linkedList);
        this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(33889);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatAtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Intent intent = new Intent();
                if (i2 != 0 || !BizChatAtSomeoneUI.Pah) {
                    k kVar = (k) BizChatAtSomeoneUI.this.Paf.getItem(i2);
                    String a2 = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this.Pag, kVar.field_userId);
                    intent.putExtra("select_raw_user_name", kVar.field_userId);
                    intent.putExtra("Select_Conv_User", a2);
                } else {
                    intent.putExtra("Select_Conv_User", BizChatAtSomeoneUI.this.getString(R.string.a4j, new Object[]{""}));
                    intent.putExtra("select_raw_user_name", "notify@all");
                }
                BizChatAtSomeoneUI.this.setResult(-1, intent);
                BizChatAtSomeoneUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatAtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(33889);
            }
        });
        this.krb.setAdapter((ListAdapter) this.Paf);
        this.krb.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI.AnonymousClass4 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(33890);
                q.bcV().onScrollStateChanged(i2);
                AppMethodBeat.o(33890);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        AppMethodBeat.o(33898);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(33899);
        super.onPause();
        if (this.gzP != null) {
            this.gzP.gXP();
        }
        AppMethodBeat.o(33899);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(33900);
        this.Paf.ebf();
        super.onDestroy();
        AppMethodBeat.o(33900);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.h9;
    }

    /* access modifiers changed from: package-private */
    public static class a extends com.tencent.mm.ui.s<k> {
        private c Pag;
        private String[] Paj;
        private Bitmap Pak;
        private com.tencent.mm.av.a.a.c gzE = null;
        private List<String> gzY;
        String gzZ;

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.ui.s
        public final /* bridge */ /* synthetic */ k dWw() {
            return null;
        }

        public a(Context context, k kVar, c cVar, String[] strArr, List<String> list) {
            super(context, kVar);
            AppMethodBeat.i(33891);
            this.Pag = cVar;
            this.Paj = strArr;
            this.gzY = list;
            c.a aVar = new c.a();
            aVar.prefixPath = e.NN(this.Pag.field_brandUserName);
            aVar.jbf = true;
            aVar.hZF = true;
            aVar.jbq = R.raw.default_avatar;
            this.gzE = aVar.bdv();
            this.Pak = BitmapUtil.transformDrawableToBitmap(context.getResources().getDrawable(R.raw.at_all_avater));
            AppMethodBeat.o(33891);
        }

        @Override // com.tencent.mm.ui.s
        public final int dWu() {
            AppMethodBeat.i(33892);
            if (BizChatAtSomeoneUI.Pah) {
                AppMethodBeat.o(33892);
                return 1;
            }
            AppMethodBeat.o(33892);
            return 0;
        }

        @Override // com.tencent.mm.ui.s
        public final boolean Ox(int i2) {
            return false;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            View view2;
            AppMethodBeat.i(33893);
            if (view == null) {
                view2 = View.inflate(this.context, R.layout.h8, null);
                bVar = new b((byte) 0);
                bVar.gAN = (MaskLayout) view2.findViewById(R.id.v7);
                bVar.gwR = (TextView) view2.findViewById(R.id.v8);
                view2.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            if (i2 != 0 || !BizChatAtSomeoneUI.Pah) {
                k kVar = (k) getItem(i2 - (BizChatAtSomeoneUI.Pah ? 1 : 0));
                bVar.gwR.setTextColor(com.tencent.mm.cb.a.m(this.context, R.color.a0b));
                q.bcV().a(kVar.field_headImageUrl, (ImageView) bVar.gAN.getContentView(), this.gzE);
                bVar.gAN.setMaskDrawable(null);
                bVar.gwR.setText(l.b(this.context, BizChatAtSomeoneUI.a(this.Pag, kVar.field_userId), bVar.gwR.getTextSize()));
                AppMethodBeat.o(33893);
                return view2;
            }
            bVar.Pal.setImageBitmap(this.Pak);
            bVar.gwR.setText(this.context.getResources().getString(R.string.a4j, "@"));
            AppMethodBeat.o(33893);
            return view2;
        }

        @Override // com.tencent.mm.ui.s
        public final void anp() {
            String str;
            AppMethodBeat.i(33894);
            ebf();
            com.tencent.mm.al.a.l bal = ag.bal();
            String[] strArr = this.Paj;
            String str2 = this.gzZ;
            List<String> list = this.gzY;
            StringBuilder sb = new StringBuilder();
            sb.append("select *  from BizChatUserInfo where ");
            StringBuilder append = sb.append(com.tencent.mm.al.a.l.a(strArr, list));
            if (str2 == null || str2.equals("")) {
                str = "";
            } else {
                str = " and (" + "userName like '%" + str2 + "%' )";
            }
            append.append(str);
            StringBuilder append2 = sb.append(" order by ");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" case when length(BizChatUserInfo.userNamePY) > 0 then upper(BizChatUserInfo.userNamePY) ");
            stringBuffer.append(" else upper(BizChatUserInfo.userName) end asc, ");
            stringBuffer.append(" upper(BizChatUserInfo.userNamePY) asc, ");
            stringBuffer.append(" upper(BizChatUserInfo.userName) asc ");
            append2.append(stringBuffer.toString());
            setCursor(bal.db.rawQuery(sb.toString(), null));
            super.notifyDataSetChanged();
            AppMethodBeat.o(33894);
        }

        @Override // com.tencent.mm.ui.s
        public final void anq() {
            AppMethodBeat.i(33895);
            anp();
            AppMethodBeat.o(33895);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
        @Override // com.tencent.mm.ui.s
        public final /* synthetic */ k a(k kVar, Cursor cursor) {
            AppMethodBeat.i(33896);
            k kVar2 = new k();
            kVar2.convertFrom(cursor);
            AppMethodBeat.o(33896);
            return kVar2;
        }
    }

    protected static String a(com.tencent.mm.al.a.c cVar, String str) {
        AppMethodBeat.i(33901);
        if (cVar == null) {
            AppMethodBeat.o(33901);
            return null;
        }
        String displayName = cVar.getDisplayName(str);
        AppMethodBeat.o(33901);
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
