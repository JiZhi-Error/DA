package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.Iterator;
import java.util.List;

public class NewBizInfoMenuPreference extends Preference {
    private LinearLayout BjB;
    private List<qa> BjC;
    private py BjD;
    private as contact;
    private long enterTime = 0;
    private MMActivity gte;
    private int kgm = 0;
    private int lineHeight = 0;
    private boolean rFe = false;
    private int state = 0;

    public NewBizInfoMenuPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27526);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(27526);
    }

    public NewBizInfoMenuPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27527);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(27527);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27528);
        super.onBindView(view);
        this.BjB = (LinearLayout) view.findViewById(R.id.bac);
        this.rFe = true;
        initView();
        AppMethodBeat.o(27528);
    }

    private void initView() {
        AppMethodBeat.i(27529);
        if (!this.rFe || this.BjB == null) {
            AppMethodBeat.o(27529);
        } else if (this.state == 1 || this.state == 2 || this.state != 3) {
            this.BjB.setVisibility(8);
            AppMethodBeat.o(27529);
        } else {
            this.BjB.setVisibility(0);
            eeh();
            AppMethodBeat.o(27529);
        }
    }

    private void eeh() {
        AppMethodBeat.i(27530);
        this.BjB.removeAllViews();
        for (int i2 = 0; i2 < this.BjC.size(); i2++) {
            final qa qaVar = this.BjC.get(i2);
            View a2 = a(qaVar);
            a2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27523);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (qaVar == null) {
                        Log.w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
                        a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(27523);
                        return;
                    }
                    c.c(NewBizInfoMenuPreference.this.contact.field_username, 1100, NewBizInfoMenuPreference.this.kgm, NewBizInfoMenuPreference.this.enterTime);
                    Log.i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", Integer.valueOf(qaVar.type));
                    switch (qaVar.type) {
                        case 0:
                            NewBizInfoMenuPreference.a(NewBizInfoMenuPreference.this, qaVar);
                            break;
                        case 2:
                            g.a(qaVar, NewBizInfoMenuPreference.this.gte, NewBizInfoMenuPreference.this.contact.field_username);
                            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.this.contact.field_username, String.valueOf(qaVar.id), qaVar.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.BlL, qaVar.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hP(NewBizInfoMenuPreference.this.BjC.indexOf(qaVar), -1), qaVar.HWM);
                            break;
                        case 5:
                            g.b(qaVar, NewBizInfoMenuPreference.this.gte, NewBizInfoMenuPreference.this.contact.field_username);
                            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.this.contact.field_username, String.valueOf(qaVar.id), qaVar.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.BlL, qaVar.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hP(NewBizInfoMenuPreference.this.BjC.indexOf(qaVar), -1), qaVar.value);
                            break;
                        case 6:
                            g.c(qaVar, NewBizInfoMenuPreference.this.gte, NewBizInfoMenuPreference.this.contact.field_username);
                            com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.this.contact.field_username, String.valueOf(qaVar.id), qaVar.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.BlL, qaVar.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hP(NewBizInfoMenuPreference.this.BjC.indexOf(qaVar), -1), qaVar.value);
                            break;
                    }
                    a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoMenuPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27523);
                }
            });
            this.BjB.addView(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -1;
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 16;
            a2.setLayoutParams(layoutParams);
            if (i2 != this.BjC.size() - 1) {
                ImageView imageView = new ImageView(this.gte);
                imageView.setBackgroundColor(this.gte.getResources().getColor(R.color.FG_3));
                this.BjB.addView(imageView);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams2.height = this.lineHeight;
                layoutParams2.width = Math.round(this.gte.getResources().getDisplayMetrics().density * 0.5f);
                layoutParams2.gravity = 16;
                imageView.setLayoutParams(layoutParams2);
            }
        }
        AppMethodBeat.o(27530);
    }

    private View a(qa qaVar) {
        AppMethodBeat.i(27531);
        View inflate = View.inflate(this.gte, R.layout.wj, null);
        TextView textView = (TextView) inflate.findViewById(R.id.fvi);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.fvh);
        this.lineHeight = (int) textView.getTextSize();
        an(imageView, (((int) textView.getTextSize()) * 3) / 4);
        switch (qaVar.type) {
            case 0:
                imageView.setVisibility(0);
                imageView.setImageDrawable(ar.m(this.gte, R.raw.biz_menu_show_sub_menu_icon, this.gte.getResources().getColor(R.color.FG_2)));
                break;
            case 2:
            case 6:
                imageView.setVisibility(8);
                break;
            case 5:
                imageView.setVisibility(0);
                imageView.setImageResource(ao.isDarkMode() ? R.drawable.bzm : R.drawable.bzl);
                break;
        }
        textView.setText(l.c(this.gte, qaVar.name));
        o.hq(inflate);
        AppMethodBeat.o(27531);
        return inflate;
    }

    private static void an(View view, int i2) {
        AppMethodBeat.i(27532);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i2;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(27532);
    }

    public final void a(py pyVar, as asVar, int i2, long j2) {
        AppMethodBeat.i(231955);
        if (pyVar == null || pyVar.KWP == null) {
            AppMethodBeat.o(231955);
            return;
        }
        this.contact = asVar;
        this.BjD = pyVar;
        this.BjC = a.a(pyVar.KWP);
        this.kgm = i2;
        this.enterTime = j2;
        dmp();
        initView();
        AppMethodBeat.o(231955);
    }

    private void dmp() {
        AppMethodBeat.i(27534);
        if (this.BjD == null || this.BjD.KQV == null) {
            if (this.BjD == null) {
                this.state = 0;
            } else if (this.BjD != null && this.BjC != null && this.BjC.size() <= 0) {
                this.state = 2;
                AppMethodBeat.o(27534);
                return;
            } else if (!(this.BjD == null || this.BjC == null || this.BjC.size() <= 0)) {
                this.state = 3;
                AppMethodBeat.o(27534);
                return;
            }
            AppMethodBeat.o(27534);
            return;
        }
        this.state = 4;
        AppMethodBeat.o(27534);
    }

    static /* synthetic */ void a(NewBizInfoMenuPreference newBizInfoMenuPreference, final qa qaVar) {
        AppMethodBeat.i(231956);
        e eVar = new e((Context) newBizInfoMenuPreference.gte, 1, true);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(27524);
                Iterator<qa> it = qaVar.KWT.iterator();
                while (it.hasNext()) {
                    qa next = it.next();
                    if (next.type == 5) {
                        Drawable drawable = NewBizInfoMenuPreference.this.gte.getResources().getDrawable(ao.isDarkMode() ? R.drawable.bzm : R.drawable.bzl);
                        int i2 = (NewBizInfoMenuPreference.this.lineHeight * 16) / 17;
                        drawable.setBounds(0, 0, i2, i2);
                        com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
                        SpannableString spannableString = new SpannableString("@");
                        spannableString.setSpan(aVar, 0, 1, 33);
                        mVar.d(next.name.hashCode(), TextUtils.concat(next.name, "  ", spannableString));
                    } else {
                        mVar.d(next.name.hashCode(), next.name);
                    }
                }
                AppMethodBeat.o(27524);
            }
        };
        eVar.j(l.c(newBizInfoMenuPreference.gte, qaVar.name), 1, com.tencent.mm.cb.a.fromDPToPix((Context) newBizInfoMenuPreference.gte, 12));
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(27525);
                qa qaVar = qaVar.KWT.get(i2);
                if (qaVar.type == 2) {
                    g.a(qaVar, NewBizInfoMenuPreference.this.gte, NewBizInfoMenuPreference.this.contact.field_username);
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.this.contact.field_username, String.valueOf(qaVar.id), qaVar.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.BlL, qaVar.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hP(NewBizInfoMenuPreference.this.BjC.indexOf(qaVar), i2), qaVar.HWM);
                    AppMethodBeat.o(27525);
                } else if (qaVar.type == 5) {
                    g.b(qaVar, NewBizInfoMenuPreference.this.gte, NewBizInfoMenuPreference.this.contact.field_username);
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.this.contact.field_username, String.valueOf(qaVar.id), qaVar.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.BlL, qaVar.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hP(NewBizInfoMenuPreference.this.BjC.indexOf(qaVar), i2), qaVar.value);
                    AppMethodBeat.o(27525);
                } else {
                    if (qaVar.type == 6) {
                        g.c(qaVar, NewBizInfoMenuPreference.this.gte, NewBizInfoMenuPreference.this.contact.field_username);
                        com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.b(NewBizInfoMenuPreference.this.contact.field_username, String.valueOf(qaVar.id), qaVar.key, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.BlL, qaVar.name, com.tencent.mm.plugin.profile.ui.newbizinfo.c.b.hP(NewBizInfoMenuPreference.this.BjC.indexOf(qaVar), i2), qaVar.value);
                    }
                    AppMethodBeat.o(27525);
                }
            }
        };
        eVar.dGm();
        AppMethodBeat.o(231956);
    }
}
