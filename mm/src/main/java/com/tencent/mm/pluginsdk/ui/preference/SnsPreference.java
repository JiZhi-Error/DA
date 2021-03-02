package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.g;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import java.util.LinkedList;
import java.util.List;

public final class SnsPreference extends Preference implements g {
    private bp DEv;
    private QDisFadeImageView Kqg;
    private QDisFadeImageView Kqh;
    private QDisFadeImageView Kqi;
    private QDisFadeImageView Kqj;
    private ImageView Kqk;
    private ImageView Kql;
    private ImageView Kqm;
    private ImageView Kqn;
    private a Kqo;
    private MMActivity gte;
    private List<cnb> list;
    private String mTitle;
    private int sUb;
    private View zlc;

    static class a extends ColorDrawable {
        public a() {
            super(-7829368);
        }
    }

    public SnsPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(31906);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(31906);
    }

    public SnsPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(31907);
        this.mTitle = "";
        this.Kqg = null;
        this.Kqh = null;
        this.Kqi = null;
        this.Kqj = null;
        this.Kqk = null;
        this.Kql = null;
        this.Kqm = null;
        this.Kqn = null;
        this.sUb = 255;
        this.list = new LinkedList();
        this.Kqo = new a();
        this.gte = (MMActivity) context;
        this.mTitle = context.getString(R.string.bfl);
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(31907);
    }

    public final void iv(List<cnb> list2) {
        ImageView imageView;
        ImageView imageView2;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(232349);
        if (this.Kqg != null) {
            this.Kqg.setImageResource(R.color.afz);
            this.Kqg.setVisibility(4);
        }
        if (this.Kqh != null) {
            this.Kqh.setImageResource(R.color.afz);
            this.Kqh.setVisibility(4);
        }
        if (this.Kqi != null) {
            this.Kqi.setImageResource(R.color.afz);
            this.Kqi.setVisibility(4);
        }
        if (this.Kqj != null) {
            this.Kqj.setImageResource(R.color.afz);
            this.Kqj.setVisibility(4);
        }
        if (this.Kqg != null && list2.size() > 0) {
            this.Kqg.setVisibility(0);
            if (!e.apn()) {
                this.Kqg.setImageResource(R.drawable.bjm);
                imageView2 = this.Kqk;
            } else {
                o.DCM.b(list2.get(0), this.Kqg, this.gte.hashCode(), this.DEv);
                imageView = this.Kqk;
                if (list2.get(0).oUv == 6) {
                    i2 = 0;
                    imageView.setVisibility(i2);
                } else {
                    imageView2 = imageView;
                }
            }
            i2 = 8;
            imageView = imageView2;
            imageView.setVisibility(i2);
        }
        if (this.Kqh != null && list2.size() >= 2) {
            this.Kqh.setVisibility(0);
            if (!e.apn()) {
                this.Kqh.setImageResource(R.drawable.bjm);
            } else {
                o.DCM.b(list2.get(1), this.Kqh, this.gte.hashCode(), this.DEv);
                this.Kql.setVisibility(list2.get(1).oUv == 6 ? 0 : 8);
            }
        }
        if (this.Kqi != null && list2.size() >= 3) {
            this.Kqi.setVisibility(0);
            if (!e.apn()) {
                this.Kqi.setImageResource(R.drawable.bjm);
            } else {
                o.DCM.b(list2.get(2), this.Kqi, this.gte.hashCode(), this.DEv);
                this.Kqm.setVisibility(list2.get(2).oUv == 6 ? 0 : 8);
            }
        }
        if (this.Kqj != null && list2.size() >= 4) {
            this.Kqj.setVisibility(0);
            if (!e.apn()) {
                this.Kqj.setImageResource(R.drawable.bjm);
                AppMethodBeat.o(232349);
                return;
            }
            o.DCM.b(list2.get(3), this.Kqj, this.gte.hashCode(), this.DEv);
            ImageView imageView3 = this.Kqn;
            if (list2.get(3).oUv != 6) {
                i3 = 8;
            }
            imageView3.setVisibility(i3);
        }
        AppMethodBeat.o(232349);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(31909);
        if (this.zlc == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.b90, viewGroup2);
            this.zlc = onCreateView;
        }
        View view = this.zlc;
        AppMethodBeat.o(31909);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(31910);
        super.onBindView(view);
        this.Kqg = (QDisFadeImageView) view.findViewById(R.id.dw0);
        this.Kqg.setAlpha(this.sUb);
        this.Kqg.setImageDrawable(this.Kqo);
        this.Kqh = (QDisFadeImageView) view.findViewById(R.id.dw1);
        this.Kqh.setAlpha(this.sUb);
        this.Kqh.setImageDrawable(this.Kqo);
        this.Kqi = (QDisFadeImageView) view.findViewById(R.id.dw2);
        this.Kqi.setAlpha(this.sUb);
        this.Kqi.setImageDrawable(this.Kqo);
        this.Kqj = (QDisFadeImageView) view.findViewById(R.id.dw3);
        this.Kqj.setAlpha(this.sUb);
        this.Kqj.setImageDrawable(this.Kqo);
        TextView textView = (TextView) view.findViewById(R.id.ld);
        if (!Util.isNullOrNil(this.mTitle)) {
            textView.setText(this.mTitle);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.em);
            textView.setLayoutParams(layoutParams);
        }
        this.Kqk = (ImageView) view.findViewById(R.id.i07);
        this.Kql = (ImageView) view.findViewById(R.id.i08);
        this.Kqm = (ImageView) view.findViewById(R.id.i09);
        this.Kqn = (ImageView) view.findViewById(R.id.i0_);
        this.Kqk.setVisibility(8);
        this.Kql.setVisibility(8);
        this.Kqm.setVisibility(8);
        this.Kqn.setVisibility(8);
        iv(this.list);
        if (view == null || this.list == null) {
            AppMethodBeat.o(31910);
            return;
        }
        view.setContentDescription(this.mContext.getString(R.string.fqg, Integer.valueOf(this.list.size())));
        AppMethodBeat.o(31910);
    }

    @Override // com.tencent.mm.ui.base.preference.g
    public final void bfe(final String str) {
        AppMethodBeat.i(31911);
        if (str == null) {
            AppMethodBeat.o(31911);
            return;
        }
        bg.aVF();
        as Kn = c.aSN().Kn(str);
        if (Kn != null && ((int) Kn.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn.field_type)) {
            this.DEv = bp.Oqp;
        } else if (str.equals(z.aTY())) {
            this.DEv = bp.Oqp;
        } else {
            this.DEv = bp.Oqq;
        }
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.preference.SnsPreference.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(232348);
                qw qwVar = new qw();
                qwVar.dXo.username = str;
                EventCenter.instance.publish(qwVar);
                final LinkedList linkedList = new LinkedList();
                if (qwVar.dXp.dXq != null) {
                    linkedList.add(qwVar.dXp.dXq);
                }
                if (qwVar.dXp.dXr != null) {
                    linkedList.add(qwVar.dXp.dXr);
                }
                if (qwVar.dXp.dXs != null) {
                    linkedList.add(qwVar.dXp.dXs);
                }
                if (qwVar.dXp.dXt != null) {
                    linkedList.add(qwVar.dXp.dXt);
                }
                SnsPreference.this.gte.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.ui.preference.SnsPreference.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(232347);
                        SnsPreference.this.list.clear();
                        SnsPreference.this.list.addAll(linkedList);
                        SnsPreference.this.iv(SnsPreference.this.list);
                        AppMethodBeat.o(232347);
                    }
                });
                AppMethodBeat.o(232348);
            }
        });
        AppMethodBeat.o(31911);
    }

    @Override // com.tencent.mm.ui.base.preference.g
    public final int grS() {
        AppMethodBeat.i(31912);
        int i2 = 0;
        if (this.list != null) {
            i2 = this.list.size();
        }
        AppMethodBeat.o(31912);
        return i2;
    }
}
