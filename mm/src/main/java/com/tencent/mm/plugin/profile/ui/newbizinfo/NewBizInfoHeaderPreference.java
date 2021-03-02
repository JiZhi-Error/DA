package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.profile.ui.b.a;
import com.tencent.mm.plugin.profile.ui.b.b;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class NewBizInfoHeaderPreference extends Preference implements e.a, MStorageEx.IOnStorageChange {
    private static long Bjx = 0;
    private String Bdj;
    private c Bdk;
    private a Bdl = new a(this);
    private b Bdm = new b(this);
    private ph BiU;
    View Bju;
    private FlexboxLayout Bjv;
    ConstraintLayout Bjw;
    boolean Bjy = false;
    as contact;
    private MMActivity gte;
    ImageView gyr;
    private ImageView hXw;
    private MMNeat7extView pIP;
    private boolean rFe;
    private TextView titleTv;

    public NewBizInfoHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27510);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(27510);
    }

    public NewBizInfoHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27511);
        this.gte = (MMActivity) context;
        this.rFe = false;
        AppMethodBeat.o(27511);
    }

    public static void HN(long j2) {
        Bjx = j2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(27512);
        this.gyr = (ImageView) view.findViewById(R.id.a_c);
        this.titleTv = (TextView) view.findViewById(R.id.a_g);
        this.pIP = (MMNeat7extView) view.findViewById(R.id.a_d);
        this.Bjv = (FlexboxLayout) view.findViewById(R.id.a_e);
        this.Bjw = (ConstraintLayout) view.findViewById(R.id.a_f);
        this.hXw = (ImageView) view.findViewById(R.id.e49);
        this.rFe = true;
        initView();
        super.onBindView(view);
        this.Bju = view;
        AppMethodBeat.o(27512);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initView() {
        boolean z = true;
        AppMethodBeat.i(27513);
        if (!this.rFe || this.contact == null) {
            Log.w("MicroMsg.NewBizInfoHeaderPreference", "initView contact is null, return");
            AppMethodBeat.o(27513);
            return;
        }
        boolean z2 = ab.clc() && com.tencent.mm.contact.c.oR(this.contact.field_type) && this.contact.arE() && g.Nd(this.contact.field_username);
        boolean gBN = this.contact.gBN();
        String nullAsNil = z2 ? Util.nullAsNil(this.contact.field_nickname) + "*" : Util.nullAsNil(this.contact.field_nickname);
        if (gBN) {
            nullAsNil = nullAsNil + "*";
        }
        SpannableString b2 = l.b(this.gte, nullAsNil, this.titleTv.getTextSize());
        int length = b2.length() - 1;
        if (gBN) {
            if (z2) {
                length--;
            }
            Drawable drawable = this.gte.getResources().getDrawable(R.drawable.c_q);
            int i2 = (int) ((this.gte.getResources().getDisplayMetrics().density * 6.0f) + 0.5f);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 18);
            drawable.setBounds(i2, 0, fromDPToPix + i2, fromDPToPix);
            b2.setSpan(new ImageSpan(drawable, 1), length, length + 1, 17);
        }
        if (z2) {
            Drawable drawable2 = this.gte.getResources().getDrawable(R.drawable.c0a);
            int i3 = (int) ((this.gte.getResources().getDisplayMetrics().density * 6.0f) + 0.5f);
            drawable2.setBounds(i3, 0, drawable2.getIntrinsicWidth() + i3, drawable2.getIntrinsicHeight());
            b2.setSpan(new ImageSpan(drawable2, 1), b2.length() - 1, b2.length(), 17);
        }
        this.titleTv.setText(b2);
        if (this.Bdk == null) {
            this.Bdk = g.fJ(this.contact.field_username);
        }
        if (this.Bdk != null) {
            this.Bdj = this.Bdk.field_brandIconURL;
        }
        this.gyr.setVisibility(0);
        boolean z3 = System.currentTimeMillis() - Bjx < 2000;
        ImageView imageView = this.gyr;
        as asVar = this.contact;
        String str = this.Bjy ? "" : this.Bdj;
        if (this.Bjy || !z3) {
            z = false;
        }
        d.a(imageView, asVar, str, z);
        if (this.Bjy) {
            this.gyr.setClickable(false);
        } else {
            this.gyr.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27504);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    String str = NewBizInfoHeaderPreference.this.contact.field_username;
                    Intent intent = new Intent(NewBizInfoHeaderPreference.this.gte, ProfileHdHeadImg.class);
                    intent.putExtra(ch.COL_USERNAME, str);
                    intent.putExtra("brand_icon_url", NewBizInfoHeaderPreference.this.Bdj);
                    MMActivity mMActivity = NewBizInfoHeaderPreference.this.gte;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    mMActivity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27504);
                }
            });
        }
        String str2 = this.contact.signature;
        if (Util.nullAsNil(str2).trim().length() <= 0) {
            str2 = this.gte.getString(R.string.b_f);
        }
        this.pIP.aw(l.c(this.gte, str2));
        this.pIP.setVisibility(0);
        if (this.Bdk == null || this.Bdk.cG(false) == null || this.Bdk.cG(false).Vb() == null || Util.isNullOrNil(this.Bdk.cG(false).Vb().diD)) {
            Log.i("MicroMsg.NewBizInfoHeaderPreference", "bizInfo aboutBizUrl is null, arrow setVisibility GONE");
            this.hXw.setVisibility(8);
        }
        this.pIP.setOnTouchListener(new h(this.pIP, new o()) {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference.AnonymousClass2 */

            @Override // com.tencent.neattextview.textview.view.b, com.tencent.mm.pluginsdk.ui.span.h
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // com.tencent.neattextview.textview.view.b, com.tencent.mm.pluginsdk.ui.span.h
            @SuppressLint({"ResourceType"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(27505);
                NewBizInfoHeaderPreference.a(NewBizInfoHeaderPreference.this, motionEvent);
                boolean onTouch = super.onTouch(view, motionEvent);
                AppMethodBeat.o(27505);
                return onTouch;
            }
        });
        this.hXw.setImageDrawable(ar.m(this.mContext, R.raw.biz_profile_jump_arrow_normal, this.gte.getResources().getColor(R.color.BW_0_Alpha_0_5)));
        this.hXw.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference.AnonymousClass3 */

            @SuppressLint({"ResourceType"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(27506);
                NewBizInfoHeaderPreference.a(NewBizInfoHeaderPreference.this, motionEvent);
                AppMethodBeat.o(27506);
                return false;
            }
        });
        this.pIP.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(27507);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27507);
            }
        });
        this.hXw.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(27508);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                NewBizInfoHeaderPreference.d(NewBizInfoHeaderPreference.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoHeaderPreference$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27508);
            }
        });
        if (this.BiU.KWf != null) {
            String str3 = this.BiU.KWf.KTb;
            String str4 = this.BiU.KWf.KTc;
            this.Bjv.removeAllViews();
            if (!Util.isNullOrNil(str3)) {
                TextView textView = (TextView) this.gte.getLayoutInflater().inflate(R.layout.xe, (ViewGroup) this.Bjv, false);
                textView.setText(str3);
                this.Bjv.addView(textView);
            }
            if (!Util.isNullOrNil(str4)) {
                TextView textView2 = (TextView) this.gte.getLayoutInflater().inflate(R.layout.xe, (ViewGroup) this.Bjv, false);
                textView2.setText(str4);
                this.Bjv.addView(textView2);
            }
        }
        this.Bjw.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoHeaderPreference.AnonymousClass6 */

            public final boolean onPreDraw() {
                AppMethodBeat.i(27509);
                NewBizInfoHeaderPreference.this.Bjw.getViewTreeObserver().removeOnPreDrawListener(this);
                int[] iArr = new int[2];
                NewBizInfoHeaderPreference.this.Bjw.getLocationOnScreen(iArr);
                int i2 = iArr[1];
                int aH = com.tencent.mm.cb.a.aH(NewBizInfoHeaderPreference.this.mContext, R.dimen.agx);
                int statusBarHeight = au.getStatusBarHeight(NewBizInfoHeaderPreference.this.mContext);
                int eu = au.eu(NewBizInfoHeaderPreference.this.mContext);
                Log.i("MicroMsg.NewBizInfoHeaderPreference", "actionBarHeight=%s ,statusBarHeight=%s , rootTop:%s", Integer.valueOf(eu), Integer.valueOf(statusBarHeight), Integer.valueOf(i2));
                if (statusBarHeight > 0 && eu > 0) {
                    aH = com.tencent.mm.cb.a.aH(NewBizInfoHeaderPreference.this.mContext, R.dimen.cb) + eu;
                }
                if (i2 == 0) {
                    aH += statusBarHeight;
                }
                if (aH != NewBizInfoHeaderPreference.this.Bjw.getPaddingTop()) {
                    NewBizInfoHeaderPreference.this.Bjw.setPadding(NewBizInfoHeaderPreference.this.Bjw.getPaddingLeft(), aH, NewBizInfoHeaderPreference.this.Bjw.getPaddingRight(), NewBizInfoHeaderPreference.this.Bjw.getPaddingBottom());
                    AppMethodBeat.o(27509);
                    return false;
                }
                AppMethodBeat.o(27509);
                return true;
            }
        });
        AppMethodBeat.o(27513);
    }

    public final void a(as asVar, String str, c cVar, ph phVar) {
        AppMethodBeat.i(27514);
        onDetach();
        this.Bdj = str;
        this.Bdk = cVar;
        this.contact = asVar;
        this.BiU = phVar;
        bg.aVF();
        com.tencent.mm.model.c.aSN().add(this.Bdm);
        p.aYn().d(this.Bdl);
        initView();
        AppMethodBeat.o(27514);
    }

    public final void onDetach() {
        AppMethodBeat.i(27515);
        bg.aVF();
        com.tencent.mm.model.c.aSN().remove(this.Bdm);
        p.aYn().e(this.Bdl);
        AppMethodBeat.o(27515);
    }

    @Override // com.tencent.mm.aj.e.a
    public final void Mr(String str) {
        AppMethodBeat.i(27516);
        Log.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged user:%s", str);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.NewBizInfoHeaderPreference", "notifyChanged err, user is null");
            AppMethodBeat.o(27516);
            return;
        }
        if (this.contact != null && str.equals(this.contact.field_username)) {
            initView();
        }
        AppMethodBeat.o(27516);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(27517);
        if (obj == null || !(obj instanceof String)) {
            Log.d("MicroMsg.NewBizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(27517);
            return;
        }
        String str = (String) obj;
        if (Util.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(27517);
            return;
        }
        if (this.contact != null && this.contact.field_username.equals(str)) {
            bg.aVF();
            this.contact = com.tencent.mm.model.c.aSN().Kn(str);
        }
        AppMethodBeat.o(27517);
    }

    static /* synthetic */ void a(NewBizInfoHeaderPreference newBizInfoHeaderPreference, MotionEvent motionEvent) {
        AppMethodBeat.i(27518);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            newBizInfoHeaderPreference.pIP.setTextColor(newBizInfoHeaderPreference.gte.getResources().getColor(R.color.BW_0_Alpha_0_9));
            newBizInfoHeaderPreference.hXw.setImageDrawable(ar.e(newBizInfoHeaderPreference.gte.getDrawable(R.raw.biz_profile_jump_arrow_normal), newBizInfoHeaderPreference.gte.getResources().getColor(R.color.BW_0_Alpha_0_5)));
            AppMethodBeat.o(27518);
            return;
        }
        if (motionEvent.getAction() == 0) {
            newBizInfoHeaderPreference.pIP.setTextColor(newBizInfoHeaderPreference.gte.getResources().getColor(R.color.BW_0_Alpha_0_5));
            newBizInfoHeaderPreference.hXw.setImageDrawable(ar.m(newBizInfoHeaderPreference.mContext, R.raw.biz_profile_jump_arrow_pressed, newBizInfoHeaderPreference.gte.getResources().getColor(R.color.BW_0_Alpha_0_5)));
        }
        AppMethodBeat.o(27518);
    }

    static /* synthetic */ void d(NewBizInfoHeaderPreference newBizInfoHeaderPreference) {
        AppMethodBeat.i(27519);
        if (newBizInfoHeaderPreference.Bdk == null || newBizInfoHeaderPreference.Bdk.cG(false) == null || newBizInfoHeaderPreference.Bdk.cG(false).Vb() == null) {
            Log.i("MicroMsg.NewBizInfoHeaderPreference", "registerSource is null, return");
            AppMethodBeat.o(27519);
            return;
        }
        String str = newBizInfoHeaderPreference.Bdk.cG(false).Vb().diD;
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.NewBizInfoHeaderPreference", "bizInfo aboutBizUrl is null, will not jump webView");
            AppMethodBeat.o(27519);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("geta8key_scene", 3);
        intent.putExtra("customize_status_bar_color", newBizInfoHeaderPreference.gte.getResources().getColor(R.color.afl));
        com.tencent.mm.br.c.b(newBizInfoHeaderPreference.gte, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(27519);
    }
}
