package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SnsChatRoomMemberUI extends MMActivity {
    private static int gzT = 5;
    private GridView EAK = null;
    private b EAL = null;
    private List<a> dSU = new ArrayList();
    private l gAd;
    private ah gtd;
    private String gwx;
    private String gxP;
    private int gxQ;
    private String gxR;
    private boolean gxS;
    private String mTitle;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsChatRoomMemberUI() {
        AppMethodBeat.i(98527);
        AppMethodBeat.o(98527);
    }

    private static int cq(Context context) {
        AppMethodBeat.i(98528);
        int width = (int) ((((float) ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth()) - (context.getResources().getDimension(R.dimen.i1) * 1.0f)) / ((float) ((int) ((context.getResources().getDimension(R.dimen.ib) * 2.0f) + context.getResources().getDimension(R.dimen.ij)))));
        Log.i("MicroMsg.SnsChatRoomMemberUI", "[getWrapColNum] :%s", Integer.valueOf(width));
        gzT = width;
        AppMethodBeat.o(98528);
        return width;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(98529);
        super.onCreate(bundle);
        this.gAd = (l) g.af(l.class);
        this.gwx = getIntent().getStringExtra("RoomInfo_Id");
        this.gxP = getIntent().getStringExtra("room_name");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        this.gxQ = getIntent().getIntExtra("room_member_count", 0);
        this.gtd = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.gwx);
        if (this.gtd != null) {
            this.gxR = this.gtd.field_roomowner;
            this.gxS = z.aTY().equals(this.gxR);
        }
        this.EAK = (GridView) findViewById(R.id.hx4);
        this.EAK.setNumColumns(cq(this));
        this.EAK.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.i1));
        this.EAK.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(98521);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (SnsChatRoomMemberUI.this.EAL.ZG(i2).type == 1) {
                    as asVar = SnsChatRoomMemberUI.this.EAL.ZG(i2).contact;
                    if (asVar == null) {
                        Log.e("MicroMsg.SnsChatRoomMemberUI", "cont is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(98521);
                        return;
                    }
                    String str = asVar.field_username;
                    String str2 = asVar.field_nickname;
                    String c2 = SnsChatRoomMemberUI.c(SnsChatRoomMemberUI.this.gtd, str);
                    if (Util.isNullOrNil(c2)) {
                        c2 = asVar.arJ();
                    }
                    SnsChatRoomMemberUI.a(SnsChatRoomMemberUI.this, str, c2, str2);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsChatRoomMemberUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(98521);
            }
        });
        this.EAL = new b(this, this.gtd, this.gwx, this.gxR);
        this.EAK.setAdapter((ListAdapter) this.EAL);
        List<String> Ic = v.Ic(this.gwx);
        if (Ic != null) {
            this.dSU.clear();
            for (int i2 = 0; i2 < Ic.size(); i2++) {
                as Kn = this.gAd.aSN().Kn(Ic.get(i2));
                if (Kn != null && com.tencent.mm.contact.c.oR(Kn.field_type) && !z.Im(Kn.field_username)) {
                    if (this.gtd.JO(Kn.field_username)) {
                        this.dSU.add(new a(Kn, 3));
                    } else if (this.gtd.bjf(Kn.field_username)) {
                        this.dSU.add(new a(Kn, 2));
                    } else {
                        this.dSU.add(new a(Kn, 1));
                    }
                }
            }
            Collections.sort(this.dSU, new Comparator<a>() {
                /* class com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
                    return aVar2.order - aVar.order;
                }
            });
            this.EAL.notifyDataSetChanged();
        }
        setMMTitle(this.mTitle + "(" + this.dSU.size() + ")");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsChatRoomMemberUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(98522);
                SnsChatRoomMemberUI.this.setResult(0);
                SnsChatRoomMemberUI.this.finish();
                AppMethodBeat.o(98522);
                return true;
            }
        });
        AppMethodBeat.o(98529);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(98530);
        super.onConfigurationChanged(configuration);
        this.EAK.setNumColumns(cq(this));
        AppMethodBeat.o(98530);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bve;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        as contact;
        int order = 0;
        int type = 1;

        public a(as asVar, int i2) {
            this.contact = asVar;
            this.order = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends BaseAdapter {
        private boolean gAa = false;
        private String gAb = null;
        private ah gtd;
        private List<String> gzY;
        private Context mContext;
        private String roomId;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(98526);
            a ZG = ZG(i2);
            AppMethodBeat.o(98526);
            return ZG;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.List<java.lang.String> */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Context context, ah ahVar, String str, List<String> list) {
            this.gtd = ahVar;
            this.roomId = str;
            this.gzY = null;
            this.gAb = list;
            this.mContext = context;
        }

        public final a ZG(int i2) {
            AppMethodBeat.i(98523);
            a aVar = (a) SnsChatRoomMemberUI.this.dSU.get(i2);
            AppMethodBeat.o(98523);
            return aVar;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            c cVar;
            String str;
            AppMethodBeat.i(98524);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.bvd, null);
                cVar = new c((byte) 0);
                cVar.gvv = (ImageView) view.findViewById(R.id.hgi);
                cVar.gwR = (TextView) view.findViewById(R.id.hgk);
                cVar.gwR.setMaxWidth((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() * 2) / 3);
                cVar.gAg = (TextView) view.findViewById(R.id.hgl);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            if (cVar.gAg != null) {
                cVar.gAg.setVisibility(8);
            }
            a aVar = (a) SnsChatRoomMemberUI.this.dSU.get(i2);
            if (aVar != null && aVar.type == 1) {
                as asVar = aVar.contact;
                a.b.c(cVar.gvv, asVar.field_username);
                String c2 = SnsChatRoomMemberUI.c(this.gtd, asVar.field_username);
                if (!Util.isNullOrNil(asVar.field_conRemark)) {
                    str = asVar.field_conRemark;
                } else {
                    str = c2;
                }
                if (Util.isNullOrNil(str)) {
                    str = asVar.arI();
                }
                if (c2 != null && !c2.equals("") && !str.equals(c2)) {
                    str = c2 + "( " + str + " )";
                }
                cVar.gwR.setVisibility(0);
                cVar.gwR.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, str, cVar.gwR.getTextSize()));
                if (cVar.gAg != null) {
                    String O = com.tencent.mm.openim.room.a.a.O(asVar);
                    if (TextUtils.isEmpty(O)) {
                        cVar.gAg.setVisibility(8);
                    } else {
                        cVar.gAg.setVisibility(0);
                        cVar.gAg.setText(O);
                    }
                }
            }
            AppMethodBeat.o(98524);
            return view;
        }

        public final int getCount() {
            AppMethodBeat.i(98525);
            int size = SnsChatRoomMemberUI.this.dSU.size();
            AppMethodBeat.o(98525);
            return size;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }
    }

    static class c {
        public TextView gAg;
        public ImageView gvv;
        public TextView gwR;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    static /* synthetic */ String c(ah ahVar, String str) {
        AppMethodBeat.i(98531);
        if (ahVar == null) {
            AppMethodBeat.o(98531);
            return "";
        }
        String displayName = ahVar.getDisplayName(str);
        AppMethodBeat.o(98531);
        return displayName;
    }

    static /* synthetic */ void a(SnsChatRoomMemberUI snsChatRoomMemberUI, String str, String str2, String str3) {
        cn aEZ;
        AppMethodBeat.i(98532);
        if (Util.isNullOrNil(str2) && (aEZ = ((l) g.af(l.class)).aSO().aEZ(str)) != null && !Util.isNullOrNil(aEZ.field_encryptUsername)) {
            str2 = aEZ.field_conRemark;
        }
        if (!Util.isNullOrNil(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (snsChatRoomMemberUI.gtd != null) {
                intent.putExtra("Contact_RoomNickname", snsChatRoomMemberUI.gtd.getDisplayName(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", snsChatRoomMemberUI.gxP);
            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
            if (Kn != null && ((int) Kn.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn.field_type)) {
                uj ujVar = new uj();
                ujVar.eaI.intent = intent;
                ujVar.eaI.username = str;
                EventCenter.instance.publish(ujVar);
            }
            if (Kn != null && Kn.gBM()) {
                h.INSTANCE.kvStat(10298, Kn.field_username + ",14");
            }
            intent.putExtra("Contact_Scene", 14);
            intent.putExtra("Is_RoomOwner", snsChatRoomMemberUI.gxS);
            intent.putExtra("Contact_ChatRoomId", snsChatRoomMemberUI.gwx);
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 10);
            com.tencent.mm.br.c.b(snsChatRoomMemberUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(98532);
    }
}
