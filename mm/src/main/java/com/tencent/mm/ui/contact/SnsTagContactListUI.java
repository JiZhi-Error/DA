package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.MenuItem;
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
import com.tencent.mm.contact.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class SnsTagContactListUI extends MMActivity {
    private a PZS;
    private List<Long> PZT = new ArrayList();
    private ListView yCT;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsTagContactListUI() {
        AppMethodBeat.i(38084);
        AppMethodBeat.o(38084);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(38085);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(38085);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(38086);
        setMMTitle(R.string.hav);
        findViewById(R.id.epv).setVisibility(8);
        this.yCT = (ListView) findViewById(R.id.h4);
        long[] longArrayExtra = getIntent().getLongArrayExtra("sns_tag_list");
        if (longArrayExtra == null) {
            finish();
            AppMethodBeat.o(38086);
            return;
        }
        for (long j2 : longArrayExtra) {
            this.PZT.add(Long.valueOf(j2));
        }
        ((TextView) findViewById(R.id.c2l)).setVisibility(8);
        findViewById(R.id.hl).setVisibility(8);
        this.yCT.setBackgroundColor(getResources().getColor(R.color.afz));
        ((View) this.yCT.getParent()).setBackgroundColor(getResources().getColor(R.color.afz));
        this.PZS = new a(this, this.PZT);
        this.yCT.setAdapter((ListAdapter) this.PZS);
        this.yCT.setVisibility(0);
        this.yCT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.contact.SnsTagContactListUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(38077);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Intent intent = new Intent();
                c cVar = (c) SnsTagContactListUI.this.PZS.getItem(i2);
                i iVar = o.DCR;
                if (iVar == null) {
                    SnsTagContactListUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(38077);
                    return;
                }
                Intent g2 = iVar.g(intent, cVar.field_username);
                if (g2 == null) {
                    SnsTagContactListUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(38077);
                    return;
                }
                g2.putExtra("sns_adapter_type", 1);
                com.tencent.mm.br.c.b(SnsTagContactListUI.this.getContext(), "sns", ".ui.SnsTimeLineUserPagerUI", g2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(38077);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.SnsTagContactListUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(38078);
                SnsTagContactListUI.this.finish();
                AppMethodBeat.o(38078);
                return true;
            }
        });
        showOptionMenu(false);
        AppMethodBeat.o(38086);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(38087);
        super.onResume();
        if (this.PZS != null) {
            this.PZS.notifyDataSetChanged();
        }
        AppMethodBeat.o(38087);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(38088);
        super.onDestroy();
        AppMethodBeat.o(38088);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cf;
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        private bv EBg = null;
        private ColorStateList Fxn;
        private ColorStateList Fxo;
        private Map<Integer, c> PZQ = new HashMap();
        private Map<Integer, String> PZV = new HashMap();
        private Context context = null;

        public a(Context context2, List<Long> list) {
            AppMethodBeat.i(38079);
            this.context = context2;
            this.PZQ.clear();
            this.PZV.clear();
            bg.aVF();
            this.EBg = com.tencent.mm.model.c.aSN();
            int i2 = 0;
            for (Long l : list) {
                long longValue = l.longValue();
                l lVar = o.DCP;
                if (lVar != null) {
                    for (String str : lVar.IZ(longValue)) {
                        c cVar = new c();
                        cVar.setUsername(str);
                        this.PZV.put(Integer.valueOf(this.PZQ.size()), lVar.Ja(longValue));
                        this.PZQ.put(Integer.valueOf(i2), cVar);
                        i2++;
                    }
                }
                i2 = i2;
            }
            try {
                XmlResourceParser xml = context2.getResources().getXml(R.color.a0b);
                XmlResourceParser xml2 = context2.getResources().getXml(R.color.a0c);
                this.Fxn = ColorStateList.createFromXml(context2.getResources(), xml);
                this.Fxo = ColorStateList.createFromXml(context2.getResources(), xml2);
                AppMethodBeat.o(38079);
            } catch (XmlPullParserException e2) {
                Log.printErrStackTrace("MicroMsg.SnsTagContactList", e2, "", new Object[0]);
                AppMethodBeat.o(38079);
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.SnsTagContactList", e3, "", new Object[0]);
                AppMethodBeat.o(38079);
            }
        }

        public final int getCount() {
            AppMethodBeat.i(38080);
            int size = this.PZQ.size();
            AppMethodBeat.o(38080);
            return size;
        }

        public final Object getItem(int i2) {
            as Kn;
            AppMethodBeat.i(38081);
            if (i2 < 0) {
                AppMethodBeat.o(38081);
                return null;
            }
            c cVar = this.PZQ.get(Integer.valueOf(i2));
            if (cVar.field_showHead == 0 && (Kn = this.EBg.Kn(cVar.field_username)) != null) {
                this.PZQ.put(Integer.valueOf(i2), Kn);
                cVar = Kn;
            }
            AppMethodBeat.o(38081);
            return cVar;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(38082);
            if (view == null) {
                view = View.inflate(this.context, R.layout.xw, null);
                b bVar2 = new b((byte) 0);
                bVar2.yuS = (TextView) view.findViewById(R.id.bdr);
                bVar2.gAN = (MaskLayout) view.findViewById(R.id.bdo);
                bVar2.gwR = (TextView) view.findViewById(R.id.bdw);
                bVar2.Fxp = (TextView) view.findViewById(R.id.bdm);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            String anL = ((c) getItem(i2 + -1)) == null ? "" : anL(i2 - 1);
            c cVar = (c) getItem(i2);
            if (i2 == 0) {
                bVar.yuS.setVisibility(0);
                bVar.yuS.setText(anL(i2));
                bVar.yuS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else if (i2 <= 0 || anL(i2).equals(anL)) {
                bVar.yuS.setVisibility(8);
            } else {
                bVar.yuS.setVisibility(0);
                bVar.yuS.setText(anL(i2));
                bVar.yuS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            bVar.gwR.setTextColor(!ab.JE(cVar.field_username) ? this.Fxn : this.Fxo);
            a.b.A((ImageView) bVar.gAN.getContentView(), cVar.field_username);
            bVar.Fxp.setVisibility(8);
            bVar.gAN.setVisibility(0);
            bVar.gwR.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, cVar.arJ(), bVar.gwR.getTextSize()));
            bVar.gwR.setVisibility(0);
            AppMethodBeat.o(38082);
            return view;
        }

        private String anL(int i2) {
            AppMethodBeat.i(38083);
            if (!this.PZV.containsKey(Integer.valueOf(i2))) {
                AppMethodBeat.o(38083);
                return "";
            }
            String str = this.PZV.get(Integer.valueOf(i2));
            AppMethodBeat.o(38083);
            return str;
        }
    }

    static class b {
        TextView Fxp;
        MaskLayout gAN;
        TextView gwR;
        TextView yuS;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }
}
