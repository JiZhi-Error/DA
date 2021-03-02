package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog extends MMBaseActivity {
    private GridView EHJ = null;
    private a EHK = null;
    private List<String> iHf = new LinkedList();

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsSelectContactDialog() {
        AppMethodBeat.i(99009);
        AppMethodBeat.o(99009);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(99010);
        super.onCreate(bundle);
        setContentView(R.layout.bvf);
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (stringExtra == null || stringExtra.equals("")) {
            this.iHf.clear();
        } else {
            this.iHf = Util.stringsToList(stringExtra.split(","));
        }
        this.EHJ = (GridView) findViewById(R.id.beq);
        this.EHK = new a(this, this.iHf);
        this.EHJ.setAdapter((ListAdapter) this.EHK);
        this.EHJ.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(99003);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (i2 == SnsSelectContactDialog.this.EHK.getCount() - 1) {
                    SnsSelectContactDialog.b(SnsSelectContactDialog.this);
                } else {
                    SnsSelectContactDialog.this.iHf.remove(i2);
                }
                SnsSelectContactDialog.this.EHK.refresh();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(99003);
            }
        });
        this.EHJ.setSelection(this.EHK.getCount() - 1);
        ((ImageButton) findViewById(R.id.b46)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(99004);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", Util.listToString(SnsSelectContactDialog.this.iHf, ","));
                SnsSelectContactDialog.this.setResult(-1, intent);
                SnsSelectContactDialog.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSelectContactDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99004);
            }
        });
        AppMethodBeat.o(99010);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(99011);
        if (keyEvent.getKeyCode() == 4) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", Util.listToString(this.iHf, ","));
            setResult(-1, intent);
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(99011);
        return onKeyDown;
    }

    private boolean aRc(String str) {
        AppMethodBeat.i(99012);
        for (String str2 : ab.iCO) {
            if (str.equals(str2)) {
                AppMethodBeat.o(99012);
                return false;
            }
        }
        if (ab.Eq(str)) {
            AppMethodBeat.o(99012);
            return false;
        } else if (ab.IT(str)) {
            AppMethodBeat.o(99012);
            return false;
        } else if (this.iHf == null || !this.iHf.contains(str)) {
            AppMethodBeat.o(99012);
            return true;
        } else {
            AppMethodBeat.o(99012);
            return false;
        }
    }

    private String fiC() {
        AppMethodBeat.i(99013);
        bw aST = ((l) g.af(l.class)).aST();
        String str = ab.iCF;
        LinkedList linkedList = new LinkedList();
        for (String str2 : ab.iCO) {
            linkedList.add(str2);
        }
        linkedList.add("weixin");
        linkedList.add("officialaccounts");
        linkedList.add("helper_entry");
        linkedList.add("filehelper");
        Cursor c2 = aST.c(str, linkedList, "*");
        if (c2.getCount() == 0) {
            c2.close();
            AppMethodBeat.o(99013);
            return "";
        }
        LinkedList linkedList2 = new LinkedList();
        c2.moveToFirst();
        do {
            az azVar = new az();
            azVar.convertFrom(c2);
            if (aRc(azVar.field_username)) {
                linkedList2.add(azVar.field_username);
                if (linkedList2.size() >= 10) {
                    break;
                }
            }
        } while (c2.moveToNext());
        c2.close();
        String listToString = Util.listToString(linkedList2, ";");
        AppMethodBeat.o(99013);
        return listToString;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(99014);
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            AppMethodBeat.o(99014);
            return;
        }
        switch (i2) {
            case 1:
                if (intent != null) {
                    ArrayList<String> stringsToList = Util.stringsToList(intent.getStringExtra("Select_Contact").split(","));
                    if (stringsToList != null) {
                        if (this.iHf == null) {
                            this.iHf = new LinkedList();
                        }
                        for (String str : stringsToList) {
                            if (!this.iHf.contains(str)) {
                                this.iHf.add(str);
                            }
                        }
                        Log.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.iHf.size());
                        if (this.EHK != null) {
                            Log.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
                            this.EHK.refresh();
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra("Select_Contact", Util.listToString(this.iHf, ","));
                        setResult(-1, intent2);
                        finish();
                        break;
                    } else {
                        AppMethodBeat.o(99014);
                        return;
                    }
                } else {
                    AppMethodBeat.o(99014);
                    return;
                }
        }
        AppMethodBeat.o(99014);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private int Eny = 0;
        private Context context;
        private List<String> iHf;
        private int type;

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Context context2, int i2) {
            AppMethodBeat.i(99005);
            this.iHf = i2;
            this.context = context2;
            this.type = 0;
            refresh();
            AppMethodBeat.o(99005);
        }

        public final void refresh() {
            AppMethodBeat.i(99006);
            if (this.iHf == null) {
                this.Eny = 0;
            } else {
                this.Eny = this.iHf.size();
            }
            this.Eny++;
            notifyDataSetChanged();
            AppMethodBeat.o(99006);
        }

        public final int getCount() {
            return this.Eny;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(99007);
            String str = this.iHf.get(i2);
            AppMethodBeat.o(99007);
            return str;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            View view2;
            AppMethodBeat.i(99008);
            if (view == null) {
                bVar = new b();
                if (this.type == 0) {
                    view2 = View.inflate(this.context, R.layout.bxz, null);
                } else {
                    view2 = View.inflate(this.context, R.layout.bv8, null);
                }
                bVar.image = (ImageView) view2.findViewById(R.id.dup);
                bVar.EHM = (ImageView) view2.findViewById(R.id.e27);
                view2.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            view2.setVisibility(0);
            if (i2 == this.Eny - 1) {
                bVar.image.setBackgroundDrawable(null);
                bVar.image.setImageResource(R.drawable.aut);
                bVar.EHM.setVisibility(8);
                if (this.iHf.size() >= aq.NSd) {
                    view2.setVisibility(8);
                }
            } else {
                bVar.image.setBackgroundDrawable(null);
                bVar.EHM.setVisibility(0);
                if (this.type == 0) {
                    a.b.c(bVar.image, this.iHf.get(i2));
                } else {
                    bVar.image.setImageBitmap(BitmapUtil.extractThumbNail(this.iHf.get(i2), aj.fbb(), aj.fbb(), true));
                }
            }
            bVar.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            AppMethodBeat.o(99008);
            return view2;
        }
    }

    static class b {
        ImageView EHM;
        ImageView image;

        b() {
        }
    }

    static /* synthetic */ void b(SnsSelectContactDialog snsSelectContactDialog) {
        AppMethodBeat.i(99015);
        Intent intent = new Intent();
        intent.putExtra("Contact_Compose", true);
        intent.putExtra("Add_get_from_sns", snsSelectContactDialog.fiC());
        intent.putExtra("List_Type", 1);
        intent.putExtra("Add_address_titile", snsSelectContactDialog.getString(R.string.g4));
        intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
        intent.putExtra("Block_list", Util.listToString(snsSelectContactDialog.iHf, ",") + ", " + z.aTY());
        intent.putExtra("sns_address_count", snsSelectContactDialog.iHf.size());
        com.tencent.mm.plugin.sns.c.a.jRt.a(intent, snsSelectContactDialog, 1);
        AppMethodBeat.o(99015);
    }
}
