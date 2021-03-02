package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class BizBindWxaInfoPreference extends Preference {
    private static DisplayMetrics ogw = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    private static int olJ = a.fromDPToPix(MMApplicationContext.getContext(), 15);
    private static int olK = MMApplicationContext.getResources().getDimensionPixelSize(R.dimen.ip);
    private volatile boolean BcX;
    private volatile boolean BcY;
    private View.OnClickListener BcZ;
    private c ksU;
    private ImageView lIM;
    private TextView mPa;
    private List<WxaAttributes.WxaEntryInfo> olD;
    private View olE;
    private TextView olF;
    private LinearLayout olG;
    private ViewGroup olH;
    private View olI;
    private View.OnClickListener rID;

    static {
        AppMethodBeat.i(26925);
        AppMethodBeat.o(26925);
    }

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(26916);
        init();
        AppMethodBeat.o(26916);
    }

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(26917);
        init();
        AppMethodBeat.o(26917);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(26918);
        this.olE = view.findViewById(R.id.d59);
        this.lIM = (ImageView) view.findViewById(R.id.dtd);
        this.mPa = (TextView) view.findViewById(R.id.ipq);
        this.olF = (TextView) view.findViewById(R.id.bga);
        this.olI = view.findViewById(R.id.fjr);
        this.olG = (LinearLayout) view.findViewById(R.id.be5);
        this.olH = (ViewGroup) view.findViewById(R.id.e1w);
        this.BcX = true;
        this.BcY = this.olD != null;
        bBG();
        super.onBindView(view);
        AppMethodBeat.o(26918);
    }

    public final void a(c cVar, List<WxaAttributes.WxaEntryInfo> list) {
        AppMethodBeat.i(26919);
        this.BcY = true;
        this.ksU = cVar;
        if (this.olD == null) {
            this.olD = new LinkedList();
        } else {
            this.olD.clear();
        }
        if (list != null && !list.isEmpty()) {
            this.olD.addAll(list);
        }
        bBG();
        AppMethodBeat.o(26919);
    }

    private void init() {
        AppMethodBeat.i(26920);
        this.rID = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(26914);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof String)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(26914);
                    return;
                }
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1020;
                appBrandStatObject.dCw = BizBindWxaInfoPreference.this.ksU.field_username;
                ((r) g.af(r.class)).a(BizBindWxaInfoPreference.this.mContext, (String) tag, null, 0, 0, null, appBrandStatObject, BizBindWxaInfoPreference.this.ksU.field_appId);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26914);
            }
        };
        this.BcZ = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(26915);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((t) g.af(t.class)).a(BizBindWxaInfoPreference.this.mContext, BizBindWxaInfoPreference.this.ksU.field_username, BizBindWxaInfoPreference.this.ksU.field_appId, BizBindWxaInfoPreference.this.olD);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(26915);
            }
        };
        AppMethodBeat.o(26920);
    }

    private void bBG() {
        WxaAttributes.WxaEntryInfo wxaEntryInfo;
        AppMethodBeat.i(26921);
        if (!this.BcX || this.olD == null) {
            AppMethodBeat.o(26921);
        } else if (!this.BcY) {
            AppMethodBeat.o(26921);
        } else {
            this.BcY = false;
            if (!this.olD.isEmpty()) {
                wxaEntryInfo = this.olD.get(0);
            } else {
                wxaEntryInfo = null;
            }
            if (wxaEntryInfo != null) {
                a(wxaEntryInfo, this.lIM, this.mPa);
            }
            this.olF.setText(this.mContext.getString(R.string.b9x, Integer.valueOf(this.olD.size())));
            fQ(this.olD);
            if (this.olD.size() == 1) {
                this.olE.setVisibility(0);
                this.olH.setTag(this.olD.get(0).username);
                this.olH.setOnClickListener(this.rID);
                AppMethodBeat.o(26921);
                return;
            }
            this.olE.setVisibility(8);
            this.olH.setTag(null);
            this.olH.setOnClickListener(this.BcZ);
            AppMethodBeat.o(26921);
        }
    }

    private void fQ(List<WxaAttributes.WxaEntryInfo> list) {
        AppMethodBeat.i(26922);
        this.olG.removeAllViews();
        if (list.isEmpty()) {
            AppMethodBeat.o(26922);
            return;
        }
        int size = list.size();
        int measuredWidth = this.olH.getMeasuredWidth();
        if (measuredWidth == 0) {
            measuredWidth = ogw.widthPixels;
        }
        int paddingLeft = (measuredWidth - this.olH.getPaddingLeft()) - this.olH.getPaddingRight();
        int i2 = paddingLeft / (olK + olJ);
        if (i2 > size) {
            this.olI.setVisibility(8);
        } else {
            this.olI.setVisibility(0);
            i2 = (paddingLeft - this.olI.getMeasuredWidth()) / (olK + olJ);
        }
        int min = Math.min(i2, size);
        if (min > 1) {
            for (int i3 = 0; i3 < min; i3++) {
                a(list.get(i3));
            }
        }
        Log.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", Integer.valueOf(list.size()));
        AppMethodBeat.o(26922);
    }

    private void a(WxaAttributes.WxaEntryInfo wxaEntryInfo) {
        AppMethodBeat.i(26923);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(olK + olJ, olK));
        imageView.setPadding(0, 0, olJ, 0);
        this.olG.addView(imageView);
        a(wxaEntryInfo, imageView, null);
        AppMethodBeat.o(26923);
    }

    private static void a(WxaAttributes.WxaEntryInfo wxaEntryInfo, ImageView imageView, TextView textView) {
        AppMethodBeat.i(26924);
        if (wxaEntryInfo == null) {
            AppMethodBeat.o(26924);
            return;
        }
        String str = wxaEntryInfo.username;
        if (imageView != null) {
            imageView.setTag(str);
            com.tencent.mm.modelappbrand.a.b.aXY().a(imageView, wxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
        }
        if (textView != null) {
            textView.setText(Util.nullAsNil(wxaEntryInfo.title));
        }
        AppMethodBeat.o(26924);
    }
}
